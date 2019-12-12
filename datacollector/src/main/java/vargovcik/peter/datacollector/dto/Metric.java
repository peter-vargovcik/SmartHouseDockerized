package vargovcik.peter.datacollector.dto;
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
        "temp",
        "heatIndex",
        "dewpt",
        "windChill",
        "windSpeed",
        "windGust",
        "pressure",
        "precipRate",
        "precipTotal",
        "elev"
})
public class Metric {

    @JsonProperty("temp")
    private double temp;
    @JsonProperty("heatIndex")
    private double heatIndex;
    @JsonProperty("dewpt")
    private double dewpt;
    @JsonProperty("windChill")
    private double windChill;
    @JsonProperty("windSpeed")
    private double windSpeed;
    @JsonProperty("windGust")
    private double windGust;
    @JsonProperty("pressure")
    private double pressure;
    @JsonProperty("precipRate")
    private double precipRate;
    @JsonProperty("precipTotal")
    private double precipTotal;
    @JsonProperty("elev")
    private double elev;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Metric() {
    }

    /**
     *
     * @param temp
     * @param windChill
     * @param windGust
     * @param elev
     * @param heatIndex
     * @param dewpt
     * @param precipTotal
     * @param pressure
     * @param windSpeed
     * @param precipRate
     */
    public Metric(Double temp, double heatIndex, double dewpt, double windChill, double windSpeed, double windGust, double pressure, double precipRate, double precipTotal, double elev) {
        super();
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
    }

    @JsonProperty("temp")
    public double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("heatIndex")
    public double getHeatIndex() {
        return heatIndex;
    }

    @JsonProperty("heatIndex")
    public void setHeatIndex(Double heatIndex) {
        this.heatIndex = heatIndex;
    }

    @JsonProperty("dewpt")
    public double getDewpt() {
        return dewpt;
    }

    @JsonProperty("dewpt")
    public void setDewpt(Double dewpt) {
        this.dewpt = dewpt;
    }

    @JsonProperty("windChill")
    public double getWindChill() {
        return windChill;
    }

    @JsonProperty("windChill")
    public void setWindChill(Double windChill) {
        this.windChill = windChill;
    }

    @JsonProperty("windSpeed")
    public double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("windSpeed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("windGust")
    public double getWindGust() {
        return windGust;
    }

    @JsonProperty("windGust")
    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    @JsonProperty("pressure")
    public double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("precipRate")
    public double getPrecipRate() {
        return precipRate;
    }

    @JsonProperty("precipRate")
    public void setPrecipRate(Double precipRate) {
        this.precipRate = precipRate;
    }

    @JsonProperty("precipTotal")
    public double getPrecipTotal() {
        return precipTotal;
    }

    @JsonProperty("precipTotal")
    public void setPrecipTotal(Double precipTotal) {
        this.precipTotal = precipTotal;
    }

    @JsonProperty("elev")
    public double getElev() {
        return elev;
    }

    @JsonProperty("elev")
    public void setElev(Double elev) {
        this.elev = elev;
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
        return new ToStringBuilder(this).append("temp", temp).append("heatIndex", heatIndex).append("dewpt", dewpt).append("windChill", windChill).append("windSpeed", windSpeed).append("windGust", windGust).append("pressure", pressure).append("precipRate", precipRate).append("precipTotal", precipTotal).append("elev", elev).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(temp).append(windChill).append(windGust).append(elev).append(heatIndex).append(dewpt).append(precipTotal).append(pressure).append(additionalProperties).append(windSpeed).append(precipRate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metric) == false) {
            return false;
        }
        Metric rhs = ((Metric) other);
        return new EqualsBuilder().append(temp, rhs.temp).append(windChill, rhs.windChill).append(windGust, rhs.windGust).append(elev, rhs.elev).append(heatIndex, rhs.heatIndex).append(dewpt, rhs.dewpt).append(precipTotal, rhs.precipTotal).append(pressure, rhs.pressure).append(additionalProperties, rhs.additionalProperties).append(windSpeed, rhs.windSpeed).append(precipRate, rhs.precipRate).isEquals();
    }
}
