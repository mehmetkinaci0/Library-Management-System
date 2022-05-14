package library;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class JNewStudent extends javax.swing.JFrame {

    public JNewStudent() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation (size.width / 2 -getWidth() / 2, size.height / 2- getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblDepartment = new javax.swing.JLabel();
        txtDepartment = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblId.setText("ID");
        getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 125, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblName.setText("NAME");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 125, -1));

        lblSurname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSurname.setText("SURNAME");
        getContentPane().add(lblSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 125, -1));

        lblDepartment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblDepartment.setText("DEPARTMENT");
        getContentPane().add(lblDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        txtDepartment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 300, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 300, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 300, -1));

        txtSurname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 300, -1));

        btnAdd.setBackground(java.awt.SystemColor.activeCaption);
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/saveIcon.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 130, -1));

        btnClose.setBackground(java.awt.SystemColor.activeCaption);
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmark.png"))); // NOI18N
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 535, 29));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new JManagementSystem().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        DbHelper helper= new DbHelper();
        
        try{
            connection=helper.getConnection();
            String sql="insert into library.students(ID,NAME,SURNAME,DEPARTMENT) values(?,?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(txtId.getText()));
            statement.setString(2, txtName.getText());
            statement.setString(3, txtSurname.getText());
            statement.setString(4, txtDepartment.getText());
            statement.execute();
            lblMessage.setText("Student "+txtName.getText()+" "+txtSurname.getText()+" added succesfully!");
            txtDepartment.setText("");
            txtId.setText("");
            txtName.setText("");
            txtSurname.setText("");
        }catch(SQLException exception){
            helper.showError(exception);
            lblMessage.setText("This ID already added!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(JNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JNewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JNewStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
