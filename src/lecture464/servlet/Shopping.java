package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.ShoppingcartDB;

/**
 * Servlet implementation class Shopping
 */
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ShoppingcartDB shoppingcart=(ShoppingcartDB)session.getAttribute("shoppingcartinfo");
		shoppingcart=new ShoppingcartDB(); 
		session.setAttribute("shoppingcartinfo", shoppingcart);
		 
		String conid=request.getParameter("conid");
		if(!(conid.equals("0"))) {
		String conqun=request.getParameter("conqun");
		String contype=request.getParameter("contype");
		String conname=request.getParameter("conname");
		String conthumb=request.getParameter("conthumb");
		String convenue=request.getParameter("convenue");
		String contime=request.getParameter("contime");
		String conprice=request.getParameter("conprice");
		int price=Integer.parseInt(conprice);
		int quantity=Integer.parseInt(conqun);
		int total=quantity*price; 
		shoppingcart.setvalue(conid, quantity, contype, conname, conthumb, convenue, contime, total);
		}else {
		shoppingcart.setvalue(conid, 0, "", "", "", "", "", 0);	
		}
		
		 
		response.sendRedirect("ViewAndCheckoutshoppingcart.jsp");
		PrintWriter out=response.getWriter();
		out.print("a");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
