## Desenvolvimento-de-Sistemas-Web

## Lado Servido - O que sera aprendido . #JAVA 
    Servlets/JSP
    JDBC
    Padrões de Desenvolvimento
    Sessão
 AV1
## Lado Cliente - O que sera aprendido . #JavaScript 
    Variáveis
    Tipos
    Funções
    Ajax (PURO)
 AV2




## Pense assim, a linguagem SQL é uma só, porém ela é dividida em tipos de acordo com a funcionalidade dos comandos.
# [Os tipos da linguagem SQL são:](https://pt.stackoverflow.com/questions/262867/o-que-s%C3%A3o-as-siglas-ddl-dml-dql-dtl-e-dcl)  
```
DDL - Data Definition Language - Linguagem de Definição de Dados.
São os comandos que interagem com os objetos do banco.
```
```
São comandos DDL : CREATE, ALTER e DROP
DML - Data Manipulation Language - Linguagem de Manipulação de Dados.
São os comandos que interagem com os dados dentro das tabelas.
```
```
São comandos DML : INSERT, DELETE e UPDATE
DQL - Data Query Language - Linguagem de Consulta de dados.
São os comandos de consulta.
```
```
São comandos DQL : SELECT (é o comando de consulta)
Aqui cabe um parenteses. Em alguns livros o SELECT fica na DML em outros tem esse grupo próprio.
DTL - Data Transaction Language - LInguage de Transação de Dados.
São os comandos para controle de transação.
```
```
São comandos DTL : BEGIN TRANSACTION, COMMIT E ROLLBACK
DCL - Data Control Language - Linguagem de Controle de Dados.
São os comandos para controlar a parte de segurança do banco de dados.
```
```
São comandos DCL : GRANT, REVOKE E DENY.
```

## Conect banco  MySQL
```
mysql -u root -p suasenha
``` 
## Mostrar DB's
```
show databases;
```

## Ler aquivo sql
```
source nomedoseuarquivo.sql <enter>
```
## Config mysql 
``` 
SHOW PROCESSLIST;
KILL {id};
alter table CLIENTE convert to character set utf8 collate utf8_general_ci
```

## Git trocar url
```
git remote rename origin old_origin .
git remote add origin https://franciscowallison....
```
## Git commit prod
```
git reset --hard .
git pull origin master -f .
```
## Git edit commit
```
git commit --amend
git rebase --continue
```

## Motivos para usar Microserviços
```
Aplicação descentralizada
Equipes trabalhando simultaneamente
Ferramenta certa para cada serviço
Recontrução de codigo mais rápido (se necessário)
Manutenção facilitada
Escalabilidade aprimorada
``` 

## Motivos para usar DDD do livro: [Domain-Driven Design in PHP](https://books.google.com.br/books/about/Domain_Driven_Design_in_PHP.html?id=4nc5DwAAQBAJ&source=kp_cover&redir_esc=y)  
```
• O software não deve apenas fazer sentido para os codificadores, mas também para os negócios. 
DDD simpatiza certificando-se de que os negócios e o software falem o mesmo idioma.
• As prioridades de software estão alinhadas com as prioridades de negócios.
• Com o DDD, todos aprendem e contribuem para descobrir o domínio comercial.
• O conhecimento não pertence mais apenas aos desenvolvedores, com o DDD todos sabem o que 
está acontecendo com o negócio.
• Não há traduções entre especialistas em domínios, o que significa perda de informações ou tédio
sincronizando. Todo mundo fala o mesmo idioma.
• O design é o código e o código é o design, a única verdade implementada para o comum
língua. Focado na entrega de software continuamente por meio de processos ágeis de descoberta.
• DDD fornece uma estrutura para design estratégico e tático. Estratégico para identificar o ponto mais
áreas importantes a serem desenvolvidas com base no valor comercial e táticas sobre 
construções testadas em batalha blocos e padrões.
```


