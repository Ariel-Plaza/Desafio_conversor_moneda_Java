package com.desafioalura.conversormonedas.model;

import com.google.gson.annotations.SerializedName;
//modifico nombres de data recibida desde la api
public record ConversorMoneda(
        @SerializedName("base_code")
        String monedaBase,

        @SerializedName("target_code")
        String monedaConvertida,

        @SerializedName("conversion_rate")
        double tasaConversion,

        @SerializedName("conversion_result")
        double resultadoConversion

) {
    //mensaje de salida
    @Override
    public String toString() {
        return "El valor ("+ monedaBase +") corresponde al valor final de =>>> "+ resultadoConversion +" ("+ monedaConvertida +")";
    }
}
