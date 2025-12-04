package com.desafioalura.conversormonedas.config;

import io.github.cdimascio.dotenv.Dotenv;

public class ApiConfig {

    private String monedaBase;
    private String monedaConvertir;
    private double monto;
    private String apiKey;
    private String apiUrl;


    public ApiConfig(String monedaBase, String monedaConvertir, double monto){
        this.monedaBase = monedaBase;
        this.monedaConvertir = monedaConvertir;
        this.monto = monto;

        // Cargar API Key desde .env
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("API_KEY");
        this.apiUrl = dotenv.get("API_URL");

    }
    @Override
    public String toString() {
//        return "https://v6.exchangerate-api.com/v6/36f90718e1b2d95345977392/pair/"+ monedaBase +"/" + monedaConvertir + "/" + monto;
          return apiUrl + apiKey + "/pair/"+ monedaBase +"/" + monedaConvertir + "/" + monto;

    }
}
