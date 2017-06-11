import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCSV {

	public static void main(String[] args) throws SQLException, IOException {
		// CSV file Path
		String fileName = "Z:\\tmp\\data.csv";
		Statement stmt = null;
		FileWriter fw = null;
		Connection conn = null;
		try {
			fw = new FileWriter(fileName);
			
			// get connections
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DATABASENAME", "root", "root");
			stmt = conn.createStatement();
			
			// create index to improves the speed of operations in a table.
			stmt.executeUpdate("CREATE INDEX time_index ON location (timestamp)");
	
			//execute query
			ResultSet myRs = stmt.executeQuery(
					"SELECT * FROM location WHERE timestamp BETWEEN '2017-05-01 00:00:00.000000' AND '2017-05-01 23:59:59.999999'");			
			 
			java.sql.ResultSetMetaData metaDeta = myRs.getMetaData();					
			int count = metaDeta.getColumnCount();
			
			//Add column name
			for (int i = 1; i <= count; i++) {
				fw.append(metaDeta.getColumnLabel(i));
				fw.append(',');
			}

			//Add row data to CSV file
			while (myRs.next()) {
				fw.append('\n');
				for (int i = 1; i <= count; i++) {
					fw.append(myRs.getString(i));
					fw.append(',');
				}
			}

			System.out.println("CSV File is created successfully.");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (stmt != null) stmt.executeUpdate("DROP INDEX time_index ON location");
			if(conn!=null) conn.close();
			if (fw != null) {
				fw.flush();
				fw.close();
			}			
		}
	}

}
