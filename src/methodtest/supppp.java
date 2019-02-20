package methodtest;

import lecture464.model.ConcertsDB;
import lecture464.model.VenuesDB;



public class supppp {

	public static void main(String[] args) {
		ConcertsDB db = new ConcertsDB();
		

		System.out.println(db.getconcert(2)[1]);
		db.setallvalue("xxoo");
		
		System.out.println(db.getId()+" "+db.getMoviename());


	} 

}