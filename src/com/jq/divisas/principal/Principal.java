package com.jq.divisas.principal;

import com.google.gson.Gson;
import com.jq.divisas.modelos.Divisas;
import com.jq.divisas.modelos.DivisasDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String baseCurrency;
        String targetCurrency;
        double amount;

        Divisas listarDivisas = new Divisas();

        // Selección de moneda base
        listarDivisas.divisas();
        System.out.print("Seleccione la moneda base: ");
        baseCurrency = scanner.nextLine();

        switch (baseCurrency) {
            case "USD": case "EUR": case "MXN": case "JPY": case "GBP":
            case "AUD": case "CAD": case "CHF": case "CNY":
                System.out.println("Moneda base seleccionada: " + baseCurrency);
                break;
            default:
                System.out.println("Moneda base no válida.");
                return;
        }

        // Selección de moneda destino
        listarDivisas.divisas();
        System.out.print("Seleccione la moneda destino: ");
        targetCurrency = scanner.nextLine();

        switch (targetCurrency) {
            case "USD": case "EUR": case "MXN": case "JPY": case "GBP":
            case "AUD": case "CAD": case "CHF": case "CNY":
                System.out.println("Moneda destino seleccionada: " + targetCurrency);
                break;
            default:
                System.out.println("Moneda destino no válida.");
                return;
        }

        System.out.print("\n\nIngresa la cantida a convertir de " + baseCurrency + " por " + targetCurrency + " :");
        amount = scanner.nextDouble();

        String direccion = "https://v6.exchangerate-api.com/v6/501c2ff6744c80241422456f/pair/"
                + baseCurrency + "/" + targetCurrency + "/" + amount;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        Gson gson = new Gson();
        DivisasDTO divisasDTO = gson.fromJson(response.body(), DivisasDTO.class);
        System.out.println(divisasDTO);

        Divisas divisas = new Divisas(divisasDTO);

        divisas.setAmount(amount);
        System.out.println(divisas);

        // Simulación de conversión
        System.out.println("Convirtiendo de " + baseCurrency + " a " + targetCurrency);
        System.out.println("El valor actual debe consultarse desde una API externa.");
    }

}
