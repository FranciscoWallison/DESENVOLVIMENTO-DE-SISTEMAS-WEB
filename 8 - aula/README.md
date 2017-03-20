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