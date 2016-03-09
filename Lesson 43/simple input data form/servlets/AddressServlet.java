package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		
		if (country == null || city == null || street == null || country.trim().isEmpty() || city.trim().isEmpty() || street.trim().isEmpty()) {
			response.sendRedirect("errorPageForAddress.html");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("country", country);
		session.setAttribute("city", city);
		session.setAttribute("street", street);
		
		response.sendRedirect("university.html");
	}

}
