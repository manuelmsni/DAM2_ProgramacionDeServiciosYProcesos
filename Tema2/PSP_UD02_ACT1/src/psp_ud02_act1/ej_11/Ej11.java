/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author manuelmsni
 */
public class Ej11 {
    
    public static void main(String[] args) {
        generarArchivoPrueba();
        try {
            // Lee el archivo que contiene las instrucciones
            BufferedReader br = new BufferedReader(new FileReader("instrucciones.txt"));
            String linea;

            // Itera sobre cada l�nea del archivo
            while ((linea = br.readLine()) != null) {
                ejecutarProcesoForma2(linea);
            }

            // Cierra el BufferedReader
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void ejecutarProcesoForma1(String instruccion) {
        try {
            // Crea un proceso para ejecutar la instrucci�n
            ProcessBuilder processBuilder = new ProcessBuilder(instruccion.split("\\s+"));
            Process proceso = processBuilder.start();

            // Espera a que el proceso termine
            int exitCode = proceso.waitFor();

            // Muestra la salida del proceso
            if (exitCode == 0) {
                System.out.println("Instrucci�n ejecutada correctamente: " + instruccion);
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al ejecutar la instrucci�n: " + instruccion);
        }
    }
    private static void ejecutarProcesoForma2(String instruccion) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(instruccion.split("\\s+"));
            Process proceso = processBuilder.start();

            // Capturar la salida est�ndar
            InputStream inputStream = proceso.getInputStream();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));

            // Capturar la salida de error
            InputStream errorStream = proceso.getErrorStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));

            // Leer y mostrar la salida est�ndar
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println("Salida est�ndar: " + line);
            }

            // Leer y mostrar la salida de error
            while ((line = errorReader.readLine()) != null) {
                System.err.println("Salida de error: " + line);
            }

            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();

            if (exitCode == 0) {
                System.out.println("Instrucci�n ejecutada con �xito: " + instruccion);
            } else {
                System.err.println("Error al ejecutar la instrucci�n: " + instruccion);
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar la instrucci�n: " + instruccion);
            e.printStackTrace();
        }
    }
    public static void generarArchivoPrueba() {
        String[] instrucciones = {
            "cmd /c echo Hola Mundo",
            "mondongo",
            "cmd /c dir",
            "java -version",
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("instrucciones.txt"))) {
            for (String linea : instrucciones) {
                writer.write(linea);
                writer.newLine();
            }
            System.out.println("Archivo de prueba generado correctamente.");

        } catch (IOException e) {
            System.err.println("Error al generar el archivo de prueba: " + e.getMessage());
        }
    }
}
