
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


//Creazione di un database
public class CreoDatabase {

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
			//st.executeUpdate(query); // soltanto per INSERT, DELETE, UPDATE
			//st.executeQuery(query); // soltanto per la SELECT
			System.out.println("Database \"polpettina\" creato con successo!");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
