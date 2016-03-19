package controller;

import java.io.IOException;
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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.movie.Movie;

@WebServlet("/MovieDetailsServlet")
public class MovieDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String year = request.getParameter("year");
		
		HttpClient client = HttpClientBuilder.create().build();
		
		String omdbRequestText = "http://www.omdbapi.com/?t=" + title +"&y=" + year +"&plot=short&r=json";
		final String correctRequest = omdbRequestText.replace(" ", "-");
		
		HttpUriRequest omdbRequest = new HttpGet(correctRequest);
		
		HttpResponse omdbResponse = client.execute(omdbRequest);
		
		String movieData = EntityUtils.toString(omdbResponse.getEntity());
		
		JsonObject omdbMovieObject = new JsonParser().parse(movieData).getAsJsonObject();
		
		Movie movie = new Movie(title, year);
		movie.setActors(omdbMovieObject.get("Actors").getAsString());
		movie.setAwards(omdbMovieObject.get("Awards").getAsString());
		movie.setPoster(omdbMovieObject.get("Poster").getAsString());
		
		request.getServletContext().setAttribute("movie", movie);
		request.getRequestDispatcher("movieDisplay.jsp").forward(request, response);
	}

}
