package com.aluracursos.conversordemoneda.servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorDeMoneda {
    private String monedaOrigen;
    private String monedaDestino;
    private Double cantidadAconvertir;
    private Double cantidadConvertida;

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public Double getCantidadAconvertir() {
        return cantidadAconvertir;
    }

    public Double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public void setCantidadAconvertir(Double cantidadAconvertir) {
        this.cantidadAconvertir = cantidadAconvertir;
    }

    public void setCantidadConvertida(Double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }

    @Override
    public String toString() {
        return "El valor "+ cantidadAconvertir +" ["+monedaOrigen+"] corresponde al valor final de =>>> "+ cantidadConvertida +" ["+monedaDestino+"]";
    }
}
