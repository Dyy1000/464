package lecture464.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lecture464.model.ConcertsDB;
import lecture464.model.HotelBean;



/**
 * Servlet implementation class VenueAndConcertSearchQuery
 */

public class VenueAndConcertSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VenueAndConcertSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		ConcertsDB concert =
				(ConcertsDB)session.getAttribute("concertinfo");
		
		concert = new ConcertsDB();
		
		  session.setAttribute("concertinfo", concert);
		concert.setMoviename("result not found");
		String search=request.getParameter("ConcertSearch");
        for(int i=0;i<concert.getcolumn();i++) {
     	   if(search.equals(concert.getconcert(i+1)[1])) {
     	        concert.setallvalue(search);
     		   
     		   
     	   }
     	   
     	  }
		
		
//		String hotelName = request.getParameter("hotelName");
//		String noOfRooms = request.getParameter("noOfRooms");
//		
//		HttpSession session = request.getSession();
//		
//		ConcertsDB concert =
//		(ConcertsDB)session.getAttribute("concertinfo");
////		HotelBean newHotel =
////			      (HotelBean)session.getAttribute("hotelInfo");
//		if(concert == null) {
//		concert = new ConcertsDB();
//		  session.setAttribute("concertinfo", concert);
//		}
////		 if (newHotel == null) {		    
////		     newHotel = new HotelBean();
////		     session.setAttribute("hotelInfo", newHotel);
////		 }
//
//		concert.setMoviename(hotelName);
//		concert.setId(Integer.parseInt(noOfRooms));
//		 
////			newHotel.setHotelName(hotelName);
////			newHotel.setNoOfRooms(Integer.parseInt(noOfRooms));

		
		
		
		

		response.sendRedirect("ConcertSearchResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
