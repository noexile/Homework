package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SquareRootServlet")
public class SquareRootServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final int counterUntil = 1000;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("<table>");
		for (int i = 1; i <= counterUntil; i++) {
			response.getWriter().append("<tr>" + "Number: " + i + ". Square root: " + Math.sqrt(i) + "</tr><br>");
		}
		response.getWriter().append("</table>");
	}


}
