package holidaysAPI;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HolidayFinder {
    private static final String API_KEY = "7972d35891167584e276e485412b6c26767f29ca";
    private static final String API_BASE_URL = "https://calendarific.com/api/v2/holidays";

    public static List<String> findHolidays(String country1, String month) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", API_KEY);
        urlBuilder.addQueryParameter("country", country1 );
        urlBuilder.addQueryParameter("year", "2023");
        urlBuilder.addQueryParameter("month", month);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        JsonNode holidaysNode = root.path("response").path("holidays");

        List<String> holidays = new ArrayList<>();
        for (JsonNode holidayNode : holidaysNode) {
            String name = holidayNode.path("name").asText();
            holidays.add(name);
        }

        return holidays;
    }
}