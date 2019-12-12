package vargovcik.peter.datacollector.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "stationID",
        "obsTimeUtc",
        "obsTimeLocal",
        "neighborhood",
        "softwareType",
        "country",
        "solarRadiation",
        "lon",
        "realtimeFrequency",
        "epoch",
        "lat",
        "uv",
        "winddir",
        "humidity",
        "qcStatus",
        "metric"
})

public class WeatherRecord {

    @JsonProperty("stationID")
    private String stationID;
    @JsonProperty("obsTimeUtc")
    private LocalDateTime obsTimeUtc;
    @JsonProperty("obsTimeLocal")
    private LocalDateTime obsTimeLocal;
    @JsonProperty("neighborhood")
    private String neighborhood;
    @JsonProperty("softwareType")
    private String softwareType;
    @JsonProperty("country")
    private String country;
    @JsonProperty("solarRadiation")
    private double solarRadiation;
    @JsonProperty("lon")
    private double lon;
    @JsonProperty("realtimeFrequency")
    private Object realtimeFrequency;
    @JsonProperty("epoch")
    private int epoch;
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("uv")
    private double uv;
    @JsonProperty("winddir")
    private int winddir;
    @JsonProperty("humidity")
    private double humidity;
    @JsonProperty("qcStatus")
    private int qcStatus;
    @JsonProperty("metric")
    private Metric metric;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public WeatherRecord() {
    }

    /**
     *
     * @param country
     * @param uv
     * @param qcStatus
     * @param softwareType
     * @param solarRadiation
     * @param lon
     * @param epoch
     * @param winddir
     * @param obsTimeUtc
     * @param realtimeFrequency
     * @param metric
     * @param humidity
     * @param obsTimeLocal
     * @param neighborhood
     * @param lat
     * @param stationID
     */
    public WeatherRecord(String stationID, LocalDateTime obsTimeUtc, LocalDateTime obsTimeLocal, String neighborhood, String softwareType, String country, double solarRadiation, double lon, Object realtimeFrequency, int epoch, double lat, double uv, int winddir, double humidity, int qcStatus, Metric metric) {
        this.stationID = stationID;
        this.obsTimeUtc = obsTimeUtc;
        this.obsTimeLocal = obsTimeLocal;
        this.neighborhood = neighborhood;
        this.softwareType = softwareType;
        this.country = country;
        this.solarRadiation = solarRadiation;
        this.lon = lon;
        this.realtimeFrequency = realtimeFrequency;
        this.epoch = epoch;
        this.lat = lat;
        this.uv = uv;
        this.winddir = winddir;
        this.humidity = humidity;
        this.qcStatus = qcStatus;
        this.metric = metric;
    }

    @JsonProperty("stationID")
    public String getStationID() {
        return stationID;
    }

    @JsonProperty("stationID")
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    @JsonProperty("obsTimeUtc")
    public LocalDateTime getObsTimeUtc() {
        return obsTimeUtc;
    }

    @JsonProperty("obsTimeUtc")
    public void setObsTimeUtc(LocalDateTime obsTimeUtc) {
        this.obsTimeUtc = obsTimeUtc;
    }

    @JsonProperty("obsTimeLocal")
    public LocalDateTime getObsTimeLocal() {
        return obsTimeLocal;
    }

    @JsonProperty("obsTimeLocal")
    public void setObsTimeLocal(LocalDateTime obsTimeLocal) {
        this.obsTimeLocal = obsTimeLocal;
    }

    @JsonProperty("neighborhood")
    public String getNeighborhood() {
        return neighborhood;
    }

    @JsonProperty("neighborhood")
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @JsonProperty("softwareType")
    public String getSoftwareType() {
        return softwareType;
    }

    @JsonProperty("softwareType")
    public void setSoftwareType(String softwareType) {
        this.softwareType = softwareType;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("solarRadiation")
    public double getSolarRadiation() {
        return solarRadiation;
    }

    @JsonProperty("solarRadiation")
    public void setSolarRadiation(Double solarRadiation) {
        this.solarRadiation = solarRadiation;
    }

    @JsonProperty("lon")
    public double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @JsonProperty("realtimeFrequency")
    public Object getRealtimeFrequency() {
        return realtimeFrequency;
    }

    @JsonProperty("realtimeFrequency")
    public void setRealtimeFrequency(Object realtimeFrequency) {
        this.realtimeFrequency = realtimeFrequency;
    }

    @JsonProperty("epoch")
    public int getEpoch() {
        return epoch;
    }

    @JsonProperty("epoch")
    public void setEpoch(Integer epoch) {
        this.epoch = epoch;
    }

    @JsonProperty("lat")
    public double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("uv")
    public double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
    }

    @JsonProperty("winddir")
    public int getWinddir() {
        return winddir;
    }

    @JsonProperty("winddir")
    public void setWinddir(Integer winddir) {
        this.winddir = winddir;
    }

    @JsonProperty("humidity")
    public double getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("qcStatus")
    public int getQcStatus() {
        return qcStatus;
    }

    @JsonProperty("qcStatus")
    public void setQcStatus(Integer qcStatus) {
        this.qcStatus = qcStatus;
    }

    @JsonProperty("metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stationID", stationID).append("obsTimeUtc", obsTimeUtc).append("obsTimeLocal", obsTimeLocal).append("neighborhood", neighborhood).append("softwareType", softwareType).append("country", country).append("solarRadiation", solarRadiation).append("lon", lon).append("realtimeFrequency", realtimeFrequency).append("epoch", epoch).append("lat", lat).append("uv", uv).append("winddir", winddir).append("humidity", humidity).append("qcStatus", qcStatus).append("metric", metric).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(country).append(uv).append(qcStatus).append(softwareType).append(solarRadiation).append(lon).append(epoch).append(winddir).append(obsTimeUtc).append(realtimeFrequency).append(metric).append(humidity).append(obsTimeLocal).append(neighborhood).append(additionalProperties).append(lat).append(stationID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherRecord) == false) {
            return false;
        }
        WeatherRecord rhs = ((WeatherRecord) other);
        return new EqualsBuilder().append(country, rhs.country).append(uv, rhs.uv).append(qcStatus, rhs.qcStatus).append(softwareType, rhs.softwareType).append(solarRadiation, rhs.solarRadiation).append(lon, rhs.lon).append(epoch, rhs.epoch).append(winddir, rhs.winddir).append(obsTimeUtc, rhs.obsTimeUtc).append(realtimeFrequency, rhs.realtimeFrequency).append(metric, rhs.metric).append(humidity, rhs.humidity).append(obsTimeLocal, rhs.obsTimeLocal).append(neighborhood, rhs.neighborhood).append(additionalProperties, rhs.additionalProperties).append(lat, rhs.lat).append(stationID, rhs.stationID).isEquals();
    }
}
