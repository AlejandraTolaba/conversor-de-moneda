package com.aluracursos.conversordemoneda.modelos;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoneda {
    public Double convierteMoneda(String monedaOrigen, String monedaDestino, Double valorAconvertir) throws Exception {
        ConsultaApi consultaApi = new ConsultaApi();
        String jsonResponse = consultaApi.obtieneJson(monedaOrigen);
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        if (jsonObject.has("conversion_rates")) {
            double valor = jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
            return valorAconvertir * valor;
        } else {
            throw new Exception("Moneda no encontrada");
        }
    }

    public void muestraConversion(Double valorAconvertir, String monedaOrigen, Double valorConvertido, String monedaDestino){
        System.out.println("El valor "+ valorAconvertir +" ["+monedaOrigen+"] corresponde al valor final de =>>> "+ valorConvertido +" ["+monedaDestino+"]");
    }

}
