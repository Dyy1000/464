package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCardsDB {
   private String cardholder="";
   private String cardnumber="";
   private String cardtype="";
   private String cvv="";
   private String expiredate="";
   private String proccessdate="";
   
public String getProccessdate() {
	return proccessdate;
}
public void setProccessdate(String proccessdate) {
	this.proccessdate = proccessdate;
}
public String getCardholder() {
	return cardholder;
}
public void setCardholder(String cardholder) {
	this.cardholder = cardholder;
}
public String getCardnumber() {
	return cardnumber;
}
public void setCardnumber(String cardnumver) {
	this.cardnumber = cardnumver;
}
public String getCardtype() {
	return cardtype;
}
public void setCardtype(String cardtype) {
	this.cardtype = cardtype;
}
public String getCvv() {
	return cvv;
}
public void setCvv(String cvv) {
	this.cvv = cvv;
}
public String getExpiredate() {
	return expiredate;
}
public void setExpiredate(String expiredate) {
	this.expiredate = expiredate;
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
public void empty() {
	  setCardholder("");
	  setCardnumber("");
	  setCardtype("");
	  setCvv("");
	  setExpiredate("");
	
	
}
public void verify(String name,String number,String type, String cvv,String date) {

	connectMeIn();
	String SQL = "SELECT * FROM creditcards;";
    Statement stat;
	try {
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(SQL);
		while (rs.next()){
          if(name.equals(rs.getString(2))&&number.equals(rs.getString(3))&&type.equals(rs.getString(5))
        		  &&cvv.equals(rs.getString(7))&&date.equals(rs.getString(8))) {
        	  
        	  setCardholder(name);
        	  setCardnumber(number);
        	  setCardtype(type);
        	  setCvv(cvv);
        	  setExpiredate(date);
        	  
        	  
          }
          ;

		}   
	        
	    
		
	    stat.close();
	        
	} catch (SQLException e) {
		e.printStackTrace();
	}
	closeConnection();

}
public boolean check(String name,String number,String type, String cvv,String date) {
    boolean x=false;
	connectMeIn();
	String SQL = "SELECT * FROM creditcards;";
    Statement stat;
	try {
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(SQL);
		while (rs.next()){
          if(name.equals(rs.getString(2))&&number.equals(rs.getString(3))&&type.equals(rs.getString(5))
        		  &&cvv.equals(rs.getString(7))&&date.equals(rs.getString(8))) {
        	  
               x=true;
        	  
        	  
          }
          ;

		}   
	        
	    
		
	    stat.close();
	        
	} catch (SQLException e) {
		e.printStackTrace();
	}
	closeConnection();
    return x;
    
}
}
