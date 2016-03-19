package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.movie.Movie;
import model.user.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, User> users;
	List<Movie> movies;
	
	@Override
	public void init() throws ServletException {
		this.users = new HashMap<String, User>();
		this.movies = new ArrayList<Movie>();
		
		User admin = new User("admin", "admin");
		this.users.put(admin.getUsername(), admin);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(getServletContext().getAttribute("movies") == null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username == null || password == null || !userExists(username)) {
				request.getSession().setAttribute("error", "wrong username or password!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			downloadMovies();
			
			request.getServletContext().setAttribute("movies", movies);
		}
		
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
	}

	private void downloadMovies() throws IOException {
		
		HttpClient client = HttpClientBuilder.create().build();
		
		final String request = "http://www36.imperiaonline.org/movies.php";
		
		HttpUriRequest movieRequest = new HttpGet(request);
		
		HttpResponse movieWebsiteResponse = client.execute(movieRequest);
		
		String movieData = EntityUtils.toString(movieWebsiteResponse.getEntity());
		
		JsonArray rawObject = new JsonParser().parse(movieData).getAsJsonArray();
		
		for (int i = 0; i < rawObject.size(); i++) {
			JsonObject movie = rawObject.get(i).getAsJsonObject();
			String title = movie.get("Title").getAsString();
			String year = movie.get("Year").getAsString();
			
			addMovieToList(title, year);
		}
		
	}
	
	void addMovieToList(String name, String year) {
		this.movies.add(new Movie(name, year));
	}

	private boolean userExists(String username) {
		if (this.users.containsKey(username)) {
			return true;
		}
		return false;
	}

}
