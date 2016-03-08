package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	File file;
	int counter = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		PrintWriter writer = response.getWriter();
		String name = Thread.currentThread().getName();
		writer.append("Instance number: ").append(String.valueOf(counter++)).append(" ").append(name);
		
		if (file != null) {
			
			BufferedWriter output = null;
			
			try {
				output = new BufferedWriter(new FileWriter(file));
				output.write(Integer.toString(counter));
			} catch (IOException e) {
				System.out.println("Error writing in file: " + e.getMessage());
			} finally {
				try {
					output.close();
				} catch (IOException e) {}
			}
			
		} else {
			System.out.println("Cannot save data in the file!");
		}
	}
	
	@Override
	public void init() throws ServletException {
		file = new File("SavedCounter.txt");
		String data = null;
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("file created");
			} catch (IOException e) {
				System.out.println("Error in creating a new file! " + e.getMessage());
			}
		} 
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			
			
			while((data = br.readLine()) != null) {
				sb.append(data);
			}
			
			char[] inputData = sb.toString().toCharArray();
			
			for (int i = 0; i < sb.length(); i++) {
				if (!Character.isDigit(inputData[i])) {
					System.out.println("The input data is not a number!");
					return;
				}
			}
			counter = Integer.valueOf(sb.toString());
		} catch (IOException e) {
			System.out.println("Error in extracting data from file! " + e.getMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {}
		}		
	}
}
