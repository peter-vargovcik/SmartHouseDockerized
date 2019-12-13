package vargovcik.peter.datacollector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"obsTimeUtc", "obsTimeLocal"}
)
@Entity
@Table(name = "weather_record")
public class WeatherRecordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String stationID;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "obsTimeUtc", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime obsTimeUtc;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "obsTimeLocal", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime obsTimeLocal;
    @Column
    private double solarRadiation;
    @Column
    private double temp;
    @Column
    private double heatIndex;
    @Column
    private double dewpt;
    @Column
    private double windChill;
    @Column
    private double windSpeed;
    @Column
    private double windGust;
    @Column
    private double pressure;
    @Column
    private double precipRate;
    @Column
    private double precipTotal;
    @Column
    private double elev;
    @Column
    private int epoch;
    @Column
    private double uv;
    @Column
    private int winddir;
    @Column
    private double humidity;
    @Column
    private int qcStatus;

    public WeatherRecordModel(){

    }

    public WeatherRecordModel(String stationID, LocalDateTime obsTimeUtc, LocalDateTime obsTimeLocal, double solarRadiation, double temp, double heatIndex, double dewpt, double windChill, double windSpeed, double windGust, double pressure, double precipRate, double precipTotal, double elev, int epoch, double uv, int winddir, double humidity, int qcStatus) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public LocalDateTime getObsTimeUtc() {
        return obsTimeUtc;
    }

    public void setObsTimeUtc(LocalDateTime obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }

    public LocalDateTime getObsTimeLocal() {
        return obsTimeLocal;
    }

    public void setObsTimeLocal(LocalDateTime obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }

    public double getSolarRadiation() {
        return solarRadiation;
    }

    public void setSolarRadiation(double solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHeatIndex() {
        return heatIndex;
    }

    public void setHeatIndex(double heatIndex) {
        this.heatIndex = heatIndex;
    }

    public double getDewpt() {
        return dewpt;
    }

    public void setDewpt(double dewpt) {
        this.dewpt = dewpt;
    }

    public double getWindChill() {
        return windChill;
    }

    public void setWindChill(double windChill) {
        this.windChill = windChill;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindGust() {
        return windGust;
    }

    public void setWindGust(double windGust) {
        this.windGust = windGust;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPrecipRate() {
        return precipRate;
    }

    public void setPrecipRate(double precipRate) {
        this.precipRate = precipRate;
    }

    public double getPrecipTotal() {
        return precipTotal;
    }

    public void setPrecipTotal(double precipTotal) {
        this.precipTotal = precipTotal;
    }

    public double getElev() {
        return elev;
    }

    public void setElev(double elev) {
        this.elev = elev;
    }

    public int getEpoch() {
        return epoch;
    }

    public void setEpoch(int epoch) {
        this.epoch = epoch;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public int getWinddir() {
        return winddir;
    }

    public void setWinddir(int winddir) {
        this.winddir = winddir;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public int getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(int qcStatus) {
        this.qcStatus = qcStatus;
    }
}
