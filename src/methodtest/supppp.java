package methodtest;

import lecture464.model.ConcertsDB;
import lecture464.model.CreditCardsDB;
import lecture464.model.PerformanceDB;
import lecture464.model.ReviewsDB;
import lecture464.model.VenuesDB;



public class supppp {

	public static void main(String[] args) {
		CreditCardsDB db = new CreditCardsDB();
		db.verify("Deng Yag", "8888888888888888", "master", "111", "2020-08-07");
		System.out.print(db.getCardholder());
		System.out.print(db.getCardnumber());




	} 

}