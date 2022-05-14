package library;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class JIssueBook extends javax.swing.JFrame {

    public JIssueBook() {
        initComponents();
        dateDue.setEnabled(false);
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
        jLabel4 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        dateIssue = new com.toedter.calendar.JDateChooser();
        dateDue = new com.toedter.calendar.JDateChooser();
        btnIssue = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ISBN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 113, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("STUDENT ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ISSUE DATE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 113, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("DUE DATE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 113, -1));

        txtIsbn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 219, -1));

        txtId.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 219, -1));

        dateIssue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(dateIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 219, -1));

        dateDue.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(dateDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 219, -1));

        btnIssue.setBackground(java.awt.SystemColor.activeCaption);
        btnIssue.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/issue book.png"))); // NOI18N
        btnIssue.setText("ISSUE");
        btnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueActionPerformed(evt);
            }
        });
        getContentPane().add(btnIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        btnClose.setBackground(java.awt.SystemColor.activeCaption);
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmark.png"))); // NOI18N
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 490, 32));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/background.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueActionPerformed
        Connection connection;
        PreparedStatement statement;
        PreparedStatement statement1;
        Statement s;
        ResultSet resultSet;
        DbHelper helper=new DbHelper();
        
        try{
            connection=helper.getConnection();
            s=connection.createStatement();
            resultSet=s.executeQuery("select * from library.books where ISBN='"+Integer.valueOf(txtIsbn.getText())+"'");
            if(resultSet.next()){
                resultSet=s.executeQuery("select * from library.students where ID='"+Integer.valueOf(txtId.getText())+"'");
                if(resultSet.next()){
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
                    Date date=new Date();
                    
                    LocalDateTime localDateTime = dateIssue.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    localDateTime=localDateTime.plusDays(15);
                    Date plussedDate= Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                    
                    String issueDate=dateFormat.format(dateIssue.getDate());
                    String dueDate=dateFormat.format(plussedDate);
                    dateDue.setDate(plussedDate);
                    
                    String sql="insert into library.issue (ISBN,STUDENT_ID,ISSUE_DATE,DUE_DATE) values(?,?,?,?)";
                    String sql1="update library.books set ISSUED = ? where ISBN="+Integer.valueOf(txtIsbn.getText())+"";
                    statement=connection.prepareStatement(sql);
                    statement1=connection.prepareStatement(sql1);
                    statement.setInt(1, Integer.valueOf(txtIsbn.getText()));
                    statement.setInt(2, Integer.valueOf(txtId.getText()));
                    statement.setString(3, issueDate);
                    statement.setString(4, dueDate);
                    statement.execute();
                    lblMessage.setText("Book issued succesfully!");
                    statement1.setString(1, "Yes");
                    statement1.execute();
                    txtIsbn.setText("");
                    txtId.setText("");
                    lblMessage.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Wrong Student ID");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Wrong ISBN");
            }
        }catch(SQLException exception){
            helper.showError(exception);
            
        }
    }//GEN-LAST:event_btnIssueActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new JManagementSystem().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JIssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnIssue;
    private com.toedter.calendar.JDateChooser dateDue;
    private com.toedter.calendar.JDateChooser dateIssue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIsbn;
    // End of variables declaration//GEN-END:variables
}
