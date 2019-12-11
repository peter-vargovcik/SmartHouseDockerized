package vargovcik.peter.datacollector.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vargovcik.peter.datacollector.utils.ParameterStringBuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ScheduledWeatherFetch {

    private static final Logger log = LoggerFactory.getLogger(ScheduledWeatherFetch.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void fetch() {
//        System.out.println("The time is now " + dateFormat.format(new Date()));

        fetchWeather();

    }

    private void fetchWeather() {
        log.info("Firing WeatherFetch at {}", dateFormat.format(new Date()));

        try {
            //https://www.baeldung.com/java-http-request

            URL url = new URL("https://api.weather.com/v2/pws/observations/current?apiKey=6532d6454b8aa370768e63d6ba5a832e&stationId=IARDNA2&numericPrecision=decimal&format=json&units=m");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // if params needed
//            Map<String, String> parameters = new HashMap<>();
//            parameters.put("param1", "val");
//
//            con.setDoOutput(true);
//            DataOutputStream out = new DataOutputStream(con.getOutputStream());
//            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//            out.flush();
//            out.close();
            con.setRequestProperty("Content-Type", "application/json");

            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);

            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            consumePayload(content.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void consumePayload(String payload) {
        log.info("WeatherFetch Payload [{}]", payload);
    }
}
