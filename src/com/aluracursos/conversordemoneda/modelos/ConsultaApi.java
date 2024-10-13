package com.aluracursos.conversordemoneda.modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public String obtieneJson(String monedaOrigen) throws Exception {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/11a4827d4505138ef15aa4c4/latest/" + monedaOrigen);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new Exception("Error en la respuesta de la API: " + response.statusCode());
        }
    }
}
