package vargovcik.peter.datacollector.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherRecordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stationID;
    private Date obsTimeUtc;
    private Date obsTimeLocal;
    private double solarRadiation;
    private double temp;
    private double heatIndex;
    private double dewpt;
    private double windChill;
    private double windSpeed;
    private double windGust;
    private double pressure;
    private double precipRate;
    private double precipTotal;
    private double elev;
    private int epoch;
    private double uv;
    private int winddir;
    private double humidity;
    private int qcStatus;

    public WeatherRecordModel(String stationID, Date obsTimeUtc, Date obsTimeLocal, double solarRadiation, double temp, double heatIndex, double dewpt, double windChill, double windSpeed, double windGust, double pressure, double precipRate, double precipTotal, double elev, int epoch, double uv, int winddir, double humidity, int qcStatus) {

        this.stationID = stationID;
        this.obsTimeUtc = obsTimeUtc;
        this.obsTimeLocal = obsTimeLocal;
        this.solarRadiation = solarRadiation;
        this.temp = temp;
        this.heatIndex = heatIndex;
        this.dewpt = dewpt;
        this.windChill = windChill;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.pressure = pressure;
        this.precipRate = precipRate;
        this.precipTotal = precipTotal;
        this.elev = elev;
        this.epoch = epoch;
        this.uv = uv;
        this.winddir = winddir;
        this.humidity = humidity;
        this.qcStatus = qcStatus;
    }
}
