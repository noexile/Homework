package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConvertorServlet")
public class ConvertorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Double> values = new HashMap<>();
		values.put("centimeter", 0.01);
		values.put("inch", 0.0254);
		values.put("foot", 0.3048);
		values.put("yard", 0.9144);
		values.put("kilometer", 1000.0);
		values.put("mile", 1609.344);
		
		String number = request.getParameter("number");
		
		String from = request.getParameter("from");
		String to = request.getParameter("to");
	
		if (!values.containsKey(from) || !values.containsKey(to)) {
			response.getWriter().append("<h1>Something went wrong with the parameter selection!</h1>");
			return;
		}
		
		if (!checkIfNumberIsCorrectlyInput(number) || number.trim().isEmpty()) {
			response.getWriter().append("<h1>The input data is incorrect or empty! Please use only numbers</h1>");
			return;
		}
		
		double inputNumber = Integer.valueOf(number);
		double changedNumber = inputNumber;		

		for(Map.Entry<String, Double> entry : values.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(from)) {
				changedNumber *= entry.getValue();
			}
		}
		
		for(Map.Entry<String, Double> entry : values.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(to)) {
				changedNumber /= entry.getValue();
			}
		}
		
		
		response.getWriter().append("<h3>" + number + " " + from + " = " + changedNumber + " " + to + "</h3>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean checkIfNumberIsCorrectlyInput(String inputNumber) {
		char[] inputData = inputNumber.toCharArray();
		
		for (int i = 0; i < inputData.length; i++) {
			if (!Character.isDigit(inputData[i])) {
				return false;
			}
		}
		return true;
	}

}
