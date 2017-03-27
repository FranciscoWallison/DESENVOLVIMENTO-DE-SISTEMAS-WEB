## JDBC 
	CONNECTION
	DRIVER MANAGER
	STATEMENT
	 ```
		ExecuteQuery -> select
		ExecuteUpdate -> tudo q não for "Select"
	 ```
	PREPARE STATEMENT
	RESULTSET
## Criando
	Seviços -> JAVA DB -> CRIAR BANCO DE DADOS... 
	
	```
	try{
		Class.forName("org.apache.deby.jdbc.ClientDrive");
		c = DriveManager.getConnection(
			"jdbc:derby://localhost:1527/estoque", "nbuser", "nbuser"
		);
	
	}catch(ClassNotFoundException ex){
		System.err.println("Falta o drive!");
	}finally{
		return c;
	}
	```
## javaDB
	1- PROJETO -> PROPRIEDADE -> BIBLIOTECAS -> ADICIONAR JAR/PASTA -> ``` PROCURAR PASTA GLASS ```
	2- SEVIÇOS -> JAVA DB -> PROPRIEDADE -> INSTALAÇÃO DE JAVA DB " PROCURAR PASTA ``` C:\Program Files\glassfish-4.1.1\javadb``` "
	3- CONECTAR ``` JDBC:DERBY ```  