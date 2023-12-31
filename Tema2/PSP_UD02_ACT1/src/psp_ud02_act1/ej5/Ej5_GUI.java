/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package psp_ud02_act1.ej5;

import psp_ud02_act1.ej4.*;
import psp_ud02_act1.ej3.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Vespertino
 */
public class Ej5_GUI extends javax.swing.JFrame {

    /**
     * Creates new form ej1_GUI
     */
    public Ej5_GUI() {
        initComponents();
        initCustom();
    }
    private void initCustom(){
        initNotepadButtonWin();
    }
    
    private void initNotepadButtonWin(){
        notepadButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad");
                Process process = pb.start();

                // Obtener el PID del proceso notepad
                long pid = getProcessId(process);
                System.out.println("PID de Notepad: " + pid);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private long getProcessId(Process process) {
        // Obtener el nombre del proceso, que contiene el PID
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        String[] parts = processName.split("@");

        if (parts.length > 0) {
            return Long.parseLong(parts[0]);
        } else {
            // Si no se puede obtener el PID, devolver -1
            return -1;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        notepadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(400, 100));

        panelPrincipal.setBackground(new java.awt.Color(255, 153, 255));
        panelPrincipal.setMaximumSize(this.getSize()
        );
        panelPrincipal.setPreferredSize(this.getSize()
        );
        panelPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        notepadButton.setText("Notepad");
        panelPrincipal.add(notepadButton);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ej5_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ej5_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ej5_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ej5_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ej5_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton notepadButton;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
