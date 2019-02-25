package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewsDB {
	private String person="";
	private String date="";
	private String rating="";
	private String content="";
	

	
	
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public void insertReview (String SQL) {
		connectMeIn();
	    Statement stat;

 
			try {
				stat = conn.createStatement();
				 stat.executeUpdate(SQL);

				
			        
			        
			    
			
			    stat.close();
			        
			} catch (SQLException e) {
				e.printStackTrace();
			}
		closeConnection();
	}
	public void setReview (String movie){
		connectMeIn();
		String SQL = "SELECT users.FirstName,users.LastName,customerreviews.ReviewDate,customerreviews.Rating,customerreviews.Review, concert.`Movie name`\n" + 
				"FROM ((customerreviews\n" + 
				"INNER JOIN concert ON customerreviews.concertID=concert.id)\n" + 
				"inner join users on users.Id=customerreviews.userID);";
	    Statement stat;

 
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while (rs.next()){

			    if(movie.equals(rs.getString(6))) {
				setPerson(rs.getString(1)+" "+rs.getString(2));
				setDate(rs.getString(3));
				setRating(rs.getString(4)+" Star");
				setContent(rs.getString(5));
			    }
			
		        
		        
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
		

	
	}
	public void submit(String name) {
		int id = getcolumn()+1;
		
		
		
		
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
		String SQL = "SELECT count(*) from customerreviews";
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
