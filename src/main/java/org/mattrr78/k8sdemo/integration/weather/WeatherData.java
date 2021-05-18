package org.mattrr78.k8sdemo.integration.weather;

import java.math.BigDecimal;

public class WeatherData {

    private String description;

    private BigDecimal temperature;

    private BigDecimal humidity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

}
