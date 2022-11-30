
package JframeLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import ConexionBD.Conexion;
import JframeAdmin.MainFrameAdmin;
import JframeEmploye.MainFrameEmploye;


public class JframeInicio extends javax.swing.JFrame {

    
    public JframeInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(12, 66, 113));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LOGO (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));
        jPanel1.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 130, -1));

        contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 130, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(12, 66, 113));
        jButton1.setText("Ingresar");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 80, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 47;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nombreuser= nombreUsuario.getText();
       String contra=new String (contraseña.getPassword());
       System.out.println(contraseña+" contra");
       String url="select usuario, contraseña, tipo_usuario from INGRESAR where activo=1 and usuario='"+nombreuser+"'";
       
       if(nombreuser.isEmpty()||contra.isEmpty()){
            JOptionPane.showMessageDialog(null,"no pueden estar vacios");
        }else{
            try{
            Conexion con=new Conexion();
            Connection conectar=con.establecerConexion();
            PreparedStatement ps= conectar.prepareStatement(url);
            ResultSet res=ps.executeQuery();
        
        if(res.next()){
            String u=res.getString("usuario");
            String p=res.getString("contraseña");
            String priv=res.getString("tipo_usuario");
            
            if(contra.equals(p)){
                if(priv.equals("admin")){
                    MainFrameAdmin ad =new MainFrameAdmin();
                    ad.setVisible(true);
                    dispose();
                }else if(priv.equals("empleado")){
                    MainFrameEmploye ep1= new MainFrameEmploye();
                    ep1.setVisible(true);
                    dispose(); 
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
            }
        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
        }
            }catch(Exception e){
                System.out.println("error " + e.toString());
            }
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaActionPerformed
       
    }//GEN-LAST:event_contraseñaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreUsuario;
    // End of variables declaration//GEN-END:variables
}
