
package com.raven.main;

import com.raven.event.EventMenuSelected;
import com.raven.form.*;
import java.awt.Color;
import javax.swing.JComponent;

public class inicio extends javax.swing.JFrame {

    //variables estáticas
    private formInicio inicio1;
    private formCliente cliente;
    private formHabitacions habitacion;
    private formCajas caja;
    private formServicios servicios;
    private formGastos gastos;
    
    public inicio() {
        initComponents();
        //setBackground(new Color(0,0,0,0));
        inicio1 = new formInicio();
        cliente = new formCliente();
        habitacion = new formHabitacions();
        caja = new formCajas();
        servicios = new formServicios();
        gastos = new formGastos();
        
        menu.initMoving(inicio.this);
        menu.addEventMenuSelected(new EventMenuSelected(){
            @Override
            public void selected ( int index){
                System.out.println("selected index : "+index);
               //cambio paneles con su indice - empezaria de 2, por 0 y 1 lo toma el espacio y usuario empleado
               if(index==2){
                   setForm(inicio1);
               }else if(index==3){
                   setForm(cliente);
               }else if(index==4){
                   setForm(habitacion);
               }else if(index==5){
                   setForm(servicios);
               }else if(index==6){
                   setForm(caja);
               }else if(index==7){
                   setForm(gastos);
               }
        }
        });
        //inicia cuando se abre el sistema
        setForm(new formInicio());
    }
    
    

    private void setForm(JComponent com){
        jPanel2.removeAll();
        jPanel2.add(com);
        jPanel2.repaint();
        jPanel2.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder3 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Hotel Estrellitas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Josefin Sans", 0, 12)); // NOI18N

        panelBorder3.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder3.setPreferredSize(new java.awt.Dimension(1000, 576));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jLabel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder3;
    // End of variables declaration//GEN-END:variables
}
