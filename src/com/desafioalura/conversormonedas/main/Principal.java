package com.desafioalura.conversormonedas.main;

import com.desafioalura.conversormonedas.client.Client;
import com.desafioalura.conversormonedas.config.ApiConfig;
import com.desafioalura.conversormonedas.model.ConversorMoneda;
import com.desafioalura.conversormonedas.utils.FormatoUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean mostrarMenu = true;
        Scanner teclado = new Scanner(System.in);

        //Llamado a la API
        Client llamadoAPI = new Client();

        //Uso GSON
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (mostrarMenu){
            //MENU
            mostrarMenu();
            int opcionMenu = teclado.nextInt();
            teclado.nextLine();
            //validar que opcion no sea 0 o mayor que 8
            if(opcionMenu < 1 || opcionMenu > 7){
                System.out.println("\u001B[34m Por favor seleccione una opcion entre 1 y 7. \u001B[00m");
                continue;
            }

            if(opcionMenu == 7){
                mostrarMenu = false;
                break;
            }

            try {
                System.out.println("Ingresa el valor que deseas convertir: ");

                //scanner
                double monto = teclado.nextDouble();
                teclado.nextLine();

                //Llamado a la api segun opcion
                //SWITCH
                switch (opcionMenu){
                    case 1:
                        procesarConversion("USD", "CLP", monto, llamadoAPI, gson);
                        break;

                    case 2:
                        procesarConversion("CLP", "USD", monto, llamadoAPI, gson);
                        break;

                    case 3:
                        procesarConversion("USD", "BRL", monto, llamadoAPI, gson);
                        break;

                    case 4:
                        procesarConversion("BRL", "USD", monto, llamadoAPI, gson);
                        break;

                    case 5:
                        procesarConversion("USD", "ARS", monto, llamadoAPI, gson);
                        break;

                    case 6:
                        procesarConversion("ARS", "USD", monto, llamadoAPI, gson);
                        break;

                    default:
                        System.out.println("\u001B[31m Opcion invalida \u001B[00m");
                }

            } catch(com.google.gson.JsonSyntaxException e){
                System.out.println("\u001B[31m Por favor ingrese un monto mayor a 0 \u001B[00m" );
            }catch(IOException | InterruptedException e){
                System.out.println("Error de conexion: " + e.getMessage());
            }
            catch (Exception e){
                System.out.println("Error: " + e.getMessage() + "\u001B[00m");
            }
        }
        teclado.close();
    }
    //Generacion de Menu
    private static void mostrarMenu(){
        String mensaje = """
                  
                  **************
                  Sea bienvenido/a al Conversor de Moneda =)
             
                  1) Dólar =>> Peso chileno
                  2) Peso chileno =>> Dólar
                  3) Dólar =>> Real brasileño
                  4) Real brasileño =>> Dólar
                  5) Dólar =>> Peso argentino
                  6) Peso argentino =>> Dólar
                  7) Salir
                  Elija una opción válida:
                  **************
                  """;
        System.out.println(mensaje);
    }
    //Proceso completo de configuracion, llamado a la api y proceso de datos con Gson
    private static void procesarConversion(String moneda_base, String moneda_convertir, double monto,
                                           Client llamadoAPI, Gson gson) throws IOException, InterruptedException{
        ApiConfig apiConfig = new ApiConfig(moneda_base,moneda_convertir,monto);
        String json = llamadoAPI.http(apiConfig);
        ConversorMoneda conversor2 = gson.fromJson(json, ConversorMoneda.class);
        System.out.println(FormatoUtils.formateoConversion(conversor2, monto));
    }
}
