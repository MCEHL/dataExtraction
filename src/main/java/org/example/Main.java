package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String url = "https://opendata-download-metfcst.smhi.se/api/category/snow1g/version/1/geotype/point/lon/11.9059/lat/57.8558/data.json?timeseries={timeseries}?" +
                "symbol_code" +
                "parameters=cloud_area_fraction," +
                "probability_of_precipitation," +
                "precipitation_amount_max," +
                "precipitation_amount_mean," +
                "precipitation_amount_min," +
                "predominant_precipitation_type_at_surface," +
                "relative_humidity," +
                "wind_speed,";

        APICommunication request = new APICommunication();
        String response;

        try{
            response = request.getForecast(url);

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


        System.out.println(response);





    }
}