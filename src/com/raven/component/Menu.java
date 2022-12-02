
package com.raven.component;

import com.raven.event.EventMenuSelected;
import com.raven.model.Model_Menu;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Menu extends javax.swing.JPanel {
    private EventMenuSelected event; 
    
    public void addEventMenuSelected(EventMenuSelected event ){
        this.event=event;
        listMenu1.addEventMenuSelected(event);
        listMenu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }
    
    public Menu() {
        initComponents();
        setOpaque(false); //ocultar el cuadro panel
        listMenu1.setOpaque(false);
        init();
    }
    private void init (){
        listMenu1.addItem(new Model_Menu("", "Usuario: "+"Empleado", Model_Menu.MenuType.TITLE));
        listMenu1.addItem(new Model_Menu("", " ", Model_Menu.MenuType.EMPTY));
        listMenu1.addItem(new Model_Menu("inicio", "Inicio", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("clientes", "Clientes", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("camita", "Habitación", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("servicios", "Servicios", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("manito", "Caja", Model_Menu.MenuType.MENU));
        listMenu1.addItem(new Model_Menu("bolitas", "Gastos", Model_Menu.MenuType.MENU));
        //listMenu1.addItem(new Model_Menu("2", "Usuarios", Model_Menu.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new com.raven.swing.ListMenu<>();

        setPreferredSize(new java.awt.Dimension(250, 596));

        panelMoving.setOpaque(false);
        panelMoving.setPreferredSize(new java.awt.Dimension(250, 576));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/logorec.png"))); // NOI18N

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 129, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs ){
        Graphics2D g2=(Graphics2D) grphcs;
            
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING ,RenderingHints.VALUE_ANTIALIAS_ON);
        Color g = new Color(12,66,113); //color entero al fondo menu
        g2.setPaint(g);
        g2.fillRoundRect(0,0, getWidth(),getHeight(), 15,15); //redondear borde
        g2.fillRect(getWidth() -20,0 ,getWidth(),getHeight());
        super.paintChildren(grphcs);
    }
   
    
    
    
    private int x, y;
    public void initMoving(JFrame fram){
        
        panelMoving.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mousePressed(MouseEvent me){
                x=me.getX();
                y=me.getY();
            }
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter(){
        @Override
        public void mouseDragged(MouseEvent me){
               fram.setLocation(me.getXOnScreen()-x, me.getYOnScreen()-y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
