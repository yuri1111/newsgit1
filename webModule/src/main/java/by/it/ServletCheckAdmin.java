package by.it;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ServletCheckAdmin
 */
@WebServlet("/ServletCheckAdmin")
public class ServletCheckAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		ServiceCheckAdmin adminEnter = new ServiceCheckAdmin();
		if (adminEnter.checkAdmin(email, pass)){
			HttpSession sesEnter = request.getSession();
			sesEnter.setAttribute("adminEnter", "yes");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminController");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				Loger logWr = new Loger();
				logWr.logWrite("Failed to redirect");
				return;
			} catch (IOException e) {
				Loger logWr = new Loger();
				logWr.logWrite("Failed to redirect");
				return;
			}			
									
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admincheck.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				Loger logWr = new Loger();
				logWr.logWrite("lll");
				return;
			} catch (IOException e) {
				Loger logWr = new Loger();
				logWr.logWrite("lll");
				return;
			}

		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
