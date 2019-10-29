package application;

import java.sql.*;
import java.util.ArrayList;

public class FermiConnector {
	
	private final String DB_URL = "jdbc:mysql://127.0.0.1:3306/fermi_base";
	private ArrayList<FermiEntry> data = new ArrayList<>(); 
	
	public FermiConnector() {
		try {
			Connection conn = DriverManager.getConnection(DB_URL, "root", "Redrobot!6");
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM hours_offered");
			
			while(result.next()) {
				data.add(new FermiEntry(result.getString(1), result.getString(2), result.getDouble(3),
						result.getInt(4), result.getBoolean(5)));
			}
			
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public ArrayList<FermiEntry> getData() {
		return data;
	}
}