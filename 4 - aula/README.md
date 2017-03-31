## Desenvolvimento-de-Sistemas-Web

## 4 - aula
    * doGet e doPost
    * Redirecionamento
		explo:  response.sendRedirect(“http://www.endereco.com/”)
    * Encaminhamento
		explo: 	RequestDispatcher rd = request.getRequestDispatcher(“/Servlet”);
				rd.forward(request, response);

    * Atributo 
    
    
    
  Exeicio 
  ```
    CREATE TABLE paciente (
idPaciente INT NOT NULL PRIMARY KEY,
nomePaciente VARCHAR(100) NOT NULL,
nomeCidade VARCHAR(100) NOT NULL DEFAULT 'Nao Informado'
);

CREATE TABLE medico (
idMedico INT NOT NULL PRIMARY KEY,
nomeMedico VARCHAR(100) NOT NULL DEFAULT 'Nao Informado',
hospital VARCHAR(100) NOT NULL DEFAULT 'Nao Informado'
);

CREATE TABLE consulta(
idConsulta INT NOT NULL PRIMARY KEY,
idMedico INT NOT NULL REFERENCES medico ( idMedico )
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
idPaciente INT NOT NULL REFERENCES paciente ( idPaciente )
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
dataConsulta TIMESTAMP NOT NULL CHECK ( dataConsulta >= CURRENT_DATE )
);

CREATE TABLE receita(
idReceita INT NOT NULL,
idConsulta INT NOT NULL REFERENCES consulta (idConsulta)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
nomeMedicamento VARCHAR(100) NOT NULL,
PRIMARY KEY (idReceita, idConsulta)
);

Execicio 
create table categoria (
	codigo int not null primary key,
	descricao varchar(100) not null
);

create table filme (
	codigo int not null primary key,
	nome varchar(100) not null,
	categoria_codigo int not null references categoria (codigo)
		on delete restrict
		on update cascade,
	nacional boolean not null default false
);

create table prateleira (
	codigo int not null primary key,
	descricao varchar(100) not null,
	altura int not null default 100,
	capacidade int not null default 0
);

create table dvd (
	codigo int not null primary key,
	filme_codigo int not null references filme (codigo)
		on delete cascade
		on update cascade,
	prateleira_codigo int references prateleira (codigo)
		on delete restrict
		on update restrict
);
```

Atividade DDL Henrique Mota

```

AT-1

I.

CREATE TABLE Funcionarios(
	cod int not null,
	nome varchar(100) not null,
	nasc data not null,
	sexo char(1),
	departamento_cod int not null
);


II.

CREATE TABLE Departamentos(
	cod int not null,
	nome varchar(50) not null
);


III.

ALTER TABLE Funcionarios ADD PRIMARY KEY (cod);
ALTER TABLE Funcionarios ADD CHECK (nasc <= CURRENT_DATE);
ALTER TABLE Funcionarios ADD CHECK (sexo IN ('m', 'f');
ALTER TABLE Departamentos ADD PRIMARY KEY (cod);
ALTER TABLE Funcionarios ADD FOREIGN KEY (departamento_cod)
	REFERENCES Departamentos (cod)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;


IV.

ALTER TABLE Funcionarios ADD CPF int not null;


V.

ALTER TABLE Funcionarios DROP PRIMARY KEY;


VI.

AT-2

ALTER TABLE Funcionarios ALTER COLUMN CPF PRIMARY KEY;
ALTER TABLE Funcionarios DROP COLUMN cod;


create table ator (
	cod_ator int not null primary key,
	nome_ator varchar(100) not null
);

create table genero (
	cod_genero int not null primary key,
	descr_genero varchar(100) not null
);

create table categoria (
	cod_cat int not null primary key,
	descr_cat varchar(100) not null
);

create table cliente (
	cod_cli int not null primary key,
	nome_cli varchar(100) not null,
	end_cli varchar(100) not null,
	cidade_cli varchar(100) not null,
	uf_cli varchar(100) not null,
	fone_cli varchar(100) not null,
	cpf_cli varchar(100)  not null,
	rg_cli varchar(100)  not null,
	UNIQUE (cpf_cli , rg_cli)
);


create table autorizado (
	cod_aut int not null primary key,
	nome_aut varchar(100) not null,
	cod_cli int not null references cliente (cod_cli)
		on delete restrict
		on update cascade,
);


create table filme (
	cod_filme int not null primary key,
	nome_filme varchar(100) not null,
	cod_cat int not null references categoria (cod_cat)
		on delete restrict
		on update cascade,
	cod_gen int not null references genero (cod_gen)
		on delete restrict
		on update cascade,
	nome_diretor varchar(100) not null,
);

create table ator_filme (
	cod_ator int not null primary key,
	cod_filme int not null references filme (cod_filme)
		on delete restrict
		on update cascade,
);

create table midia (
	cod_midia int not null primary key,
	cod_filme int not null references filme (cod_filme)
		on delete restrict
		on update cascade,
	tipo_midia varchar(100) not null,
	formato varchar(100) not null,
	idioma varchar(100) not null,
);

create table locacao (
	cod_loc int not null primary key,
	data timestamp not null check (data >=  data_loc),
	cod_cli int not null references cliente (cod_cli)
		on delete restrict
		on update cascade,
);

create table midia_locacao (
	cod_midia int not null primary key,
	cod_loc int not null references locacao (cod_loc)
		on delete restrict
		on update cascade,
	idioma varchar(100) not null,
	valor_locacao double DEFAULT NULL,
	data timestamp not null check (data >=   data_devolucao),
);
```
Atividade dia 30/03 
```
CREATE TABLE ramo_atividade (
cd_ramo INT NOT NULL PRIMARY KEY,
ds_ramo VARCHAR(100) NOT NULL
);
CREATE TABLE tipo_assinante (
cd_tipo INT NOT NULL PRIMARY KEY,
ds_tipo VARCHAR(100) NOT NULL
);

CREATE TABLE assinante (
cd_assinante INT NOT NULL PRIMARY KEY,
nm_assinante VARCHAR(100) NOT NULL,
cd_ramo int references ramo_atividade (cd_ramo)
  	on delete restrict
  	on update cascade,
 cd_tipo int references tipo_assinante (cd_tipo)
  	on delete restrict
  	on update cascade
);

CREATE TABLE municipio (
cd_municipio INT NOT NULL PRIMARY KEY,
ds_municipio VARCHAR(100) NOT NULL
);

CREATE TABLE endereco (
cd_endereco INT NOT NULL PRIMARY KEY,
ds_endereco VARCHAR(100) NOT NULL,
complemtento VARCHAR(100),
bairro VARCHAR(100) NOT NULL,
cep VARCHAR(100) NOT NULL,
cd_assinante int references assinante (cd_assinante)
  	on delete restrict
  	on update cascade,
 cd_municipio int references municipio (cd_municipio)
  	on delete restrict
  	on update cascade
);

CREATE TABLE telefone (
cd_telefone INT NOT NULL PRIMARY KEY,
ddd VARCHAR(100) NOT NULL,
n_fone VARCHAR(100),
cd_endereco int references endereco (cd_endereco)
  	on delete restrict
  	on update cascade
);
```


