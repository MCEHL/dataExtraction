package org.example;
import org.json.*;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;

import static org.example.ForecastQueryParameters.*;

public class Main {
    public static void main(String[] args) {

        APICommunication request = new APICommunication();
        String response;

        try {
            response = request.getForecast(11.9059, 57.8558, -1, symbol_code,
                    cloud_area_fraction,
                    probability_of_precipitation,
                    precipitation_amount_max,
                    precipitation_amount_mean,
                    precipitation_amount_min,
                    predominant_precipitation_type_at_surface,
                    relative_humidity,
                    wind_speed);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }


        JSONObject root = new JSONObject(response);
        ForecastBuilder build = new ForecastBuilder();
        ArrayList<DayForecast> week = build.createForecasts(root);

        for(DayForecast day : week){
            System.out.println(day.toString()+"\n\n");
        }

    }


}