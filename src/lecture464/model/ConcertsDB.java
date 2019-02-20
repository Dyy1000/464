package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConcertsDB {
	private int id=0;
	private String moviename="result not found";
	private String description="x";
	private String thumbnail ="x";
	private String rating ="x";
	
	
	public ConcertsDB() {
		super();
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

    public void setallvalue(String name) {
           for(int i=0;i<getcolumn();i++) {
        	   if(name.equals(getconcert(i+1)[1])) {
        	   
        	   setId(Integer.parseInt(getconcert(i+1)[0]));
        	   setMoviename(getconcert(i+1)[1]);
        	   setDescription(getconcert(i+1)[2]);
        	   setThumbnail(getconcert(i+1)[3]);
        	   setRating(getconcert(i+1)[4]);
        	   
        	   }
           }
        	   
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
	
	public String[] getconcert (int col){
		connectMeIn();
		String SQL = "SELECT * from concert";
	    Statement stat;
	    int i=0;
		String data[]=new String[5];
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);

			while (rs.next()){
			i++;
			if(col==i){
				data[0]=rs.getString(1);
				data[1]=rs.getString(2);
				data[2]=rs.getString(3);
				data[3]=rs.getString(4);
				data[4]=rs.getString(5);
				
			}
		        
		        
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return data;
		

	
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
	public void displayAllUsers() {
		connectMeIn();
		String SQL = "SELECT * from concert";
	    Statement stat;
	    int i=0;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
			
		        System.out.println(rs.getString(2).charAt(2));
		        
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
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
		String SQL = "SELECT count(*) from concert";
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
