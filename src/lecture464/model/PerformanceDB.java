package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PerformanceDB {
	private String id="";
	private String name="";
	private String venue="";
	private String starttime="";
	private String price="";
	private String thumbnail="";
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/ydeng";
	
	

	//  Database credentials
	static final String USER = "ydeng"; // Replace with your CSE_LOGIN
	static final String PASS = "j87aDc";   // Replace with your CSE MySQL_PASSWORD
	
	public void getconcert (String movie, String venue){
		connectMeIn();
		String SQL = "SELECT concert.`Movie name`,venue.Name,performance.StartTime,TicketVenuePrices.TicketPrice,concert.Thumbnail,performance.Id\n" + 
				"FROM (((performance\n" + 
				"INNER JOIN concert ON performance.concertID = concert.id)\n" + 
				"inner join venue on performance.venueID = venue.Id)\n" + 
				"inner join TicketVenuePrices on performance.Id = TicketVenuePrices.performanceID);";
	    Statement stat;


		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while (rs.next()){

			    if(movie.equals(rs.getString(1))&&venue.equals(rs.getString(2))) {
			    setId(rs.getString(6));	
				setName(rs.getString(1));
				setVenue(rs.getString(2));
				setStarttime(rs.getString(3));
				setPrice(rs.getString(4));
				setThumbnail(rs.getString(5));
			    }
			
		        
		        
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
		

	
	}
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 
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
	public int getcolumn () {
		String x="";
		connectMeIn();
		String SQL = "SELECT count(*) from performance";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			while (rs.next()){
              x=rs.getString(1);

			}   
		        
		    
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		int y=Integer.parseInt(x);
		return y;
	}
	
}
