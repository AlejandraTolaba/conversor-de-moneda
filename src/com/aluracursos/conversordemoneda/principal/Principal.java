package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.modelos.ConsultaApi;
import com.aluracursos.conversordemoneda.modelos.ConversorDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoneda conversor = new ConversorDeMoneda();
        Double valorAconvertir = 0.0;
        Double valorConvertido;
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

            if (opcion != 7) {
                System.out.println("Ingrese el valor que desea convertir:");
                valorAconvertir = scanner.nextDouble();
            }

            switch (opcion) {
                case 1:
                    valorConvertido = conversor.convierteMoneda("USD","ARS",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"USD",valorConvertido,"ARS");
                    break;
                case 2:
                    valorConvertido = conversor.convierteMoneda("ARS","USD",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"ARS",valorConvertido,"USD");
                    break;
                case 3:
                    valorConvertido = conversor.convierteMoneda("USD","BRL",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"USD",valorConvertido,"BRL");
                    break;
                case 4:
                    valorConvertido = conversor.convierteMoneda("BRL","USD",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"BRL",valorConvertido,"USD");
                    break;
                case 5:
                    valorConvertido = conversor.convierteMoneda("USD","COP",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"USD",valorConvertido,"COP");
                    break;
                case 6:
                    valorConvertido = conversor.convierteMoneda("COP","USD",valorAconvertir);
                    conversor.muestraConversion(valorAconvertir,"COP",valorConvertido,"USD");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        }while (opcion != 7);

    }

}
