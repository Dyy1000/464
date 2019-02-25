package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.ConcertsDB;
import lecture464.model.CreditCardsDB;
import lecture464.model.OrdersDB;
import lecture464.model.PerformanceDB;
import lecture464.model.ShoppingcartDB;
import lecture464.model.UserDB;

/**
 * Servlet implementation class CustomerTransactionConfirmation
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number=request.getParameter("cardnumber");
		String cvv=request.getParameter("cvv");
		String holder=request.getParameter("cardholder");
		String date=request.getParameter("date");
		String type=request.getParameter("type");
		String pdate=request.getParameter("currentdate");
		 
		HttpSession session = request.getSession();
		
		CreditCardsDB card =
				(CreditCardsDB)session.getAttribute("cardinfo");
		
		card = new CreditCardsDB();
		
		 session.setAttribute("cardinfo", card);
		card.verify(holder, number, type, cvv, date);
		card.setProccessdate(pdate);
		
		OrdersDB order=
				(OrdersDB)session.getAttribute("orderinfo");
		session.setAttribute("orderinfo", order);
		order = new OrdersDB();
		UserDB user=(UserDB)session.getAttribute("userinfo");
		ShoppingcartDB shoppingcart=(ShoppingcartDB)session.getAttribute("shoppingcartinfo");
		PerformanceDB performance =
				(PerformanceDB)session.getAttribute("concertinfo");
		 
		 order.insertorder(user.getId(), shoppingcart.getTotal(),card.getProccessdate(),card.getCardnumber());
		 order.insertorderitem(performance.getId(), shoppingcart.getQuantity());
		
		PrintWriter webWrite=response.getWriter();
		webWrite.println(number);
		response.sendRedirect("CustomerTransactionConfirmation.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
