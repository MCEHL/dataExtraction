package org.example;
import org.json.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.ForecastQueryParameters.*;

public class Main {
    public static void main(String[] args) {

        APICommunication request = new APICommunication();
        String response;

        try {
            response = request.getForecast(11.9059, 57.8558, 5, symbol_code,
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


        // Getting the created date
        String created = "/createdTime";
        String createdValue = (String) root.query(created);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime dateTime = LocalDateTime.parse(createdValue, formatter);
        LocalDate createdDate = dateTime.toLocalDate();

        // Getting station longitude and latitude
        String statCoords = "/geometry/coordinates";
        JSONArray coordsValue = (JSONArray) root.query(statCoords);
        double longitude = (double) coordsValue.get(0);
        double latitude = (double) coordsValue.get(1);

        System.out.println("Key: " + statCoords + " Class: " + longitude+", "+latitude);

        //System.out.println(root.toString(4));

        /*
        Gäller för alla dagar
            stationLongitude - /geometry/coordinates[0]
            stationLatitude - /geometry/coordinates[1]
            forecastCreated - /createdTime

        Delas upp per dag?
            date - /timeseries[i]/time //ta bort tid, ha bara datum




             */

    }


}