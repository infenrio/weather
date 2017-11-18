package weatherStepDefs.model;

import java.math.BigDecimal;

public class Main {
    private BigDecimal temp;
    private BigDecimal pressure;
    private BigDecimal humidity;
    private BigDecimal temp_min;
    private BigDecimal temp_max;
    private BigDecimal sea_level;
    private BigDecimal grnd_level;

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(BigDecimal temp_min) {
        this.temp_min = temp_min;
    }

    public BigDecimal getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(BigDecimal temp_max) {
        this.temp_max = temp_max;
    }

    public BigDecimal getSea_level() {
        return sea_level;
    }

    public void setSea_level(BigDecimal sea_level) {
        this.sea_level = sea_level;
    }

    public BigDecimal getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(BigDecimal grnd_level) {
        this.grnd_level = grnd_level;
    }
}
