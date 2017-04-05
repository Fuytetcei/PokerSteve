/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.awt.Color;

/**
 *
 * @author user
 */
public class Cartas extends javax.swing.JFrame {

    private boolean[][] seleccionados;
    private int numSeleccionados;
    private boolean tipo;
    public String seleccion;
    private Principal p;

    public Cartas(boolean type, Principal p) {
        initComponents();
        
        this.tipo = type;
        this.seleccionados = new boolean[13][4];
        for(int i=0;i<13;i++) {
            for(int j=0;j<4;j++) {
                this.seleccionados[i][j] = false;
            }
        }
        this.numSeleccionados = 0;
        this.p = p;
        seleccion = "";
    }                                                                                                     

    private void j5dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[3][1]){
            this.seleccionados[3][1] = false;
            this.numSeleccionados--;
            this.j5d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[3][1] = true;
            this.numSeleccionados++;
            this.j5d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[3][1] = false;
                this.numSeleccionados--;
                this.j5d.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j4dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[2][1]){
            this.seleccionados[2][1] = false;
            this.numSeleccionados--;
            this.j4d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[2][1] = true;
                this.numSeleccionados++;
                this.j4d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[2][1] = false;
                this.numSeleccionados--;
                this.j4d.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j3dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[1][1]){
            this.seleccionados[1][1] = false;
            this.numSeleccionados--;
            this.j3d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[1][1] = true;
                this.numSeleccionados++;
                this.j3d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[1][1] = false;
                this.numSeleccionados--;
                this.j3d.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j2dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[0][1]){
            this.seleccionados[0][1] = false;
            this.numSeleccionados--;
            this.j2d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[0][1] = true;
                this.numSeleccionados++;
                this.j2d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[0][1] = false;
                this.numSeleccionados--;
                this.j2d.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jAhActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[12][2]){
            this.seleccionados[12][2] = false;
            this.numSeleccionados--;
            this.jAh.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[12][2] = true;
                this.numSeleccionados++;
                this.jAh.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[12][2] = false;
                this.numSeleccionados--;
                this.jAh.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jKhActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[11][2]){
            this.seleccionados[11][2] = false;
            this.numSeleccionados--;
            this.jKh.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[11][2] = true;
                this.numSeleccionados++;
                this.jKh.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[11][2] = false;
                this.numSeleccionados--;
                this.jKh.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jQhActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[10][2]){
            this.seleccionados[10][2] = false;
            this.numSeleccionados--;
            this.jQh.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[10][2] = true;
                this.numSeleccionados++;
                this.jQh.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[10][2] = false;
                this.numSeleccionados--;
                this.jQh.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jJhActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[9][2]){
            this.seleccionados[9][2] = false;
            this.numSeleccionados--;
            this.jJh.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[9][2] = true;
                this.numSeleccionados++;
                this.jJh.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[9][2] = false;
                this.numSeleccionados--;
                this.jJh.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jThActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[8][2]){
            this.seleccionados[8][2] = false;
            this.numSeleccionados--;
            this.jTh.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[8][2] = true;
                this.numSeleccionados++;
                this.jTh.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[8][2] = false;
                this.numSeleccionados--;
                this.jTh.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j9hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[7][2]){
            this.seleccionados[7][2] = false;
            this.numSeleccionados--;
            this.j9h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[7][2] = true;
                this.numSeleccionados++;
                this.j9h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[7][2] = false;
                this.numSeleccionados--;
                this.j9h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j8hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[6][2]){
            this.seleccionados[6][2] = false;
            this.numSeleccionados--;
            this.j8h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[6][2] = true;
                this.numSeleccionados++;
                this.j8h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[6][2] = false;
                this.numSeleccionados--;
                this.j8h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j7hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[5][2]){
            this.seleccionados[5][2] = false;
            this.numSeleccionados--;
            this.j7h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[5][2] = true;
                this.numSeleccionados++;
                this.j7h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[5][2] = false;
                this.numSeleccionados--;
                this.j7h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j6hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[4][2]){
            this.seleccionados[4][2] = false;
            this.numSeleccionados--;
            this.j6h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[4][2] = true;
                this.numSeleccionados++;
                this.j6h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[4][2] = false;
                this.numSeleccionados--;
                this.j6h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j5hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[3][2]){
            this.seleccionados[3][2] = false;
            this.numSeleccionados--;
            this.j5h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[3][2] = true;
                this.numSeleccionados++;
                this.j5h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[3][2] = false;
                this.numSeleccionados--;
                this.j5h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j4hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[2][2]){
            this.seleccionados[2][2] = false;
            this.numSeleccionados--;
            this.j4h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[2][2] = true;
                this.numSeleccionados++;
                this.j4h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[2][2] = false;
                this.numSeleccionados--;
                this.j4h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j3hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[1][2]){
            this.seleccionados[1][2] = false;
            this.numSeleccionados--;
            this.j3h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[1][2] = true;
                this.numSeleccionados++;
                this.j3h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[1][2] = false;
                this.numSeleccionados--;
                this.j3h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j2hActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[0][2]){
            this.seleccionados[0][2] = false;
            this.numSeleccionados--;
            this.j2h.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[0][3] = true;
                this.numSeleccionados++;
                this.j2h.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[0][2] = false;
                this.numSeleccionados--;
                this.j2h.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jAsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[12][3]){
            this.seleccionados[12][3] = false;
            this.numSeleccionados--;
            this.jAs.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[12][3] = true;
            this.numSeleccionados++;
            this.jAs.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[12][3] = false;
                this.numSeleccionados--;
                this.jAs.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jKsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[11][3]){
            this.seleccionados[11][3] = false;
            this.numSeleccionados--;
            this.jKs.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[11][3] = true;
                this.numSeleccionados++;
                this.jKs.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[11][3] = false;
                this.numSeleccionados--;
                this.jKs.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jQsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[10][3]){
            this.seleccionados[10][3] = false;
            this.numSeleccionados--;
            this.jQs.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[10][3] = true;
                this.numSeleccionados++;
                this.jQs.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[10][3] = false;
                this.numSeleccionados--;
                this.jQs.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jJsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[9][3]){
            this.seleccionados[9][3] = false;
            this.numSeleccionados--;
            this.jJs.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[9][3] = true;
                this.numSeleccionados++;
                this.jJs.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[9][3] = false;
                this.numSeleccionados--;
                this.jJs.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jTsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[8][3]){
            this.seleccionados[8][3] = false;
            this.numSeleccionados--;
            this.jTs.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[8][3] = true;
                this.numSeleccionados++;
                this.jTs.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[8][3] = false;
                this.numSeleccionados--;
                this.jTs.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j9sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[7][3]){
            this.seleccionados[7][3] = false;
            this.numSeleccionados--;
            this.j9s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[7][3] = true;
                this.numSeleccionados++;
                this.j9s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[7][3] = false;
                this.numSeleccionados--;
                this.j9s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j8sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[6][3]){
            this.seleccionados[6][3] = false;
            this.numSeleccionados--;
            this.j8s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[6][3] = true;
                this.numSeleccionados++;
                this.j8s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[6][3] = false;
                this.numSeleccionados--;
                this.j8s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j7sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[5][3]){
            this.seleccionados[5][3] = false;
            this.numSeleccionados--;
            this.j7s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[5][3] = true;
                this.numSeleccionados++;
                this.j7s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[5][3] = false;
                this.numSeleccionados--;
                this.j7s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j6sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[4][3]){
            this.seleccionados[4][3] = false;
            this.numSeleccionados--;
            this.j6s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[4][3] = true;
                this.numSeleccionados++;
                this.j6s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[4][3] = false;
                this.numSeleccionados--;
                this.j6s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j5sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[3][3]){
            this.seleccionados[3][3] = false;
            this.numSeleccionados--;
            this.j5s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[3][3] = true;
                this.numSeleccionados++;
                this.j5s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[3][3] = false;
                this.numSeleccionados--;
                this.j5s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j4sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[2][3]){
            this.seleccionados[2][3] = false;
            this.numSeleccionados--;
            this.j4s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[2][3] = true;
                this.numSeleccionados++;
                this.j4s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[2][3] = false;
                this.numSeleccionados--;
                this.j4s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j3sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[1][3]){
            this.seleccionados[1][3] = false;
            this.numSeleccionados--;
            this.j3s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[1][3] = true;
                this.numSeleccionados++;
                this.j3s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[1][3] = false;
                this.numSeleccionados--;
                this.j3s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void j2sActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[0][3]){
            this.seleccionados[0][3] = false;
            this.numSeleccionados--;
            this.j2s.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[0][3] = true;
                this.numSeleccionados++;
                this.j2s.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[0][3] = false;
                this.numSeleccionados--;
                this.j2s.setBackground(Color.GRAY);
            }
        }
    }                                   

    private void jClearActionPerformed(java.awt.event.ActionEvent evt) {                                       
        for(int i=0;i<13;i++) {
            for(int j=0;j<4;j++) {
                this.seleccionados[i][j] = false;
            }
        }
        this.jAc.setBackground(Color.GRAY);
        this.jKc.setBackground(Color.GRAY);
        this.jQc.setBackground(Color.GRAY);
        this.jJc.setBackground(Color.GRAY);
        this.jTc.setBackground(Color.GRAY);
        this.j9c.setBackground(Color.GRAY);
        this.j8c.setBackground(Color.GRAY);
        this.j7c.setBackground(Color.GRAY);
        this.j6c.setBackground(Color.GRAY);
        this.j5c.setBackground(Color.GRAY);
        this.j4c.setBackground(Color.GRAY);
        this.j3c.setBackground(Color.GRAY);
        this.j2c.setBackground(Color.GRAY);
        this.jAd.setBackground(Color.GRAY);
        this.jKd.setBackground(Color.GRAY);
        this.jQd.setBackground(Color.GRAY);
        this.jJd.setBackground(Color.GRAY);
        this.jTd.setBackground(Color.GRAY);
        this.j9d.setBackground(Color.GRAY);
        this.j8d.setBackground(Color.GRAY);
        this.j7d.setBackground(Color.GRAY);
        this.j6d.setBackground(Color.GRAY);
        this.j5d.setBackground(Color.GRAY);
        this.j4d.setBackground(Color.GRAY);
        this.j3d.setBackground(Color.GRAY);
        this.j2d.setBackground(Color.GRAY);
        this.jAh.setBackground(Color.GRAY);
        this.jKh.setBackground(Color.GRAY);
        this.jQh.setBackground(Color.GRAY);
        this.jJh.setBackground(Color.GRAY);
        this.jTh.setBackground(Color.GRAY);
        this.j9h.setBackground(Color.GRAY);
        this.j8h.setBackground(Color.GRAY);
        this.j7h.setBackground(Color.GRAY);
        this.j6h.setBackground(Color.GRAY);
        this.j5h.setBackground(Color.GRAY);
        this.j4h.setBackground(Color.GRAY);
        this.j3h.setBackground(Color.GRAY);
        this.j2h.setBackground(Color.GRAY);
        this.jAs.setBackground(Color.GRAY);
        this.jKs.setBackground(Color.GRAY);
        this.jQs.setBackground(Color.GRAY);
        this.jTs.setBackground(Color.GRAY);
        this.j9s.setBackground(Color.GRAY);
        this.j8s.setBackground(Color.GRAY);
        this.j7s.setBackground(Color.GRAY);
        this.j6s.setBackground(Color.GRAY);
        this.j5s.setBackground(Color.GRAY);
        this.j4s.setBackground(Color.GRAY);
        this.j3s.setBackground(Color.GRAY);
        this.jJs.setBackground(Color.GRAY);
        this.j2s.setBackground(Color.GRAY);
        this.numSeleccionados = 0;
    }                                      

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {                                    
        
        // Miro que cartas han sido seleccionadas
        for(int i=0;i<13;i++) {
            for(int j=0;j<4;j++) {
                if(seleccionados[i][j]) {
                    seleccion = seleccion + Poker.numberLetter[i] + Poker.numberColor[j]+',';
                }
            }
        }
        // Quito la última coma
        if(seleccion.length()>0) {
            seleccion = seleccion.substring(0, seleccion.length()-1);
        }
        this.p.actualizarBoard(tipo);
        this.setVisible(false);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAc = new javax.swing.JButton();
        jKc = new javax.swing.JButton();
        jQc = new javax.swing.JButton();
        jJc = new javax.swing.JButton();
        jTc = new javax.swing.JButton();
        j9c = new javax.swing.JButton();
        j8c = new javax.swing.JButton();
        j7c = new javax.swing.JButton();
        j6c = new javax.swing.JButton();
        j5c = new javax.swing.JButton();
        j4c = new javax.swing.JButton();
        j3c = new javax.swing.JButton();
        j2c = new javax.swing.JButton();
        jAd = new javax.swing.JButton();
        jKd = new javax.swing.JButton();
        jQd = new javax.swing.JButton();
        jJd = new javax.swing.JButton();
        jTd = new javax.swing.JButton();
        j9d = new javax.swing.JButton();
        j8d = new javax.swing.JButton();
        j7d = new javax.swing.JButton();
        j6d = new javax.swing.JButton();
        j5d = new javax.swing.JButton();
        j4d = new javax.swing.JButton();
        j3d = new javax.swing.JButton();
        j2d = new javax.swing.JButton();
        jAh = new javax.swing.JButton();
        jKh = new javax.swing.JButton();
        jQh = new javax.swing.JButton();
        jJh = new javax.swing.JButton();
        jTh = new javax.swing.JButton();
        j9h = new javax.swing.JButton();
        j8h = new javax.swing.JButton();
        j7h = new javax.swing.JButton();
        j6h = new javax.swing.JButton();
        j5h = new javax.swing.JButton();
        j4h = new javax.swing.JButton();
        j3h = new javax.swing.JButton();
        j2h = new javax.swing.JButton();
        jAs = new javax.swing.JButton();
        jKs = new javax.swing.JButton();
        jQs = new javax.swing.JButton();
        jJs = new javax.swing.JButton();
        jTs = new javax.swing.JButton();
        j9s = new javax.swing.JButton();
        j8s = new javax.swing.JButton();
        j7s = new javax.swing.JButton();
        j6s = new javax.swing.JButton();
        j5s = new javax.swing.JButton();
        j4s = new javax.swing.JButton();
        j3s = new javax.swing.JButton();
        j2s = new javax.swing.JButton();
        jOK = new javax.swing.JButton();
        jCancel = new javax.swing.JButton();
        jClear = new javax.swing.JButton();

        jAc.setText("Ac");
        jAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAcActionPerformed(evt);
            }
        });

        jKc.setText("Kc");
        jKc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKcActionPerformed(evt);
            }
        });

        jQc.setText("Qc");
        jQc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQcActionPerformed(evt);
            }
        });

        jJc.setText("Jc");
        jJc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJcActionPerformed(evt);
            }
        });

        jTc.setText("Tc");
        jTc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTcActionPerformed(evt);
            }
        });

        j9c.setText("9c");
        j9c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j9cActionPerformed(evt);
            }
        });

        j8c.setText("8c");
        j8c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j8cActionPerformed(evt);
            }
        });

        j7c.setText("7c");
        j7c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j7cActionPerformed(evt);
            }
        });

        j6c.setText("6c");
        j6c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j6cActionPerformed(evt);
            }
        });

        j5c.setText("5c");
        j5c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5cActionPerformed(evt);
            }
        });

        j4c.setText("4c");
        j4c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4cActionPerformed(evt);
            }
        });

        j3c.setText("3c");
        j3c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3cActionPerformed(evt);
            }
        });

        j2c.setText("2c");
        j2c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2cActionPerformed(evt);
            }
        });

        jAd.setText("Ad");
        jAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdActionPerformed(evt);
            }
        });

        jKd.setText("Kd");
        jKd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKdActionPerformed(evt);
            }
        });

        jQd.setText("Qd");
        jQd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQdActionPerformed(evt);
            }
        });

        jJd.setText("Jd");
        jJd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJdActionPerformed(evt);
            }
        });

        jTd.setText("Td");
        jTd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTdActionPerformed(evt);
            }
        });

        j9d.setText("9d");
        j9d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j9dActionPerformed(evt);
            }
        });

        j8d.setText("8d");
        j8d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j8dActionPerformed(evt);
            }
        });

        j7d.setText("7d");
        j7d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j7dActionPerformed(evt);
            }
        });

        j6d.setText("6d");
        j6d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j6dActionPerformed(evt);
            }
        });

        j5d.setText("5d");
        j5d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5dActionPerformed(evt);
            }
        });

        j4d.setText("4d");
        j4d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4dActionPerformed(evt);
            }
        });

        j3d.setText("3d");
        j3d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3dActionPerformed(evt);
            }
        });

        j2d.setText("2d");
        j2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2dActionPerformed(evt);
            }
        });

        jAh.setText("Ah");
        jAh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAhActionPerformed(evt);
            }
        });

        jKh.setText("Kh");
        jKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKhActionPerformed(evt);
            }
        });

        jQh.setText("Qh");
        jQh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQhActionPerformed(evt);
            }
        });

        jJh.setText("Jh");
        jJh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJhActionPerformed(evt);
            }
        });

        jTh.setText("Th");
        jTh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThActionPerformed(evt);
            }
        });

        j9h.setText("9h");
        j9h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j9hActionPerformed(evt);
            }
        });

        j8h.setText("8h");
        j8h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j8hActionPerformed(evt);
            }
        });

        j7h.setText("7h");
        j7h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j7hActionPerformed(evt);
            }
        });

        j6h.setText("6h");
        j6h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j6hActionPerformed(evt);
            }
        });

        j5h.setText("5h");
        j5h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5hActionPerformed(evt);
            }
        });

        j4h.setText("4h");
        j4h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4hActionPerformed(evt);
            }
        });

        j3h.setText("3h");
        j3h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3hActionPerformed(evt);
            }
        });

        j2h.setText("2h");
        j2h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2hActionPerformed(evt);
            }
        });

        jAs.setText("As");
        jAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAsActionPerformed(evt);
            }
        });

        jKs.setText("Ks");
        jKs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jKsActionPerformed(evt);
            }
        });

        jQs.setText("Qs");
        jQs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQsActionPerformed(evt);
            }
        });

        jJs.setText("Js");
        jJs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJsActionPerformed(evt);
            }
        });

        jTs.setText("Ts");
        jTs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTsActionPerformed(evt);
            }
        });

        j9s.setText("9s");
        j9s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j9sActionPerformed(evt);
            }
        });

        j8s.setText("8s");
        j8s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j8sActionPerformed(evt);
            }
        });

        j7s.setText("7s");
        j7s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j7sActionPerformed(evt);
            }
        });

        j6s.setText("6s");
        j6s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j6sActionPerformed(evt);
            }
        });

        j5s.setText("5s");
        j5s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5sActionPerformed(evt);
            }
        });

        j4s.setText("4s");
        j4s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4sActionPerformed(evt);
            }
        });

        j3s.setText("3s");
        j3s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3sActionPerformed(evt);
            }
        });

        j2s.setText("2s");
        j2s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2sActionPerformed(evt);
            }
        });

        jOK.setText("OK");
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });

        jCancel.setText("Cancel");
        jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelActionPerformed(evt);
            }
        });

        jClear.setText("Clear");
        jClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAc)
                    .addComponent(jKc)
                    .addComponent(jQc)
                    .addComponent(jJc)
                    .addComponent(jTc)
                    .addComponent(j9c)
                    .addComponent(j8c)
                    .addComponent(j7c)
                    .addComponent(j6c)
                    .addComponent(j5c)
                    .addComponent(j4c)
                    .addComponent(j3c)
                    .addComponent(j2c))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAd)
                    .addComponent(jKd)
                    .addComponent(jQd)
                    .addComponent(j9d)
                    .addComponent(j8d)
                    .addComponent(j7d)
                    .addComponent(j6d)
                    .addComponent(j5d)
                    .addComponent(j4d)
                    .addComponent(j3d)
                    .addComponent(j2d)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jJd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jAh)
                    .addComponent(jKh)
                    .addComponent(jQh)
                    .addComponent(jJh)
                    .addComponent(jTh)
                    .addComponent(j9h)
                    .addComponent(j8h)
                    .addComponent(j7h)
                    .addComponent(j6h)
                    .addComponent(j5h)
                    .addComponent(j4h)
                    .addComponent(j3h)
                    .addComponent(j2h))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jJs)
                    .addComponent(jTs)
                    .addComponent(j9s)
                    .addComponent(j8s)
                    .addComponent(j7s)
                    .addComponent(j6s)
                    .addComponent(j5s)
                    .addComponent(j4s)
                    .addComponent(j3s)
                    .addComponent(j2s)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jQs)
                        .addGap(50, 50, 50)
                        .addComponent(jClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAs)
                            .addComponent(jKs))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jAs)
                            .addComponent(jOK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jKs)
                            .addComponent(jCancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jQs)
                            .addComponent(jClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j9s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j8s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j7s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j6s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j5s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j4s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j3s)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2s))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j9h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j8h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j7h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j6h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j5h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j4h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j3h)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2h))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j9d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j8d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j7d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j6d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j5d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j4d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j3d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2d))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jKc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jQc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jJc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j9c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j8c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j7c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j6c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j5c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j4c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j3c)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(j2c)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAcActionPerformed
        if(this.seleccionados[12][0]){
                this.seleccionados[12][0] = false;
                this.numSeleccionados--;
                this.jAc.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[12][0] = true;
            this.numSeleccionados++;
            this.jAc.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[12][0] = false;
                this.numSeleccionados--;
                this.jAc.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jAcActionPerformed

    private void jKcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKcActionPerformed
        if(this.seleccionados[11][0]){
            this.seleccionados[11][0] = false;
            this.numSeleccionados--;
            this.jKc.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[11][0] = true;
                this.numSeleccionados++;
                this.jKc.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[11][0] = false;
                this.numSeleccionados--;
                this.jKc.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jKcActionPerformed

    private void jQcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQcActionPerformed
        if(this.seleccionados[10][0]){
            this.seleccionados[10][0] = false;
            this.numSeleccionados--;
            this.jQc.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[10][0] = true;
                this.numSeleccionados++;
                this.jQc.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[10][0] = false;
                this.numSeleccionados--;
                this.jQc.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jQcActionPerformed

    private void jJcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJcActionPerformed
        if(this.seleccionados[9][0]){
            this.seleccionados[9][0] = false;
            this.numSeleccionados--;
            this.jJc.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[9][0] = true;
                this.numSeleccionados++;
                this.jJc.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[9][0] = false;
                this.numSeleccionados--;
                this.jJc.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jJcActionPerformed

    private void jTcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTcActionPerformed
        if(this.seleccionados[8][0]){
            this.seleccionados[8][0] = false;
            this.numSeleccionados--;
            this.jTc.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[8][0] = true;
                this.numSeleccionados++;
                this.jTc.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[8][0] = false;
                this.numSeleccionados--;
                this.jTc.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jTcActionPerformed

    private void j9cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j9cActionPerformed
        if(this.seleccionados[7][0]){
            this.seleccionados[7][0] = false;
            this.numSeleccionados--;
            this.j9c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[7][0] = true;
                this.numSeleccionados++;
                this.j9c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[7][0] = false;
                this.numSeleccionados--;
                this.j9c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j9cActionPerformed

    private void j8cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j8cActionPerformed
        if(this.seleccionados[6][0]){
            this.seleccionados[6][0] = false;
            this.numSeleccionados--;
            this.j8c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[6][0] = true;
                this.numSeleccionados++;
                this.j8c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[6][0] = false;
                this.numSeleccionados--;
                this.j8c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j8cActionPerformed

    private void j7cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j7cActionPerformed
        if(this.seleccionados[5][0]){
            this.seleccionados[5][0] = false;
            this.numSeleccionados--;
            this.j7c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[5][0] = true;
                this.numSeleccionados++;
                this.j7c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[5][0] = false;
                this.numSeleccionados--;
                this.j7c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j7cActionPerformed

    private void j6cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j6cActionPerformed
        if(this.seleccionados[4][0]){
            this.seleccionados[4][0] = false;
            this.numSeleccionados--;
            this.j6c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[4][0] = true;
                this.numSeleccionados++;
                this.j6c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[4][0] = false;
                this.numSeleccionados--;
                this.j6c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j6cActionPerformed

    private void j5cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j5cActionPerformed
        if(this.seleccionados[3][0]){
            this.seleccionados[3][0] = false;
            this.numSeleccionados--;
            this.j5c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[3][0] = true;
            this.numSeleccionados++;
            this.j5c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[3][0] = false;
                this.numSeleccionados--;
                this.j5c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j5cActionPerformed

    private void j4cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j4cActionPerformed
        if(this.seleccionados[2][0]){
            this.seleccionados[2][0] = false;
            this.numSeleccionados--;
            this.j4c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[2][0] = true;
            this.numSeleccionados++;
            this.j4c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[2][0] = false;
                this.numSeleccionados--;
                this.j4c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j4cActionPerformed

    private void j3cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j3cActionPerformed
        if(this.seleccionados[1][0]){
            this.seleccionados[1][0] = false;
            this.numSeleccionados--;
            this.j3c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[1][0] = true;
                this.numSeleccionados++;
                this.j3c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[1][0] = false;
                this.numSeleccionados--;
                this.j3c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j3cActionPerformed

    private void j2cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j2cActionPerformed
        if(this.seleccionados[0][0]){
            this.seleccionados[0][0] = false;
            this.numSeleccionados--;
            this.j2c.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[0][0] = true;
                this.numSeleccionados++;
                this.j2c.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[0][0] = false;
                this.numSeleccionados--;
                this.j2c.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j2cActionPerformed

    private void jAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdActionPerformed
        if(this.seleccionados[12][1]){
            this.seleccionados[12][1] = false;
            this.numSeleccionados--;
            this.jAd.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[12][1] = true;
                this.numSeleccionados++;
                this.jAd.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[12][1] = false;
                this.numSeleccionados--;
                this.jAd.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jAdActionPerformed

    private void jKdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jKdActionPerformed
        if(this.seleccionados[11][1]){
            this.seleccionados[11][1] = false;
            this.numSeleccionados--;
            this.jKd.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[11][1] = true;
            this.numSeleccionados++;
            this.jKd.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[11][1] = false;
                this.numSeleccionados--;
                this.jKd.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jKdActionPerformed

    private void jQdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQdActionPerformed
         if(this.seleccionados[10][1]){
            this.seleccionados[10][1] = false;
            this.numSeleccionados--;
            this.jQd.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[10][1] = true;
            this.numSeleccionados++;
            this.jQd.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[10][1] = false;
                this.numSeleccionados--;
                this.jQd.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jQdActionPerformed

    private void jJdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJdActionPerformed
        if(this.seleccionados[9][1]){
            this.seleccionados[9][1] = false;
            this.numSeleccionados--;
            this.jJd.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[9][1] = true;
            this.numSeleccionados++;
            this.jJd.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[9][1] = false;
                this.numSeleccionados--;
                this.jJd.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jJdActionPerformed

    private void jTdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTdActionPerformed
        if(this.seleccionados[8][1]){
            this.seleccionados[8][1] = false;
            this.numSeleccionados--;
            this.jTd.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[8][1] = true;
            this.numSeleccionados++;
            this.jTd.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[8][1] = false;
                this.numSeleccionados--;
                this.jTd.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_jTdActionPerformed

    private void j9dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j9dActionPerformed
        if(this.seleccionados[7][1]){
            this.seleccionados[7][1] = false;
            this.numSeleccionados--;
            this.j9d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[7][1] = true;
            this.numSeleccionados++;
            this.j9d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[7][1] = false;
                this.numSeleccionados--;
                this.j9d.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j9dActionPerformed

    private void j8dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j8dActionPerformed
        if(this.seleccionados[6][1]){
            this.seleccionados[6][1] = false;
            this.numSeleccionados--;
            this.j8d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[6][1] = true;
            this.numSeleccionados++;
            this.j8d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[6][1] = false;
                this.numSeleccionados--;
                this.j8d.setBackground(Color.GRAY);
            }
        }
    }//GEN-LAST:event_j8dActionPerformed

    private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jCancelActionPerformed

    private void j6dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[4][1]){
            this.seleccionados[4][1] = false;
            this.numSeleccionados--;
            this.j6d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[4][1] = true;
            this.numSeleccionados++;
            this.j6d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[4][1] = false;
                this.numSeleccionados--;
                this.j6d.setBackground(Color.GRAY);
            }
        }
    }

    private void j7dActionPerformed(java.awt.event.ActionEvent evt) {                                    
        if(this.seleccionados[5][1]){
            this.seleccionados[5][1] = false;
            this.numSeleccionados--;
            this.j7d.setBackground(Color.GRAY);
        }
        else {
            this.seleccionados[5][1] = true;
            this.numSeleccionados++;
            this.j7d.setBackground(Color.GREEN);
            if(this.tipo && this.numSeleccionados >= 6) {
                this.seleccionados[5][1] = false;
                this.numSeleccionados--;
                this.j7d.setBackground(Color.GRAY);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton j2c;
    private javax.swing.JButton j2d;
    private javax.swing.JButton j2h;
    private javax.swing.JButton j2s;
    private javax.swing.JButton j3c;
    private javax.swing.JButton j3d;
    private javax.swing.JButton j3h;
    private javax.swing.JButton j3s;
    private javax.swing.JButton j4c;
    private javax.swing.JButton j4d;
    private javax.swing.JButton j4h;
    private javax.swing.JButton j4s;
    private javax.swing.JButton j5c;
    private javax.swing.JButton j5d;
    private javax.swing.JButton j5h;
    private javax.swing.JButton j5s;
    private javax.swing.JButton j6c;
    private javax.swing.JButton j6d;
    private javax.swing.JButton j6h;
    private javax.swing.JButton j6s;
    private javax.swing.JButton j7c;
    private javax.swing.JButton j7d;
    private javax.swing.JButton j7h;
    private javax.swing.JButton j7s;
    private javax.swing.JButton j8c;
    private javax.swing.JButton j8d;
    private javax.swing.JButton j8h;
    private javax.swing.JButton j8s;
    private javax.swing.JButton j9c;
    private javax.swing.JButton j9d;
    private javax.swing.JButton j9h;
    private javax.swing.JButton j9s;
    private javax.swing.JButton jAc;
    private javax.swing.JButton jAd;
    private javax.swing.JButton jAh;
    private javax.swing.JButton jAs;
    private javax.swing.JButton jCancel;
    private javax.swing.JButton jClear;
    private javax.swing.JButton jJc;
    private javax.swing.JButton jJd;
    private javax.swing.JButton jJh;
    private javax.swing.JButton jJs;
    private javax.swing.JButton jKc;
    private javax.swing.JButton jKd;
    private javax.swing.JButton jKh;
    private javax.swing.JButton jKs;
    private javax.swing.JButton jOK;
    private javax.swing.JButton jQc;
    private javax.swing.JButton jQd;
    private javax.swing.JButton jQh;
    private javax.swing.JButton jQs;
    private javax.swing.JButton jTc;
    private javax.swing.JButton jTd;
    private javax.swing.JButton jTh;
    private javax.swing.JButton jTs;
    // End of variables declaration//GEN-END:variables
}
