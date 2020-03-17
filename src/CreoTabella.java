import java.sql.*;

//Creazione di tabella/e
public class CreoTabella {

	public static void main(String[] args) 
	{
		
		String nomeDriver = "com.mysql.jdbc.Driver"; 
		String serverURL = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "";
		Statement st = null;
		
		try {
			//avvio il driver
			Class.forName(nomeDriver);
			
			//provo a connettermi al database
			System.out.println("Tentativo di connessione al server in corso...");
			Connection conn = DriverManager.getConnection(serverURL,user,password);
			System.out.println("Connesso!");
			System.out.println("Creo il database \"polpettina\"...");
			String query = "CREATE DATABASE IF NOT EXISTS polpettina";
			st = conn.createStatement();
			st.execute(query); // soltanto per CREATE
			
			query = "USE polpettina";
			st.execute(query);
			//st.executeUpdate(query); // soltanto per INSERT, DELETE, UPDATE
			//st.executeQuery(query); // soltanto per la SELECT
			System.out.println("Database \"polpettina\" creato con successo!");
			System.out.println("Creo le tabelle del db...");
			
			query = "CREATE TABLE provina ("+
					"IDProva INT PRIMARY KEY AUTO_INCREMENT,"+
					"nome VARCHAR(20) NOT NULL," +
					"cognome VARCHAR(20) NOT NULL," +
					"mestiere VARCHAR(30),"+
					"eta INT(2)"+
					")";
					
				st.execute(query);
				System.out.println("Tabella creata!");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
