package com.desafioalura.conversormonedas.model;

import com.google.gson.annotations.SerializedName;

public record ConversorMoneda(
        @SerializedName("base_code")
        String moneda_base,
        @SerializedName("target_code")
        String moneda_convertida,

        @SerializedName("conversion_rate")
        double tasaConversion,

        @SerializedName("conversion_result")
        double resultadoConversion
) { }
