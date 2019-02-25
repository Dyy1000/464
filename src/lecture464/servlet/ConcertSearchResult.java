package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.ConcertsDB;
import lecture464.model.ReviewsDB;


/**
 * Servlet implementation class ConcertSearchResult
 */

public class ConcertSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertSearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter webWrite=response.getWriter();
//		webWrite.println("aaa");
		String concert=request.getParameter("concert");
		String venue=request.getParameter("venue");
		String time=request.getParameter("time");
		String price=request.getParameter("price");
				HttpSession session = request.getSession();
		 
				ConcertsDB concerts = 
						(ConcertsDB)session.getAttribute("concertthing");
				
				concerts = new ConcertsDB();
				
				 session.setAttribute("concertthing", concerts);
				 concerts.setallvalue(concert);
				 concerts.setVenue(venue);
				 concerts.setStarttime(time);
				 concerts.setPrice(price);
				 
				 ReviewsDB review=
						 (ReviewsDB)session.getAttribute("reviewinfo");
				 review = new ReviewsDB();
				 session.setAttribute("reviewinfo",review);
				 review.setReview(concert);
				 
				

		
		response.sendRedirect("ConcertDetailandSelection.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
