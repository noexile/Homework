package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PersonalInformationServlet")
public class PersonalInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean allGood = true;
		boolean noGood = false;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		char[] ageChecker = age.toCharArray();
		
		if (firstName == null || lastName == null || firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
			allGood = false;
			noGood = true;
		}

		if (!noGood) {
			if (age != null) {
				for (int i = 0; i < ageChecker.length; i++) {
					if (!Character.isDigit(ageChecker[i])) {
						allGood = false;
						break;
					}
				}	
			} else {
				allGood = false;
			}
		}
		
		if (!allGood) {
			response.sendRedirect("errorPageForName.html");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("age", age);
		
		response.sendRedirect("address.html");		
	}

}
