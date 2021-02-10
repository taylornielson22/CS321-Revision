import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {
	public static String table = null;
	
	Table(String name) throws SQLException{
		table = name;
		String query = "CREATE TABLE IF NOT EXISTS " + name + " (" + "ID INTEGER PRIMARY KEY, "
				+ "NAME TEXT NOT NULL)";
		int rv = execute(query);
		System.out.println("Table Created: " + table);
		System.out.println("	executeUpdate() returned " + rv);

	}

	public static void insertRow(String input) throws SQLException {
		String query = "INSERT INTO " + table + " ( NAME ) VALUES ('" + input + "')";
		int rv = execute(query);
		System.out.println("Inserted Row: " + table);
		System.out.println("	executeUpdate() returned " + rv);
	}

	public static void updateRow(String old, String update) throws SQLException {
		String query = "UPDATE " + table + " SET  NAME  = '" + update + "' WHERE  NAME  = '" + old + "'";
		int rv = execute(query);
		System.out.println("Updated Row: " + table);
		System.out.println("	executeUpdate() returned " + rv);
	}

	public static void deleteRow(String delete) throws SQLException {
		String query = "DELETE FROM "+table+" WHERE NAME = '"+delete+"'";
		int rv = execute(query);
		System.out.println("Deleted Row: " + table);
		System.out.println("	executeUpdate() returned " + rv);
	}
	public static void deleteTable() throws SQLException {
		String query = "DROP TABLE IF EXISTS "+table;
		int rv = execute(query);
		System.out.println("Delete Table: " + table);
		System.out.println("	executeUpdate() returned " + rv);
	}
	
	public static void queryTable() throws SQLException {
		String query = "SELECT * FROM "+table;
		Statement stmt = Tester.conn.createStatement(); 
		ResultSet rs = stmt.executeQuery(query);
		
		 System.out.println();
		 System.out.println("Print Table: "+ table);
		 System.out.println("	ID    NAME");
		 System.out.println("	-------------------");
		while ( rs.next() ) {
            int id = rs.getInt( "ID" );
            String name = rs.getString( "NAME" );
            System.out.println("	" + id + "     " + name );;
        }
		 System.out.println("	-------------------");
		 System.out.println();
	
	}
	
	public static int execute(String query) throws SQLException {
		Statement stmt = Tester.conn.createStatement();
		return stmt.executeUpdate(query);
		
	}
}

