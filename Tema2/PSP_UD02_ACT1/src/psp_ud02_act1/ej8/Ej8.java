/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej8;

import java.io.IOException;

/**
 *
 * @author manuelmsni
 */
public class Ej8 {
    public static void main(String[] args) {
        try {
            // Proceso abuelo
            System.out.println("Soy el proceso ABUELO: " + ProcessHandle.current().pid());
            
            // Crear proceso hijo
            ProcessBuilder hijoBuilder = new ProcessBuilder("java", "HijoProceso");
            Process hijo = hijoBuilder.start();
            int hijoPid = getPid(hijo);

            // Esperar a que el proceso hijo termine
            int resultadoHijo = hijo.waitFor();
            System.out.println("Mi HIJO: " + hijoPid + " terminó.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener el PID de un proceso
    private static int getPid(Process process) {
        return Long.valueOf(process.pid()).intValue();
    }
}
