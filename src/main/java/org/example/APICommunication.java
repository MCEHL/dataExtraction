package org.example;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APICommunication {
    final OkHttpClient client = new OkHttpClient();

    public String getForecast(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }

    // https://opendata-download-metfcst.smhi.se/api/category/snow1g/version/1/geotype/point/lon/16.158/lat/58.5812/data.json        //<- dinos, norrköping?
    // https://opendata-download-metfcst.smhi.se/api/category/snow1g/version/1/geotype/point/lon/11.9059/lat/57.8558/data.json        //<- dinos, göteborg?

    /*
    build url
                    /api/category/snow1g/version/1/geotype/point/lon/{longitude}/lat/{latitude}/data.json   <- All data

                    /api/category/snow1g/version/1/geotype/point/lon/{longitude}/lat/{latitude}/data.json?timeseries={timeseries}?parameters={parameters} <- Specifik data

                    /api/category/snow1g/version/1/geotype/point/lon/{longitude}/lat/{latitude}/data.json?timeseries={timeseries}?parameters=cloud_area_fraction,precipitation_amount_max,precipitation_amount_mean,precipitation_amount_mean_deterministic,precipitation_amount_min,probability_of_precipitation,predominant_precipitation_type_at_surface,relative_humidity,wind_speed,symbol_code


            Se Query Parameters för hur man bygger en query: https://opendata.smhi.se/metfcst/snow1gv1/get_point_forecast
            Se följande för alla parameters: https://opendata.smhi.se/metfcst/snow1gv1/parameters

            Vill troligen använda följande parametrar
            cloud_area_fraction,
            precipitation_amount_max,
            precipitation_amount_mean,
            precipitation_amount_mean_deterministic,
            precipitation_amount_min,
            probability_of_precipitation,
            predominant_precipitation_type_at_surface,
            relative_humidity,
            wind_speed,
            symbol_code

     */

}
