package vargovcik.peter.datacollector.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vargovcik.peter.datacollector.dto.Metric;
import vargovcik.peter.datacollector.dto.WeatherRecord;
import vargovcik.peter.datacollector.model.WeatherRecordModel;
import vargovcik.peter.datacollector.repo.WeatherRecordRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class ScheduledOutagesFetch {
    private final static long INTERVAL = 1000 * 60 * 10;

    private static final Logger log = LoggerFactory.getLogger(ScheduledOutagesFetch.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private WeatherRecordRepository repository;

    class Outage{
        public String outageType;
        public int outageId;
        public double latitude;
        public double longitude;
    }


    @Scheduled(fixedRate = INTERVAL)
    public void fetch() {
//        System.out.println("The time is now " + dateFormat.format(new Date()));

        double myLatitude = 53.464668;
        double myLongitude = -7.806648;
        int radiusInKM = 20;
        List<Outage> outages = filterOutagesInRadius(getCurentOutages(),myLatitude,myLongitude,radiusInKM);
        saveOutages(outages);

    }

    private void saveOutages(List<Outage> outages) {

    }

    private List<Outage> filterOutagesInRadius(List<Outage> curentOutages, double myLatitude, double myLongitude, int radiusInKM) {
        return null;
    }

    private List<Outage> getCurentOutages() {
        List<Outage> outages = new ArrayList<>();

       String payload = fetchData("https://webservices.esb.ie/networks/outageapp/web/1.0/en/outages?_=" + System.currentTimeMillis());

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(payload);

//        Map<String,Object> observationMap = map.get("outageMessage");

        return outages;
    }

    private String fetchData(String urlString) {
        String output = null;
        try {
            //https://www.baeldung.com/java-http-request

            URL url = new URL(urlString);
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

            output = content.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    private void consumePayload(String payload) {
        log.info("WeatherFetch Payload [{}]", payload);

        DateTimeFormatter formatterUTC = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateTimeFormatter formatterLocal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            JsonParser springParser = JsonParserFactory.getJsonParser();
            Map<String, Object> map = springParser.parseMap(payload);

            Map<String,Object> observationMap = ((List<Map<String,Object>>) map.get("observations")).get(0);
            Map<String,Object> metricMap = (Map<String,Object>) observationMap.get("metric");

            double temp = (double) metricMap.get("temp");
            double heatIndex = (double) metricMap.get("heatIndex");
            double dewpt = (double) metricMap.get("dewpt");
            double windChill = (double) metricMap.get("windChill");
            double windSpeed = (double) metricMap.get("windSpeed");
            double windGust = (double) metricMap.get("windGust");
            double pressure = (double) metricMap.get("pressure");
            double precipRate = (double) metricMap.get("precipRate");
            double precipTotal = (double) metricMap.get("precipTotal");
            double elev = (double) metricMap.get("elev");


            String stationID = (String) observationMap.get("stationID");
            LocalDateTime obsTimeUtc = LocalDateTime.parse((String) observationMap.get("obsTimeUtc"), formatterUTC);
            LocalDateTime obsTimeLocal = LocalDateTime.parse((String) observationMap.get("obsTimeLocal"), formatterLocal);
            String neighborhood = (String) observationMap.get("neighborhood");
            String softwareType = (String) observationMap.get("softwareType");
            String country = (String) observationMap.get("country");
            double solarRadiation = (double) observationMap.get("solarRadiation");
            double lon = (double) observationMap.get("lon");
            Object realtimeFrequency = (Object) observationMap.get("realtimeFrequency");
            int epoch = (int) observationMap.get("epoch");
            double lat = (double) observationMap.get("lat");
            double uv = (double) observationMap.get("uv");
            int winddir = (int) observationMap.get("winddir");
            double humidity = (double) observationMap.get("humidity");
            int qcStatus = (int) observationMap.get("qcStatus");

            Metric metric = new Metric(temp,heatIndex,dewpt,windChill,windSpeed,windGust,pressure,precipRate,precipTotal,elev);
            WeatherRecord weatherRecord = new WeatherRecord(stationID,obsTimeUtc,obsTimeLocal,neighborhood,softwareType,country,solarRadiation,lon,realtimeFrequency,epoch,lat,uv,winddir,humidity,qcStatus,metric);

            saveWeatherRecord(weatherRecord);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Failed parsing&saving {}", e.getMessage(),e);
        }
    }

    private void saveWeatherRecord(WeatherRecord weatherRecord) {

        Metric metric = weatherRecord.getMetric();

        String stationID = weatherRecord.getStationID();
        java.sql.Date obsTimeUtc = java.sql.Date.valueOf(weatherRecord.getObsTimeUtc().toLocalDate());
        java.sql.Date obsTimeLocal = java.sql.Date.valueOf(weatherRecord.getObsTimeLocal().toLocalDate());
        double solarRadiation = weatherRecord.getSolarRadiation();
        double temp = metric.getTemp();
        double heatIndex = metric.getHeatIndex();
        double dewpt = metric.getDewpt();
        double windChill = metric.getWindChill();
        double windSpeed = metric.getWindSpeed();
        double windGust = metric.getWindGust();
        double pressure = metric.getPressure();
        double precipRate = metric.getPrecipRate();
        double precipTotal = metric.getPrecipTotal();
        double elev = metric.getElev();
        int epoch = weatherRecord.getEpoch();
        double uv = weatherRecord.getUv();
        int winddir = weatherRecord.getWinddir();
        double humidity = weatherRecord.getHumidity();
        int qcStatus = weatherRecord.getQcStatus();

        WeatherRecordModel model = new WeatherRecordModel(
                stationID,obsTimeUtc,obsTimeLocal,solarRadiation,temp,heatIndex,
                dewpt,windChill,windSpeed,windGust,pressure,precipRate,
                precipTotal,elev,epoch,uv,winddir, humidity,qcStatus);


        repository.save(model);
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    private double distance(double lat1, double lon1, double lat2,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
}
