package com.desafioalura.conversormonedas.main;

import com.desafioalura.conversormonedas.client.Client;
import com.desafioalura.conversormonedas.config.ApiConfig;
import com.desafioalura.conversormonedas.model.ConversorMoneda;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {
    static void main(String[] args) {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        //Menu

        String mensaje = """
                  **************
                  Sea bienvenido/a al Conversor de Moneda =)
                  
                  1) Dólar =>> Peso argentino
                  2) Peso argentino =>> Dólar
                  3) Dólar =>> Real brasileño
                  4) Real brasileño =>> Dólar
                  5) Dólar =>> Peso colombiano
                  6) Peso colombiano =>> Dólar
                  7) Salir
                  Elija una opción válida:
                  **************
                  """;
        System.out.println(mensaje);
        //scanner


        //Llamado a la api segun opcion
        //SWITCH
        System.out.println("Ingresa el valor que deseas convertir:");
        //scanner

        //RESULTADO
        System.out.println("EL valor 25.0(USD) corresponde al valor final de =>>> 20293.75 (ARS)");

        // *****************

        //consumo API URL
        ApiConfig CLP = new ApiConfig("USD","CLP",1000000);
        System.out.println(CLP);
        try {
//            //es la clase que actuq como cliente
//            HttpClient client = HttpClient.
//                    //instancia de la clase
//                            newHttpClient();
//            //Clase que representa la petición/solicitud HTTP que vas a enviar
//            HttpRequest request = HttpRequest.
//                    //Crea un "constructor" de peticiones usando el patrón Builder
//                            newBuilder()
//                    //uri Define la dirección URL a donde vas a enviar la petición
//                    //Convierte un String (tu URL) en un objeto URI
//                    .uri(URI.create(String.valueOf(CLP)))
//                    //Finaliza la construcción y crea el objeto HttpRequest completo
//                    .build();
//
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
////            System.out.println("Response" + response.body());
            Client llamadoAPI = new Client();
            //modificar para recibir respuesta
            String json = llamadoAPI.http(CLP);
            System.out.println("Jsonnnn");
            System.out.println(json);
            ConversorMoneda conversor = gson.fromJson(json, ConversorMoneda.class);

            // Acceder a los datos
            System.out.println("Moneda base: " + conversor.moneda_base());
            System.out.println("Moneda objetivo: " + conversor.moneda_convertida());
            System.out.println("Tasa: " + conversor.tasaConversion());
            System.out.println("Resultado: " + conversor.resultadoConversion());


            //            System.out.println(json[0]);


            //gson parser gson object




        } catch (Exception e){
            System.out.println(e);
        }
        //filtros
    }
}
