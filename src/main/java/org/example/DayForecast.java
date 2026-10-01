package org.example;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.*;

public class DayForecast {
//-- Practical data --
    private final LocalDate date;
    private final LocalDateTime forecastCreated;
    private final double stationLongitude, stationLatitude;
    private final JSONArray todaysTimeseries;

//-- weather data --
    private boolean willRain;
    private double minAmountRain, maxAmountRain;


    public DayForecast(LocalDate date, LocalDateTime forecastCreated, double stationLongitude, double stationLatitude, JSONArray todaysTimeseries) {
        this.date = date;
        this.forecastCreated = forecastCreated;
        this.stationLongitude = stationLongitude;
        this.stationLatitude = stationLatitude;
        this.todaysTimeseries = todaysTimeseries;

        updateRain();

    }

    public void updateRain(){
        JSONArray timeseries = this.todaysTimeseries;

        // vill veta vad min, max rain är + will rain?
        for (int i = 0; i < timeseries.length(); i++) {
            JSONObject data = (JSONObject) timeseries.getJSONObject(i).query("/data");

            // från datan vill vi ha "precipitation_amount_max", "precipitation_amount_min"
            this.maxAmountRain += (double) data.get("precipitation_amount_max");
            this.minAmountRain += (double) data.get("precipitation_amount_min");
        }

        this.willRain = (this.maxAmountRain > 0);

    }

    public boolean getWillRain() {
        return willRain;
    }
    public void setWillRain(boolean willRain) {
        this.willRain = willRain;
    }
    public double getMinAmountRain() {
        return minAmountRain;
    }
    public void setMinAmountRain(double minAmountRain) {
        this.minAmountRain = minAmountRain;
    }
    public double getMaxAmountRain() {
        return maxAmountRain;
    }
    public void setMaxAmountRain(double maxAmountRain) {
        this.maxAmountRain = maxAmountRain;
    }

    public String toString(){

        return "Forecast for: "+this.date+", created on: "+this.forecastCreated+",\n"+
                "by station located at: longitude - "+this.stationLongitude+", latitude - "+this.stationLatitude+"\n"+
                "it will rain today: "+this.willRain+
                "\nminimum amount of rain: "+this.minAmountRain+", maximum amount of rain: "+this.maxAmountRain;
    }
}
