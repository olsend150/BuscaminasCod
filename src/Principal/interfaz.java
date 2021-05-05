package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JButton;

public class interfaz extends javax.swing.JFrame {

    int mili = 0;
    int seg = 0;
    int min = 0;
    int hora = 0;
    boolean estado = true;
    int filas = 16;
    int columnas = 16;
    int minas = 30;
    JButton[][] botones;
    Minas Minas;
    public static LinkedList contenedor=new LinkedList();
    public int buscar;
    public interfaz() {
        initComponents();
        controles();
        tablero();
    }

    void borrarmemoria() {
        if (botones != null) {
            for (int i = 0; i < botones.length; i++) {
                for (int j = 0; j < botones[i].length; j++) {
                    if (botones[i][j] != null) {
                        getContentPane().remove(botones[i][j]);
                    }
                }
            }
        }
    }

    private void JuegoNuevo() {
        borrarmemoria();
        controles();
        tablero();
        repaint();
    }

    private void tablero() {
        Minas = new Minas(filas, columnas, minas);
        Minas.setPerdido(new Consumer<List<Buscaminas>>() {
            @Override
            public void accept(List<Buscaminas> t) {
                for (Buscaminas posiciondeminas : t) {
                    botones[posiciondeminas.getFila()][posiciondeminas.getColumna()].setText("*");
                }
            }
        });

        Minas.setGanada(new Consumer<List<Buscaminas>>() {
            @Override
            public void accept(List<Buscaminas> t) {
                for (Buscaminas posiciondeminas : t) {
                    botones[posiciondeminas.getFila()][posiciondeminas.getColumna()].setText(":D");
                }
            }
        });
        Minas.setCasillaseabre(new Consumer<Buscaminas>() {
            @Override
            public void accept(Buscaminas t) {
                botones[t.getFila()][t.getColumna()].setEnabled(false);
                botones[t.getFila()][t.getColumna()].setText(t.getMinascerca() + "");
            }
        });

    }

    private void controles() {
        int x = 20;
        int y = 20;
        int ancho = 25;
        int alto = 25;
        botones = new JButton[filas][columnas];
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                botones[i][j].setName(i + "," + j);
                botones[i][j].setBorder(null);
                botones[i][j].setBackground(Color.gray);

                if (i == 0 && j == 0) {
                    botones[i][j].setBounds(x, y, ancho, alto);

                } else if (i == 0 && j != 0) {
                    botones[i][j].setBounds(botones[i][j - 1].getX() + botones[i][j - 1].getWidth(), y, ancho, alto);
                } else {
                    botones[i][j].setBounds(botones[i - 1][j].getX(), botones[i - 1][j].getY() + botones[i - 1][j].getHeight(), ancho, alto);
                }
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnClick(e);
                    }
                });
                getContentPane().add(botones[i][j]);
            }
        }
    }

    private void btnClick(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String[] punto = btn.getName().split(",");
        int fila = Integer.parseInt(punto[0]);
        int columna = Integer.parseInt(punto[1]);
        Minas.Seleccioncasillas(fila, columna);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        parar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNombre = new javax.swing.JLabel();
        btnTiempo = new javax.swing.JLabel();
        NuevoJuego = new javax.swing.JButton();
        txnombre = new javax.swing.JTextField();
        txtiempo = new javax.swing.JTextField();
        btguardar = new javax.swing.JButton();
        btmostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("BUSCAMINAS");

        lb1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lb1.setText("00 : 00 : 00");

        lb2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lb2.setText("0000");

        inicio.setBackground(new java.awt.Color(0, 255, 0));
        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        parar.setBackground(new java.awt.Color(0, 255, 0));
        parar.setText("Parar");
        parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pararActionPerformed(evt);
            }
        });

        borrar.setBackground(new java.awt.Color(51, 255, 0));
        borrar.setText("Reiniciar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel1.setText("Registrar nuevo participante");

        btnNombre.setText("Nombre:");

        btnTiempo.setText("Tiempo");

        NuevoJuego.setBackground(new java.awt.Color(255, 0, 0));
        NuevoJuego.setText("Jugar Denuevo");
        NuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoJuegoActionPerformed(evt);
            }
        });

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        btguardar.setText("Guardar");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });

        btmostrar.setText("Mostrar Registro");
        btmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inicio)
                                        .addGap(18, 18, 18)
                                        .addComponent(parar)
                                        .addGap(5, 5, 5))
                                    .addComponent(lb1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb2)
                                    .addComponent(borrar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27)))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNombre)
                                    .addComponent(btnTiempo))
                                .addGap(30, 30, 30))
                            .addComponent(btmostrar)
                            .addComponent(NuevoJuego))
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btguardar)
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb1)
                    .addComponent(lb2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicio)
                    .addComponent(parar)
                    .addComponent(borrar))
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNombre)
                .addGap(11, 11, 11)
                .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTiempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btmostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(NuevoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuegoActionPerformed
        JuegoNuevo();
    }//GEN-LAST:event_NuevoJuegoActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
        estado = true;
        mili = 0;
        seg = 0;
        min = 0;
        hora = 0;
        lb1.setText("00" + " : " + "00" + " : " + "00" + " : ");
        lb2.setText("0000");
    }//GEN-LAST:event_borrarActionPerformed

    private void pararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pararActionPerformed
        // TODO add your handling code here:
        estado = false;
    }//GEN-LAST:event_pararActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        // TODO add your handling code here:
        estado = true;
        Thread hilo = new Thread() {
            public void run() {
                for (;;) {
                    if (estado == true) {
                        try {
                            sleep(1);
                            if (mili >= 1000) {
                                mili = 0;
                                seg++;
                            }
                            if (seg >= 60) {
                                mili = 0;
                                seg = 0;
                                min++;
                            }
                            if (min >= 60) {
                                mili = 0;
                                seg = 0;
                                min = 0;
                                hora++;
                            }
                            lb1.setText(hora + " : " + min + " : " + seg + " : ");
                            lb2.setText("" + mili);
                            mili++;
                        } catch (Exception e) {

                        }
                    } else {
                        break;
                    }
                }
            }
        };
        hilo.start();
    }//GEN-LAST:event_inicioActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreActionPerformed

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        // TODO add your handling code here:
        String nombre=txnombre.getText();
        String tiempo=txtiempo.getText();
        datos clasedatos=new datos (nombre,tiempo);
        contenedor.add(clasedatos);
        txnombre.setText("");
        txtiempo.setText("");
    }//GEN-LAST:event_btguardarActionPerformed

    private void btmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmostrarActionPerformed
        // TODO add your handling code here:
        frmregistro mostrar=new frmregistro();
        mostrar.setVisible(true);
        
    }//GEN-LAST:event_btmostrarActionPerformed

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
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NuevoJuego;
    private javax.swing.JButton borrar;
    private javax.swing.JButton btguardar;
    private javax.swing.JButton btmostrar;
    private javax.swing.JLabel btnNombre;
    private javax.swing.JLabel btnTiempo;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JButton parar;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txtiempo;
    // End of variables declaration//GEN-END:variables
}
