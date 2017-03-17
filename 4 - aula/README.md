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


```


