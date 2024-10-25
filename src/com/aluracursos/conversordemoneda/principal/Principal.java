package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.servicios.ConsultaAPI;
import com.aluracursos.conversordemoneda.servicios.ConversorDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        ConsultaAPI resultadoConversion = new ConsultaAPI();
        Boolean opcionValida;
        int opcion;
        do{
            System.out.println("****************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println();
            System.out.println("****************************************");
            System.out.println("Elija una opción válida:");
            opcion = (int) scanner.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el valor que desea convertir:");
                conversor.setCantidadAconvertir(scanner.nextDouble());
                opcionValida = true;
            }
            else {
                opcionValida = false;
            }

            switch (opcion) {
                case 1:
                    conversor.setMonedaOrigen("USD");
                    conversor.setMonedaDestino("ARS");
                    break;
                case 2:
                    conversor.setMonedaOrigen("ARS");
                    conversor.setMonedaDestino("USD");
                    break;
                case 3:
                    conversor.setMonedaOrigen("USD");
                    conversor.setMonedaDestino("BRL");
                    break;
                case 4:
                    conversor.setMonedaOrigen("BRL");
                    conversor.setMonedaDestino("USD");
                    break;
                case 5:
                    conversor.setMonedaOrigen("USD");
                    conversor.setMonedaDestino("COP");
                    break;
                case 6:
                    conversor.setMonedaOrigen("COP");
                    conversor.setMonedaDestino("USD");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            if (opcionValida){
                conversor.setCantidadConvertida(resultadoConversion.obtieneResultadoConversion(conversor));
                System.out.println(conversor);
            }
            System.out.println();
        }while (opcion != 7);

    }

}
