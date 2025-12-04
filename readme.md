# Desafio Conversor de Moneda (Java)

Pequeña aplicación Java para convertir monedas. Proyecto organizado bajo el paquete `com.desafioalura.conversormonedas`. Pensado para ejecutarse desde IDE o línea de comandos y usar una dependencia local `dotenv` para configuración.

## Repositorio y rama
- Remote: `git@github.com:Ariel-Plaza/Desafio_conversor_moneda_Java.git`
- Rama de trabajo: `dev`
- Rama principal: `main`

## Estado
Ejercicio académico / en desarrollo.

## Requisitos
- JDK 17
- macOS (o similar)
- IDE recomendado: `IntelliJ IDEA`
- Dependencia local: `libs/dotenv-java-3.0.0.jar`
- No existe script de build (Gradle/Maven) incluido

## Instalación / compilación (línea de comandos)
1. Clonar el repositorio:
   `git clone git@github.com:Ariel-Plaza/Desafio_conversor_moneda_Java.git`
2. Desde la raíz del proyecto compilar:
   `javac -d out -cp "libs/dotenv-java-3.0.0.jar" $(find src -name "*.java")`
3. Ejecutar:
   `java -cp "out:libs/dotenv-java-3.0.0.jar" com.desafioalura.conversormonedas.main.Principal`

(El separador de classpath en macOS y Linux es `:`. En Windows usar `;`.)

## Ejecución desde IntelliJ IDEA
- Importar proyecto como proyecto Java usando `src` como carpeta de fuentes.
- Añadir `libs/dotenv-java-3.0.0.jar` al classpath del módulo (Project Structure \> Libraries).
- Ejecutar la clase principal: `com.desafioalura.conversormonedas.main.Principal`.

## Configuración
- Revisar `src/com/desafioalura/conversormonedas/config/ApiConfig.java` para endpoint y parámetros.
- El archivo `.env` está listado en `.\gitignore`; si usas claves o secretos, exportarlas como variables de entorno o configurarlas en el IDE.

## Estructura del proyecto
- `src/com/desafioalura/conversormonedas/main/Principal.java` — punto de entrada
- `src/com/desafioalura/conversormonedas/client/Client.java` — cliente HTTP
- `src/com/desafioalura/conversormonedas/config/ApiConfig.java` — configuración de API
- `src/com/desafioalura/conversormonedas/model/ConversorMoneda.java` — lógica de conversión
- `src/com/desafioalura/conversormonedas/utils/FormatoUtils.java` — utilidades de formato
- `src/com/desafioalura/conversormonedas/ApiTest.java` — pruebas
- `libs/` — dependencias locales (`dotenv-java-3.0.0.jar`)
- `.gitignore` — incluye `out/` y `.env`

## Contribución
- Crear ramas con prefijo `feature/` o `fix/`
- Abrir Pull Request con descripción y pasos para reproducir

## Contacto
Repositorio: `git@github.com:Ariel-Plaza/Desafio_conversor_moneda_Java.git`
