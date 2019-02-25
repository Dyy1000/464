package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VenuesDB {
	private int id=0;
	private String name="";
	private String address="";
	private int owerID =0;
	private String city ="";
	private String state="";
	private String postalCode ="";
	private String price="";
	
	
	
	public VenuesDB() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOwerID() {
		return owerID;
	}
	public void setOwerID(int owerID) {
		this.owerID = owerID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}

    public void findvenueprice(String input) {
		connectMeIn();
		String SQL = "SELECT venue.Name, TicketVenuePrices.TicketPrice\n" + 
				"FROM venue\n" + 
				"INNER JOIN TicketVenuePrices ON venue.Id=TicketVenuePrices.venueID;";
	    Statement stat;
	    int i=0;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
			    if(rs.getString(1).equals(input)) {
		        setPrice(rs.getString(2));
			    }
		        
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();

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
	
	
	public int getcolumn () {
		String x="";
		connectMeIn();
		String SQL = "SELECT count(*) from venue";
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
	public String[] getvenue (int col){
		connectMeIn();
		String SQL = "SELECT * from venue";
	    Statement stat;
	    int i=0;
		String data[]=new String[7];
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
				data[5]=rs.getString(6);
				data[6]=rs.getString(7);
				
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
		String SQL = "SELECT * from venue";
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

}
