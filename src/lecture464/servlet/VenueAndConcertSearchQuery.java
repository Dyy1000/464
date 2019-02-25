package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.PerformanceDB;





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
		
		PerformanceDB performance =
				(PerformanceDB)session.getAttribute("concertinfo");
		
		performance = new PerformanceDB();
		
		 session.setAttribute("concertinfo", performance);
		performance.setName("result not found");
		String search=request.getParameter("ConcertSearch");
        String venue=request.getParameter("venue");
     	 performance.getconcert(search,venue);
     	  

 

         
//         PrintWriter out=response.getWriter();
//         out.print(search);
//         out.print(venue);
//         out.print(concerts);
		
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
