package com.desafioalura.conversormonedas.config;

public class ApiConfig {

    private String moneda_base;
    private String moneda_convertir;
    private double monto;
    public static String url;

    public ApiConfig(String moneda_base, String moneda_convertir, double monto){
        this.moneda_base = moneda_base;
        this.moneda_convertir = moneda_convertir;
        this.monto = monto;

    }
    @Override
    public String toString() {
        return "https://v6.exchangerate-api.com/v6/36f90718e1b2d95345977392/pair/"+ moneda_base +"/" + moneda_convertir + "/" + monto;
    }
}
