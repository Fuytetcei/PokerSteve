/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3poker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;


public class InterfazRangos extends javax.swing.JFrame {

    private JButton[][] _botones;
    private boolean[][] _activos;
    private final RangeParser _rangeParser;
    private RankingParser _rankingParser;
    private boolean _cambiando = false;
    public String rango;
    private int player;
    private Principal anterior;

    public InterfazRangos(Principal anterior, int player) throws IOException {
        initComponents();
        this.anterior = anterior;
        this.player = player;
        GridBagLayout layout = (GridBagLayout) jPanel3.getLayout();
        jPanel3.setPreferredSize(new Dimension(300, 300));
        GridBagConstraints c = new GridBagConstraints();

        _activos = new boolean[13][13];
        _botones = new JButton[13][13];

        for (int y = 0; y < 13; y++) {
            for (int x = 0; x < 13; x++) {

                String str;
                if (x == y) {
                    str = "" + Poker.numberLetter[y] + Poker.numberLetter[x];
                } else if (x < y) {
                    // suited
                    str = "" + Poker.numberLetter[y] + Poker.numberLetter[x] + "s";
                } else {
                    // offsuit
                    str = "" + Poker.numberLetter[x] + Poker.numberLetter[y] + "o";
                }

                final int x1 = x;
                final int y1 = y;

                JButton boton = new JButton(str);
                boton.setBorder(new EtchedBorder());
                boton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        _cambiando = true;
                        _activos[x1][y1] = !_activos[x1][y1];
                        actualizaColor(x1, y1);
                        _rangeParser.setTable(_activos);
                        jTextField1.setText(_rangeParser.toString());
                        //mano.setText(_rangeParser.toString());
                        jLabel1.setText("" + (int) _rangeParser.getPercentage() + "%");
                        jSlider1.setValue((int) _rangeParser.getPercentage());
                        _cambiando = false;
                    }

                });

                c.weightx = 1;
                c.weighty = 1;
                c.gridx = 12 - x;
                c.gridy = 12 - y;
                c.fill = GridBagConstraints.BOTH;

                layout.setConstraints(boton, c);
                jPanel3.add(boton);

                _botones[x][y] = boton;
                _activos[x][y] = false;
            }
        }
        pack();

        //_rankingParser = new FileRankingParser("chubukov.txt");
        //leemos de archivo cosa mala
        /////////////////////////////////////////////////////////////////
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File ("rangos.txt");
           if(archivo.exists()){
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while((linea=br.readLine())!=null)
            {
               String linea2 = br.readLine();
               
               rangoUsado.addItem(new FileRankingParser(linea, linea2));
            }
            }
           else
           {
               //si no existe ño creamos con chubukov
                FileWriter fw = new FileWriter(archivo);
                PrintWriter pw = new PrintWriter (fw);
                pw.println("chubukov.txt");
                pw.println("Chubukov");
                rangoUsado.addItem(new FileRankingParser("chubukov.txt", "Chubukov"));
                fw.close();
           }   
           
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
      //////////////////////////////////////////////////////////////////////////////////////////////////////

        
        rangoUsado.addItem(new ChenRankingParser());
        
        _rankingParser = (RankingParser) rangoUsado.getSelectedItem();
        _rangeParser = new RangeParser(_rankingParser);
        actualizaColores();
    }

    private void actualizaColores() {
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 13; y++) {
                actualizaColor(x, y);
            }
        }
    }

    private void actualizaColor(int x, int y) {
        Color color = null;
        boolean activo = _activos[x][y];

        if (x == y) {
            // par
            color = activo ? new Color(255, 255, 127) : new Color(127, 255, 127);
        } else if (x < y) {
            // suited
            color = activo ? new Color(255, 255, 127) : new Color(255, 127, 127);
        } else {
            // ofsuit
            color = activo ? new Color(255, 255, 127) : new Color(127, 255, 255);
        }

        _botones[x][y].setBackground(color);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        cambiar = new javax.swing.JButton();
        rangoUsado = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jAceptar = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        jTabbedPane1.setToolTipText("");

        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jSlider1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        jLabel1.setText("0%");

        jTextField1.setName("jTextoRango"); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setName("panel"); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        cambiar.setText("Cambiar");
        cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarActionPerformed(evt);
            }
        });

        rangoUsado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoUsadoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Ranking usado");

        jAceptar.setText("Aceptar");
        jAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAceptarMouseClicked(evt);
            }
        });
        jAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rangoUsado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cambiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jAceptar))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rangoUsado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cambiar)
                    .addComponent(jAceptar))
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Rangos (partes 1 y 2)", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rangoUsadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoUsadoActionPerformed
        _rankingParser = (RankingParser) rangoUsado.getSelectedItem();
        
    }//GEN-LAST:event_rangoUsadoActionPerformed

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
        _cambiando = true;
        _rangeParser.setRange(jTextField1.getText());
        _activos = _rangeParser.getTable();
        jTextField1.setText(_rangeParser.toString());
        //mano.setText(_rangeParser.toString());
        jLabel1.setText("" + (int) Math.round(_rangeParser.getPercentage()) + "%");
        jSlider1.setValue((int) Math.round(_rangeParser.getPercentage()));
        _cambiando = false;
        actualizaColores();
    }//GEN-LAST:event_cambiarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jSlider1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jSlider1CaretPositionChanged

    }//GEN-LAST:event_jSlider1CaretPositionChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        if (!_cambiando) {
            changeToPercentage(jSlider1.getValue());
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAceptarMouseClicked

    }//GEN-LAST:event_jAceptarMouseClicked

    private void jAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAceptarActionPerformed
        // TODO add your handling code here:
        this.rango = this.jTextField1.getText();
        this.setVisible(false);
        this.anterior.actualizaplayer(player);
    }//GEN-LAST:event_jAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiar;
    private javax.swing.JButton jAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JComboBox rangoUsado;
    // End of variables declaration//GEN-END:variables

    private void changeToPercentage(int value) {
        _rangeParser.setRange(_rankingParser.getPercentage(value));
        _activos = _rangeParser.getTable();
        jLabel1.setText(value + "%");
        jTextField1.setText(_rangeParser.toString());
        //mano.setText(_rangeParser.toString());
        actualizaColores();
    }
}
