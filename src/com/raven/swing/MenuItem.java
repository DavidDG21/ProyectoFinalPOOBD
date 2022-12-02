
package com.raven.swing;

import com.raven.event.EventMenuSelected;
import com.raven.model.Model_Menu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuItem extends javax.swing.JPanel {

  
    private boolean selected;

    public MenuItem(Model_Menu data) {
        initComponents();
        setOpaque(false);
        if(data.getType()== Model_Menu.MenuType.MENU){
            ibIcon.setIcon(data.toIcon());
            ibName.setText(data.getName());
            ibName.setFont(new Font("Josefin Sans", 1, 12));
           
        }else if(data.getType()==Model_Menu.MenuType.TITLE){
            ibIcon.setText(data.getName());
            ibIcon.setFont(new Font("Josefin Sans", 1, 12));
            ibName.setVisible(false);
            
        }else{
            ibName.setText(" ");
        }
    }
    
     public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ibIcon = new javax.swing.JLabel();
        ibName = new javax.swing.JLabel();

        ibIcon.setForeground(new java.awt.Color(255, 255, 255));

        ibName.setForeground(new java.awt.Color(255, 255, 255));
        ibName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(ibIcon)
                .addGap(18, 18, 18)
                .addComponent(ibName)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ibIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ibName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        if(selected){
            Graphics2D g2=(Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING ,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(61,110,153,100) );
            g2.fillRoundRect(10,0, getWidth()-20,getHeight(), 15,5); //redondear borde
        }
        super.paintComponent(grphcs); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ibIcon;
    private javax.swing.JLabel ibName;
    // End of variables declaration//GEN-END:variables
}
