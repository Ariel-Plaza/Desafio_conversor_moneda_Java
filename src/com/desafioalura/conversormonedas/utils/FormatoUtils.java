package com.desafioalura.conversormonedas.utils;

import com.desafioalura.conversormonedas.model.ConversorMoneda;
//convierte el texto al formato solicitado
public class FormatoUtils {
    public static String formateoConversion(ConversorMoneda c, double monto){
        return "EL valor "+ monto +" ("+ c.moneda_base() +") corresponde al valor final de =>>> "+
                c.resultadoConversion() +
                " ("+c.moneda_convertida()+")";
    }
}
