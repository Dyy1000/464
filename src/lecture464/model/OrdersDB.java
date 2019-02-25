package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersDB {
	  private int id;
	  private String customerid;
	  private int TotalCost; 
	  private String OrderDate;
	  private String BillingAddress;
	  private String CreditCardNumber; 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public int getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(int totalCost) {
		TotalCost = totalCost;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}

	public String getCreditCardNumber() {
		return CreditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
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
	public void insertorder(String cusid, int total,String date,String card) {
		int id=getcolumn();
		
		connectMeIn();
		String sql=
		"insert into orders (\n" + 
		"  `Id` ,\n" + 
		"  `CustomerId`,\n" + 
		"  `TotalCost`,\n" + 
		"  `OrderDate`,\n" + 
		"  `BillingAddress`,\n" + 
		"  `CreditCardNumber` \n" + 
		") values ('"+(id+1)+"','"+cusid+"','"+total+"','"+date+"','N17 street','"+card+"');";
	    Statement stat;
	    System.out.println(sql);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
	
		        
		    
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();

	}
	public void insertorderitem(String perid, int quan) {
		int id=getitemcolumn();
		
		connectMeIn();
		String sql=
		"insert into orderitems (\n" + 
		"  `Id` ,\n" + 
		"  `OrderId` ,\n" + 
		"  `PerformanceID`,\n" + 
		"  `Quantity` \n" + 
		") values ('"+(id+1)+"','"+(id+1)+"','"+perid+"','"+quan+"');";
	    Statement stat;
	    System.out.println(sql);
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
	
		        
		    
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		
	}
	public int getcolumn () {
		String x="";
		connectMeIn();
		String SQL = "SELECT count(*) from orders";
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
	
	public int getitemcolumn () {
		String x="";
		connectMeIn();
		String SQL = "SELECT count(*) from orderitems";
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
