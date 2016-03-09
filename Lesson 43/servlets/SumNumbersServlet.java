package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SumNumbersServlet")
public class SumNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNumber = request.getParameter("firstNumber");
		String secondNumber = request.getParameter("secondNumber");

		if (!checkIfNumberIsCorrectlyInput(firstNumber) || !checkIfNumberIsCorrectlyInput(secondNumber) || firstNumber.trim().isEmpty() || secondNumber.trim().isEmpty()) {
			response.getWriter().append("<h1>The input data is incorrect!</h1>");
			return;
		}
		
		int numberOne = Integer.valueOf(firstNumber);
		int numberTwo = Integer.valueOf(secondNumber);
		int result = numberOne + numberTwo;
		
		response.getWriter().append("<h1>The sum of " + numberOne + " + " + numberTwo + " = " + result + "</h1>");
		
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
