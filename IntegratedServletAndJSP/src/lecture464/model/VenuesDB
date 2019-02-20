package lecture464.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 14025
 *
 */
public class VenuesDB {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/MVCApp"; 
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/qxia";
	
	

	//  Database credentials
	static final String USER = "qxia"; // Replace with your CSE_LOGIN
	static final String PASS = "PrL:7n";   // Replace with your CSE MySQL_PASSWORD

public void connectMeIn() {
	try{
		//Register the JDBC driver
		Class.forName("com.mysql.jdbc.Driver");			
	}catch(ClassNotFoundException e){
		System.err.println(e);
		System.exit (-1);
	}
	try {
		 //Open a connection
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	} catch (SQLException e){
		e.printStackTrace();
	}
}
public void closeConnection(){
	try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	public String[] getvenue (int row){
		connectMeIn();
		String SQL = "SELECT * from venue";
	    Statement stat;
	    int i=0;
		String data[]=new String[5];
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while (rs.next()){ //rs.next() is the next row
			i++;
			if(row==i){
				data[0]=rs.getString(1); //1st column
				data[1]=rs.getString(2); //2nd column
				data[2]=rs.getString(3); //3rd column
				data[3]=rs.getString(4); //4th column
				data[4]=rs.getString(5); //5th column				
			}        
		    }
	    stat.close();
        
	} catch (SQLException e) {
		e.printStackTrace();
	}
		/*
		 * public void Insertvenue(String VId, String VName,... String Addr, String OID,
		 * String City, String State, String PostalCode){ connectMeIn(); String SQL =
		 * "INSERT INTO concert (id,MovieName,Description,Rating) VALUES ("+
		 * Id+",'"+MovieName+"','"+Descrip+"','"+Rating+"')"; Statement stat; try { stat
		 * = conn.createStatement(); int rs = stat.executeUpdate(SQL); // stat.close();
		 * } catch (SQLException e) { e.printStackTrace(); }
		 */
			
		//closeConnection();
		
		
	//}
		
		
	closeConnection();
	return data;
}
}
