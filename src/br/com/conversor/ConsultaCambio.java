package br.com.conversor;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {
    public Cambio buscaCambio(String codigo_base, String codigo_destino, double valor_base) {

        // cole a api key na varíavel abaixo
        String apiKey = "sua api key aqui";

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + codigo_base + "/" + codigo_destino + "/" + valor_base);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(endereco)))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Cambio.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Cambio realToAmericanDollar(double valor_base) {
        return buscaCambio("BRL", "USD", valor_base);
    }

    public Cambio americanDollarToReal(double valor_base) {
        return buscaCambio("USD", "BRL", valor_base);
    }

    public Cambio realToEuro(double valor_base) {
        return buscaCambio("BRL", "EUR", valor_base);
    }

    public Cambio euroToReal(double valor_base) {
        return buscaCambio("EUR", "BRL", valor_base);
    }

    public Cambio realToCanadianDollar(double valor_base) {
        return buscaCambio("BRL", "CAD", valor_base);
    }

    public Cambio canadianDollarToReal(double valor_base) {
        return buscaCambio("CAD", "BRL", valor_base);
    }
}