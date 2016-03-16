package weather;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String city = request.getParameter("city");
		
		HttpClient client = HttpClientBuilder.create().build();
		
		final String key = "553a05b629269b8d95fa5d93a30f2f71";
		final String wholeRequest = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + key;
		
		HttpUriRequest weatherRequest = new HttpGet(wholeRequest);
		
		HttpResponse weatherProviderResponse = client.execute(weatherRequest);
		
		String weatherData = EntityUtils.toString(weatherProviderResponse.getEntity());
		
		System.out.println(weatherData);
		
		// received JSON formatted data from the server
		JsonObject obj = (JsonObject) new JsonParser().parse(weatherData);
		
		// coordinates
		JsonObject coordinates = obj.get("coord").getAsJsonObject();
		
		double lattitude = coordinates.get("lat").getAsDouble();
		double longtitude = coordinates.get("lon").getAsDouble();
		
		System.out.println(lattitude);
		System.out.println(longtitude);
		
		// weather
		JsonArray weather = obj.get("weather").getAsJsonArray();

		JsonObject weatherObject = weather.get(0).getAsJsonObject();
		String clouds = weatherObject.get("description").getAsString();
		
		System.out.println(clouds);
		
		// main
		JsonObject main = obj.get("main").getAsJsonObject();
		double degrees = main.get("temp").getAsDouble();
		int kelvin = (int) degrees - 273;
		System.out.println(kelvin + " C");
		
		request.setAttribute("city", city);
		request.setAttribute("lattitude", lattitude);
		request.setAttribute("longtitude", longtitude);
		request.setAttribute("clouds", clouds);
		request.setAttribute("temperature", kelvin);
		
		//forward the request to jsp
		request.getRequestDispatcher("weather.jsp").forward(request, response);
	}

}
