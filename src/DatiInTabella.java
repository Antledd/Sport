import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Inserimento dati in una tabella
public class DatiInTabella {

	public static void main(String[] args) throws SQLException 
	{
		
		String nomeDriver = "com.mysql.jdbc.Driver"; 
		String serverURL = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "";
		Statement st = null;
		PreparedStatement prepQ = null;
		Connection conn = null;
		
		try {
			//avvio il driver
			Class.forName(nomeDriver);
			
			//provo a connettermi al database
			System.out.println("Tentativo di connessione al server in corso...");
			conn = DriverManager.getConnection(serverURL,user,password);
			System.out.println("Connesso!");
			System.out.println("Creo il database \"polpetta\"...");
			
			String q = "DROP DATABASE IF EXISTS polpettina";
			String query = "CREATE DATABASE IF NOT EXISTS polpettina";
			st = conn.createStatement();
			st.execute(q);
			
			st.execute(query); // soltanto per CREATE
			
			query = "USE polpettina";
			st.execute(query);
			//st.executeUpdate(query); // soltanto per INSERT, DELETE, UPDATE
			//st.executeQuery(query); // soltanto per la SELECT
			System.out.println("Database \" polpettina\" creato con successo!");
			System.out.println("Creo le tabelle del db...");
						
			query = "CREATE TABLE IF NOT EXISTS provina ( "+
					"IDProva INT PRIMARY KEY AUTO_INCREMENT,"+
					"nome VARCHAR(20) NOT NULL," +
					"cognome VARCHAR(20) NOT NULL, " +
					"mestiere VARCHAR(30),"+
					"eta INT(2)"+
					")";
				st.execute(query);
				System.out.println("Tabella creata!");
				
				System.out.println("Provo a inserire un nome...");
				String qInserimento = "INSERT INTO provina (nome,cognome,mestiere,eta) VALUES(?,?,?,?)"; //il ? possiamo modificarlo col PreparedStatement
				prepQ = conn.prepareStatement(qInserimento);
				prepQ.setString(1,"Paperone"); //1 indica quale ? deve sostituire in VALUES(?)
											// nel nostro caso, siccome è il primo, si mette 1	
				prepQ.setString(2,"Chiacchierone");
				prepQ.setString(3, "Cialtrone");
				prepQ.setInt(4, 34);
				
				prepQ.executeUpdate();
				System.out.println("Nome inserito!");
				
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null)
			{
			conn.close();
			}
		}

	}

}