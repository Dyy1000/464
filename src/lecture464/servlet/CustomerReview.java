package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.ConcertsDB;
import lecture464.model.ReviewsDB;
import lecture464.model.UserDB;

/**
 * Servlet implementation class CustomerReview
 */
public class CustomerReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConcertsDB concert=new ConcertsDB();
		String review=request.getParameter("cusreview");
		String date=request.getParameter("date");
		String rating=request.getParameter("result");
		String id =request.getParameter("concertid");
		
		HttpSession session = request.getSession();
		UserDB user=(UserDB)session.getAttribute("userinfo");
		String userid=user.getId();
		ReviewsDB reviewinfo=new ReviewsDB();
		int reviewid=reviewinfo.getcolumn()+1;
		
		String sql=
				"insert into customerreviews (\n" + 
				"  `Id` ,\n" + 
				"  `concertID` ,\n" + 
				"  `userID`,\n" + 
				"  `ReviewDate`,\n" + 
				"  `Rating`,\n" + 
				"  `Review`\n" + 
				" \n" + 
				")values('"+reviewid+"','"+id+"','"+userid+"','"+date+"','"+rating+"','"+review+"');";
	    PrintWriter webWrite=response.getWriter();

       reviewinfo.insertReview(sql);
		webWrite.println(sql);
		response.sendRedirect("CustomerReviewConfirmation.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
