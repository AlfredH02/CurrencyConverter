package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import singleton.HttpClientSingleton;

public class ExchangeRateService {
    private static final String API_KEY = "3d63292805acd9e79fb0a92c";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClientSingleton.getInstance();
        String url = BASE_URL + API_KEY + "/latest/" + fromCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro inesperado: " + response);
        }

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        return jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
    }
}