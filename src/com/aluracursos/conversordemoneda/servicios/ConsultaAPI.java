package com.aluracursos.conversordemoneda.servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private String urlBase = "https://v6.exchangerate-api.com/v6/";
    private String claveAPI = "11a4827d4505138ef15aa4c4/";
    public Double obtieneResultadoConversion(ConversorDeMoneda conversor) throws Exception {
        URI direccion = URI.create(urlBase + claveAPI + "pair/" + conversor.getMonedaOrigen() + "/" + conversor.getMonedaDestino() + "/" + conversor.getCantidadAconvertir());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            String jsonResponse = response.body();
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            if (jsonObject.has("conversion_result")) {
                double resultado = jsonObject.get("conversion_result").getAsDouble();
                return resultado;
            } else {
                throw new Exception("Moneda no encontrada");
            }
        } else {
            throw new Exception("Error en la respuesta de la API. Código " + response.statusCode());
        }
    }
}
