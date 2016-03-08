package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import hospital.Hospital;

public class Demo {

	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
	final String DB_USER = "orgos";
	final String DB_PASS = "admin";

	final static String DB_NAME = "hospital";
	final static String DB_TABLE_NAME = "cartons";

	Connection con = null;

	private static Demo instance;
	
	// ----------------------------------- MAIN METHOD ----------------------------------- //
	public static void main(String[] args) {

		Thread pirogov = new Thread(new Hospital());
		pirogov.start();
		
		Demo db = getInstance();
		
		try {
			Statement st = db.getInstance().getConnection().createStatement();
			
			String request = "INSERT INTO hospital.carton (first_name, last_name, telephone) VALUES ( ? , ? , ?)";
			st.executeQuery(request);
			
		} catch (SQLException e) {
			System.out.println("Erron in creating statement: " + e.getMessage());
		}
		
		

	}
	// ---------------------------------------------------------------------------------- //
	
	private Demo() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error loading driver: " + e.getMessage());
		}

		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			System.out.println("Error on connection to the DB: " + e.getMessage());
		}

		createSchema();
		addTablesToSchema();
	}

	private void createSchema() {
		try {
			String schemaQuery = "CREATE SCHEMA IF NOT EXISTS `lo` DEFAULT CHARACTER SET utf8";
			PreparedStatement ps = getInstance().getConnection().prepareStatement(schemaQuery);
			ps.executeUpdate();
			System.out.println("Schema loaded successfully !");

		} catch (SQLException e) {
			System.out.println("Error creating schema: " + e.getMessage());
		}

	}

	private void addTablesToSchema() {
		try {
			String tableQuery = "CREATE TABLE IF NOT EXISTS " + DB_NAME + "." + DB_TABLE_NAME;

			PreparedStatement ps = getInstance().getConnection().prepareStatement(tableQuery);

			ps.executeUpdate();
			System.out.println("Table loaded successfully !");

		} catch (SQLException e) {
			System.out.println("Error creating table: " + e.getMessage());
		}
	}

	public static Demo getInstance() {
		if (instance == null) {
			instance = new Demo();
		}

		return instance;
	}

	public Connection getConnection() {
		return con;
	}

	public void closeInstance() {
		try {
			con.close();
		} catch (SQLException e) {
		}
	}

}
