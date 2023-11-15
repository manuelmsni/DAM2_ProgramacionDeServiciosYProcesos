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

            // Itera sobre cada línea del archivo
            while ((linea = br.readLine()) != null) {
                try {
                    // Crea un proceso para ejecutar la instrucción
                    ProcessBuilder processBuilder = new ProcessBuilder(linea.split("\\s+"));
                    Process proceso = processBuilder.start();

                    // Espera a que el proceso termine
                    int exitCode = proceso.waitFor();

                    // Muestra la salida del proceso
                    if (exitCode == 0) {
                        System.out.println("Instrucción ejecutada correctamente: " + linea);
                    }
                } catch (IOException | InterruptedException ex) {
                    System.out.println("Error al ejecutar la instrucción: " + linea);
                }
            }

            // Cierra el BufferedReader
            br.close();

        } catch (IOException e) {
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
