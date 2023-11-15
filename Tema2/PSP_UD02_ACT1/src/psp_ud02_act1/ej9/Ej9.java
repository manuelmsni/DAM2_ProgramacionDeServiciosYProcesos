/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp_ud02_act1.ej9;
import java.io.IOException;

/**
 *
 * @author manuelmsni
 */
public class Ej9 {
    
    public static void main(String[] args) {
        try {
            // Proceso abuelo
            Process abueloProcess = procesoAbuelo();

            // Matar el proceso abuelo
            abueloProcess.destroy();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Process procesoAbuelo() throws IOException, InterruptedException {
        int abueloPid = obtenerPid();
        System.out.println("Soy el proceso ABUELO: " + abueloPid);

        // Llamar al método para crear y ejecutar el proceso hijo
        Process hijoProcess = procesoHijo();
        hijoProcess.waitFor(); // Esperar a que el proceso hijo termine

        System.out.println("Soy el proceso ABUELO: " + abueloPid + ", Mi HIJO: " + hijoProcess.exitValue() + " terminó.");

        return hijoProcess; // Devolver el proceso hijo
    }

    public static Process procesoHijo() throws IOException, InterruptedException {
        int hijoPid = obtenerPid();
        int abueloPid = obtenerPadrePid();

        // Proceso hijo
        System.out.println("Soy el proceso HIJO " + hijoPid + ", Mi padre es: " + abueloPid);

        // Llamar al método para crear y ejecutar el proceso nieto
        Process nietoProcess = procesoNieto();
        nietoProcess.waitFor(); // Esperar a que el proceso nieto termine

        System.out.println("Soy el proceso HIJO " + hijoPid + ", Mi HIJO: " + nietoProcess.exitValue() + " terminó.");

        return nietoProcess;
    }

    public static Process procesoNieto() throws IOException, InterruptedException {
        int nietoPid = obtenerPid();
        int padrePid = obtenerPadrePid();

        // Proceso nieto
        System.out.println("Soy el proceso NIETO " + nietoPid + "; Mi padre es= " + padrePid);

        // Crear un proceso nieto simple (puedes personalizar esto según tus necesidades)
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "echo Hola desde el proceso nieto");
        return pb.start();
    }

    private static int obtenerPid() {
        return Long.valueOf(ProcessHandle.current().pid()).intValue();
    }

    private static int obtenerPadrePid() {
        return Long.valueOf(ProcessHandle.current().parent().map(ProcessHandle::pid).orElse(-1L)).intValue();
    }
}
