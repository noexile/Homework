package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GatheredInformationServlet")
public class GatheredInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		String age = (String) session.getAttribute("age");
		String country = (String) session.getAttribute("country");
		String city = (String) session.getAttribute("city");
		String street = (String) session.getAttribute("street");
		String universityName = (String) session.getAttribute("universityName");
		String faculty = (String) session.getAttribute("faculty");
		String specialty = (String) session.getAttribute("specialty");
		

		PrintWriter pr = response.getWriter();
		pr.println("<html>");
			pr.println("<h2>");
				pr.println("<Regester information:>");
			pr.println("</h2>");
			pr.println("<table>");
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("First Name: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(firstName);
					pr.println("</td>");
				pr.println("</tr>");
				
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Last Name: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(lastName);
					pr.println("</td>");
				pr.println("</tr>");
			
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Age: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(age);
					pr.println("</td>");
				pr.println("</tr>");
			
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("University: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(universityName);
					pr.println("</td>");
				pr.println("</tr>");
			
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Faculty: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(faculty);
					pr.println("</td>");
				pr.println("</tr>");
		
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Specialty: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(specialty);
					pr.println("</td>");
				pr.println("</tr>");
			
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Country: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(country);
					pr.println("</td>");
				pr.println("</tr>");		
		
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("City: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(city);
					pr.println("</td>");
				pr.println("</tr>");
			
				pr.println("<tr>");
					pr.println("<td>");
						pr.println("Street: ");
					pr.println("</td>");
					pr.println("<td>");
						pr.println(street);
					pr.println("</td>");
				pr.println("</tr>");
			
			pr.println("</table>");
			pr.println("<html>");
		pr.println("</html>");
	}

}
