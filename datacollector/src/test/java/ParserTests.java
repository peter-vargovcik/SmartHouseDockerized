import org.junit.Test;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import vargovcik.peter.datacollector.dto.Metric;
import vargovcik.peter.datacollector.dto.WeatherRecord;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ParserTests {


    @Test
    public void test01(){
        String payload = "{\"observations\":[{\"stationID\":\"IARDNA2\",\"obsTimeUtc\":\"2019-12-11T23:10:09Z\",\"obsTimeLocal\":\"2019-12-11 23:10:09\",\"neighborhood\":\"Carrickaneha\",\"softwareType\":\"EasyWeatherV1.4.4\",\"country\":\"IE\",\"solarRadiation\":0.0,\"lon\":-7.76316977,\"realtimeFrequency\":null,\"epoch\":1576105809,\"lat\":53.46486664,\"uv\":0.0,\"winddir\":186,\"humidity\":95.0,\"qcStatus\":-1,\"metric\":{\"temp\":3.0,\"heatIndex\":3.0,\"dewpt\":2.3,\"windChill\":0.0,\"windSpeed\":11.1,\"windGust\":14.8,\"pressure\":995.73,\"precipRate\":0.00,\"precipTotal\":3.30,\"elev\":110.0}}]}";

        DateTimeFormatter formatterUTC = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateTimeFormatter formatterLocal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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

        Metric  metric = new Metric(temp,heatIndex,dewpt,windChill,windSpeed,windGust,pressure,precipRate,precipTotal,elev);
        WeatherRecord weatherRecord = new WeatherRecord(stationID,obsTimeUtc,obsTimeLocal,neighborhood,softwareType,country,solarRadiation,lon,realtimeFrequency,epoch,lat,uv,winddir,humidity,qcStatus,metric);

        System.out.println(weatherRecord.toString());
    }

}
