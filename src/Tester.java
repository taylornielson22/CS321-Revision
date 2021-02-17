import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteDataSource;

public class Tester {
	public static SQLiteDataSource ds;
	public static Connection conn;
	public static String databaseName = "Tester.db";
	
	public static void main(String[] args) throws SQLException {
		ds = null;
		createDatabase();
		
		//create table
		Table table1 = new Table("test");
		table1.queryTable();
		
		//Insert two rows and then print table
		table1.insertRow("Taylor");		
		table1.insertRow("Kiley");
		table1.queryTable();
		
		//Change Kiley to Samantha and then print updated table
		table1.updateRow("Kiley", "Samantha");
		table1.queryTable();
		
		//Insert two rows and delete one, then print table
		table1.insertRow("Amit");
		table1.insertRow("amit");
		table1.deleteRow("amit");
		table1.queryTable();
		
		System.out.println(ds.getUrl());
		//delete table
		table1.deleteTable();
		
	}
	//Open/Create Database
	public static void createDatabase() {
		 try {
	            ds = new SQLiteDataSource();
	            ds.setUrl("jdbc:sqlite:" + databaseName );
	        } catch ( Exception e ) {
	            e.printStackTrace();
	            System.exit(0);
	        }

	        try  {
	        	conn = ds.getConnection();
	        } catch ( SQLException e ) {
	            e.printStackTrace();
	            System.exit( 0 );
	        }
	        System.out.println( "Opened/Created "+databaseName+" database successfully" );
		
	}
	
	
}

