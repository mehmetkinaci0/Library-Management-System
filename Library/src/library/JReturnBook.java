package library;
import java.util.Date;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JReturnBook extends javax.swing.JFrame {

    public JReturnBook() {
        initComponents();
        txtId.setEnabled(false);
        txtDueDate.setEnabled(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation (size.width / 2 -getWidth() / 2, size.height / 2- getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtDueDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ISBN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 127, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("STUDENT ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 127, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("DUE DATE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 127, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 211, -1));

        txtIsbn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 211, -1));

        btnReturn.setBackground(java.awt.SystemColor.activeCaption);
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/return book png.png"))); // NOI18N
        btnReturn.setText("RETURN");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        btnClose.setBackground(java.awt.SystemColor.activeCaption);
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmark.png"))); // NOI18N
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        btnSearch.setBackground(java.awt.SystemColor.activeCaption);
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 490, 70));

        txtDueDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 211, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/background.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        DbHelper helper=new DbHelper();
        try{
            connection=helper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from library.issue where ISBN="+Integer.valueOf(txtIsbn.getText())+"");
            if(resultSet.next()){
                txtId.setText(resultSet.getString(2));
                txtDueDate.setText(resultSet.getString(4));
            }else{
                JOptionPane.showMessageDialog(null, "Wrong ISBN");
            }
        }catch(SQLException exception){
            helper.showError(exception);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        Connection connection;
        PreparedStatement statement;
        PreparedStatement statement1;
        ResultSet resultSet;
        DbHelper helper=new DbHelper();
        try{
            connection=helper.getConnection();
            String sql="delete  from library.issue where ISBN=?";
            String sql1="update library.books set ISSUED =? where ISBN="+Integer.valueOf(txtIsbn.getText())+"";
            statement=connection.prepareStatement(sql);
            statement1=connection.prepareStatement(sql1);
            statement.setInt(1, Integer.valueOf(txtIsbn.getText()));
            statement.executeUpdate();
            calculatePayment();
            statement1.setString(1, null);
            statement1.executeUpdate();
        }catch(SQLException exception){
            helper.showError(exception);
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new JManagementSystem().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed
    void calculatePayment(){
        double paymentMoney=1.25;
        try {
            Date today=new Date();
            Date returnDate=new Date();
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dueDate=txtDueDate.getText();
            dueDate=dueDate.replace('-','/');
            returnDate=format.parse(dueDate);
            if(today.getTime()> returnDate.getTime()){
                long fark=today.getTime()-returnDate.getTime();
                lblMessage.setText("Payment: "+ TimeUnit.DAYS.convert(fark, TimeUnit.MILLISECONDS)*paymentMoney+"₺\n Book returned succesfully!");
            }else{
                lblMessage.setText("Book returned succesfully!");
            }
        } catch (ParseException ex) {
        }
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtDueDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIsbn;
    // End of variables declaration//GEN-END:variables
}
