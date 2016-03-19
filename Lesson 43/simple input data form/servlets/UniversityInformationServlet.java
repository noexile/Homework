package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UniversityInformationServlet")
public class UniversityInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String universityName = request.getParameter("universityName");
		String faculty = request.getParameter("faculty");
		String specialty = request.getParameter("specialty");
		
		if (universityName == null || faculty == null || specialty == null || universityName.trim().isEmpty() || faculty.trim().isEmpty() || specialty.trim().isEmpty()) {
			response.sendRedirect("errorPageForUniversity.html");
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("universityName", universityName);
		session.setAttribute("faculty", faculty);
		session.setAttribute("specialty", specialty);
		
		response.sendRedirect("GatheredInformationServlet");
	}
}
