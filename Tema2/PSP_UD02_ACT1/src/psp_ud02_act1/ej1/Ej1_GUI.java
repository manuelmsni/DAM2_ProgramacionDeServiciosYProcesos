/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package psp_ud02_act1.ej1;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Vespertino
 */
public class Ej1_GUI extends javax.swing.JFrame {

    /**
     * Creates new form ej1_GUI
     */
    public Ej1_GUI() {
        initComponents();
        initCustom();
    }
    
    private void initCustom(){
        initNotepadButton();
        initChromeButton();
        initAppButton();
    }
    
    private void initNotepadButton(){
        notepadButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("notepad");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void initChromeButton(){
        chromeButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
    
    private void initAppButton(){
        appButton.addActionListener((ActionEvent e) -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", "Output.jar");
                pb.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
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
        chromeButton = new javax.swing.JButton();
        appButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(153, 255, 255));
        panelPrincipal.setMaximumSize(this.getSize()
        );
        panelPrincipal.setPreferredSize(this.getSize()
        );

        notepadButton.setText("Notepad");

        chromeButton.setText("Chrome");

        appButton.setText("App");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(notepadButton)
                .addGap(18, 18, 18)
                .addComponent(chromeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(appButton)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chromeButton)
                    .addComponent(notepadButton)
                    .addComponent(appButton))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

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
            java.util.logging.Logger.getLogger(Ej1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ej1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ej1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ej1_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ej1_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton appButton;
    private javax.swing.JButton chromeButton;
    private javax.swing.JButton notepadButton;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
