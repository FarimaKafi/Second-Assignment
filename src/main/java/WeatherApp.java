import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;

public class WeatherApp {
    // Copy your API-KEY here
    public final static String apiKey = "99e46d520a9e4865adb113457232702";
    // TODO: Write main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a city ");
        String city = sc.next();
        JSONObject WeatherJson = new JSONObject(getWeatherData(city));

        String humidity = Integer.toString(WeatherJson.getJSONObject("current").getInt("humidity"));
        String temperature = Double.toString(WeatherJson.getJSONObject("current").getDouble("temp_c"));
        String windVelocity = Double.toString(WeatherJson.getJSONObject("current").getDouble("wind_kph"));
        String windDirection = WeatherJson.getJSONObject("current").getString("wind_dir");

        System.out.println("humidity => " + getHumidity(humidity));
        System.out.println("temperature => " + getTemperature(temperature) + " (c)");
        System.out.println("wind velocity =>  " + getwindVelocity(windVelocity));
        System.out.println("wind direction => " + windDirection);

    }

    /**
     * Retrieves weather data for the specified city.
     *
     * @param city the name of the city for which weather data should be retrieved
     * @return a string representation of the weather data, or null if an error occurred
     */
    public static String getWeatherData(String city) {
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO: Write getTemperature function returns celsius temperature of city by given json string
    public static double getTemperature(String weatherJson){
        double answer = 0.0;
        answer = Double.parseDouble(weatherJson);
        return answer;
    }

    public static double getwindVelocity(String weatherJson){
        double answer = 0.0;
        answer = Double.parseDouble(weatherJson);
        return answer;
    }

    // TODO: Write getHumidity function returns humidity percentage of city by given json string
    public static int getHumidity(String weatherJson){
        int answer = 0;
        answer = Integer.parseInt(weatherJson);
        return answer;
    }
}
