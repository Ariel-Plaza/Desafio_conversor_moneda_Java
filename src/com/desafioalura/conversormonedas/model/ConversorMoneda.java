package com.desafioalura.conversormonedas.model;

import com.google.gson.annotations.SerializedName;
//modifico nombres de data recibida desde la api
public record ConversorMoneda(
        @SerializedName("base_code")
        String moneda_base,

        @SerializedName("target_code")
        String moneda_convertida,

        @SerializedName("conversion_rate")
        double tasaConversion,

        @SerializedName("conversion_result")
        double resultadoConversion

) {
    //mensaje de salida
    @Override
    public String toString() {
        return "EL valor ("+ moneda_base +") corresponde al valor final de =>>> "+ resultadoConversion +" ("+moneda_convertida+")";
    }
}
