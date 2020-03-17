
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Selezione-prelievo dati da una tabella (uso di SELECT)
public class SelezionePrelievoDati {

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
			Class.forName(nomeDriver); //il Driver è mysql-connector-java-5.1.23-bin.jar
										// che deve essere presente nelle Referenced Libraries
			
			//provo a connettermi al database
			System.out.println("Tentativo di connessione al server in corso...");
			conn = DriverManager.getConnection(serverURL,user,password);
			System.out.println("Connesso!");
				
			String query = "CREATE DATABASE IF NOT EXISTS polpettina";
			st = conn.createStatement();
				
			query = "USE polpettina";
			st.execute(query);
				
				Statement st2 = conn.createStatement();
				String qLettura = "SELECT IDProva, nome,cognome,mestiere,eta FROM provina";
				ResultSet ris = st2.executeQuery(qLettura);
				
				if(!ris.wasNull())//wasNull(): funzione che dice
								  // se il risultato è nullo 
				{
				while(ris.next()) { // tradotto: finché c'è qualcosa da leggere
					int id = ris.getInt("IDProva");
					String nome = ris.getString("nome");
					String cognome = ris.getString("cognome");
					String mestiere = ris.getString("mestiere");
					int eta = ris.getInt("eta");
					System.out.print( id + " ");
					System.out.print(nome + " ");
					System.out.print(cognome + ", ");
					System.out.print(mestiere +", ");
					System.out.print("di anni " + eta + "\n");
				}
				ris.close();
				}
				else
				{
					System.out.println("Non ho letto niente!");
				}
				
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