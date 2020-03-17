import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Inserimento ulteriori dati in una tabella
public class DatiInTabellaAncora {

	public static void main(String[] args) throws SQLException 
	{
		
		String nomeDriver = "com.mysql.jdbc.Driver"; 
		String serverURL = "jdbc:mysql://localhost/";
		String user = "root";
		String password = "";
		Statement st = null;
		Connection conn = null;
		
		try {
			//avvio il driver
			Class.forName(nomeDriver);
			
			//provo a connettermi al database
			System.out.println("Tentativo di connessione al server in corso...");
			conn = DriverManager.getConnection(serverURL,user,password);
			System.out.println("Connesso!");
			System.out.println("Creo il database \"polpettina\"...");
			
			//String q = "DROP DATABASE IF EXISTS polpettina";
			String query = "CREATE DATABASE IF NOT EXISTS polpettina";
			st = conn.createStatement();
			//st.execute(q);
			
			st.execute(query); // soltanto per CREATE
			
			query = "USE polpettina";
			st.execute(query);
			//st.executeUpdate(query); // soltanto per INSERT, DELETE, UPDATE
			//st.executeQuery(query); // soltanto per la SELECT
			System.out.println("Database \"polpettina\" creato con successo!");
			System.out.println("Creo le tabelle del db...");
			
			query = "CREATE TABLE IF NOT EXISTS provina( "+
					"IDProva INT PRIMARY KEY AUTO_INCREMENT,"+
					"nome VARCHAR(20) NOT NULL," +
					"cognome VARCHAR(20) NOT NULL," +
					"mestiere VARCHAR(30)," +
					 "eta INT(2)"+
					")";
				st.execute(query);
				System.out.println("Tabella creata!");
				
				System.out.println("Provo a inserire un nome...");
				String qInserimento = "INSERT INTO provina (nome,cognome,mestiere,eta) VALUES(?,?,?,?)"; //il ? possiamo modificarlo col PreparedStatement
				PreparedStatement prepQ = conn.prepareStatement(qInserimento);
			/*	prepQ.setString(1,"Filippo"); //1 indica quale ? deve sostituire in VALUES(?)
											// nel nostro caso, siccome è il primo, si mette 1	
				prepQ.setString(2,"Opunzi");
				prepQ.setString(3,"Punzatore");
				prepQ.setString(4,"23");
				
				//le due righe qua sotto sono necessarie per ogni inserimento
				//per cui, in caso di 1, 2, o più inserimenti, per ognuno
				//tali righe sono obbligatorie 
				prepQ.executeUpdate();
				System.out.println("Nome inserito!");
				
				prepQ.setString(1,"Sara"); 
				prepQ.setString(2,"Dopo");
				prepQ.setString(3,"Indovina");
				prepQ.setString(4,"59");
				
				prepQ.executeUpdate();
				System.out.println("Nome inserito!");
			*/
				prepQ.setString(1,"Salvo"); 
				prepQ.setString(2,"Tanti");
				prepQ.setString(3,"Bagnino");
				prepQ.setString(4,"25");
				
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
