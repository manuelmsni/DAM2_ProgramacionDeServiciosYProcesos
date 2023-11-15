/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej_10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author manuelmsni
 */
public class Ej10 {
    public static void main(String[] args) {
        try {
            // Ejecutar el comando para obtener los servicios bajo svchost.exe
            ProcessBuilder processBuilder = new ProcessBuilder("tasklist", "/svc", "/fi", "imagename eq svchost.exe");
            Process process = processBuilder.start();

            // Leer la salida del proceso
            String servicios = new String(process.getInputStream().readAllBytes());

            // Guardar la lista de servicios en un archivo
            Path archivo = Path.of("SVCHOST.TXT");
            Files.write(archivo, servicios.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Servicios guardados en SVCHOST.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
