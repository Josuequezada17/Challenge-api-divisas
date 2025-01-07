package com.jq.divisas.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jq.divisas.modelos.Divisas;
import com.jq.divisas.modelos.DivisasDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner divisa1 = new Scanner(System.in);
        Scanner divisa2 = new Scanner(System.in);
        Scanner amount = new Scanner(System.in);

        System.out.print("Ingresa la divisa inicial a convertir: ");
        var divisa = divisa1.nextLine();

        System.out.print("Ingresa la divisa a convertir: ");
        var divisaConv = divisa2.nextLine();

        System.out.print("Ingresa la cantida a convertir de " + divisa + " por " + divisaConv + " :");
        var target = amount.nextLine();

        String direccion = "https://v6.exchangerate-api.com/v6/501c2ff6744c80241422456f/pair/"
                + divisa + "/" + divisaConv + "/" + target;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        Gson gson = new Gson();
        DivisasDTO divisasDTO = gson.fromJson(response.body(), DivisasDTO.class);
        System.out.println(divisasDTO);

        Divisas divisas = new Divisas(divisasDTO);
        divisas.setAmount(Double.parseDouble(target));
        System.out.println(divisas);

    }
}