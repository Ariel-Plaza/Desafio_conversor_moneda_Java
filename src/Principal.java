import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Principal {
    static void main(String[] args) {
        //consumo API
        //gson
        Gson gson = new Gson();

        String api_URL = "https://v6.exchangerate-api.com/v6/36f90718e1b2d95345977392/latest/CLP";

        try {
            //es la clase que actuq como cliente
            HttpClient client = HttpClient.
                    //instancia de la clase
                    newHttpClient();
            //Clase que representa la petición/solicitud HTTP que vas a enviar
            HttpRequest request = HttpRequest.
                    //Crea un "constructor" de peticiones usando el patrón Builder
                    newBuilder()
                    //uri Define la dirección URL a donde vas a enviar la petición
                    //Convierte un String (tu URL) en un objeto URI
                    .uri(URI.create(api_URL))
                    //Finaliza la construcción y crea el objeto HttpRequest completo
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //modificar para recibir respuesta
            String json = response.body();
            System.out.println("Json");
            System.out.println(json);

            //gson parser gson object

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
            System.out.println("Ingresa el valor que deseas convertir:");
            //scanner

            System.out.println("EL valor 25.0(USD) corresponde al valor final de =>>> 20293.75 (ARS)");
            

        } catch (Exception e){
            System.out.println(e);
        }
        //filtros
    }
}
