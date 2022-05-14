package library;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;

public class JNewBook extends javax.swing.JFrame {

    public JNewBook() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIsbn = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblWriter = new javax.swing.JLabel();
        lblPage = new javax.swing.JLabel();
        lblPublisher = new javax.swing.JLabel();
        lblPublisherYear = new javax.swing.JLabel();
        txtPublisherYear = new javax.swing.JTextField();
        txtPage = new javax.swing.JTextField();
        txtWriter = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIsbn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIsbn.setText("ISBN");
        getContentPane().add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 158, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblName.setText("NAME");
        getContentPane().add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 158, -1));

        lblWriter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWriter.setText("WRITER");
        getContentPane().add(lblWriter, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 158, -1));

        lblPage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPage.setText("PAGE");
        getContentPane().add(lblPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 158, -1));

        lblPublisher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPublisher.setText("PUBLISHER");
        getContentPane().add(lblPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 158, -1));

        lblPublisherYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPublisherYear.setText("PUBLISHER YEAR");
        getContentPane().add(lblPublisherYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 20));

        txtPublisherYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtPublisherYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 235, -1));

        txtPage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 235, -1));

        txtWriter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtWriter, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 235, -1));

        txtPublisher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 235, -1));

        txtIsbn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 235, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 235, -1));

        btnAdd.setBackground(java.awt.SystemColor.activeCaption);
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/saveIcon.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 142, -1));

        jButton1.setBackground(java.awt.SystemColor.activeCaption);
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmark.png"))); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 390, 510, 29));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        DbHelper helper = new DbHelper();

        try {

            connection = helper.getConnection();
            String sql = "insert into library.books(ISBN,NAME,WRITER,PAGE,PUBLISHER,PUBLISHER_YEAR) values(?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(txtIsbn.getText()));
            statement.setString(2, txtName.getText());
            statement.setString(3, txtWriter.getText());
            statement.setInt(4, Integer.valueOf(txtPage.getText()));
            statement.setString(5, txtPublisher.getText());
            statement.setInt(6, Integer.valueOf(txtPublisherYear.getText()));
            statement.execute();
            lblMessage.setText("Book " + txtName.getText() + " with ISBN " + txtIsbn.getText() + " added succesfully!");
            txtIsbn.setText("");
            txtName.setText("");
            txtWriter.setText("");
            txtPage.setText("");
            txtPublisher.setText("");
            txtPublisherYear.setText("");

        } catch (SQLException exception) {
            helper.showError(exception);
            lblMessage.setText("This ISBN already added!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new JManagementSystem().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JNewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JNewBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblPublisherYear;
    private javax.swing.JLabel lblWriter;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPage;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtPublisherYear;
    private javax.swing.JTextField txtWriter;
    // End of variables declaration//GEN-END:variables
}
