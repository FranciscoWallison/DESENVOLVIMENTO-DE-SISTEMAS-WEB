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


Atividade DDL Henrique Mota

```
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

