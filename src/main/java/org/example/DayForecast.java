package org.example;
import java.time.*;

public class DayForecast {
//-- Practical data --
    private final LocalDate date;
    private final LocalDateTime forecastCreated;
    private final double stationLongitude, stationLatitude;
    private String todaysRawData;

//-- weather data --
    private boolean willRain;
    private float minAmountRain, maxAmountRain;


    public DayForecast(LocalDate date, LocalDateTime forecastCreated, double stationLongitude, double stationLatitude, String stationName, String todaysRawData) {
        this.date = date;
        this.forecastCreated = forecastCreated;
        this.stationLongitude = stationLongitude;
        this.stationLatitude = stationLatitude;
        this.todaysRawData = todaysRawData;
    }

}
