package library;
import com.sun.glass.events.KeyEvent;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jlogin extends javax.swing.JFrame {

    String username;

    public Jlogin() {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        passPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        cboxPassword = new javax.swing.JCheckBox();
        btnExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsername.setText("USERNAME");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 106, -1));

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPassword.setText("PASSWORD");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        txtUsername.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 218, -1));

        passPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        passPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(passPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 218, -1));

        btnLogin.setBackground(java.awt.SystemColor.activeCaption);
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/login.png"))); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 218, -1));

        cboxPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboxPassword.setText("SHOW PASSWORD");
        cboxPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(cboxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, -1, -1));

        btnExit.setBackground(java.awt.SystemColor.activeCaption);
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, 220, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/loginBackground.PNG"))); // NOI18N
        getContentPane().add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        DbHelper dbHelper = new DbHelper();
        try {

            connection = dbHelper.getConnection();
            username = txtUsername.getText();
            String password = new String(passPassword.getPassword());
            String sql = "select * from library.admin where USERNAME= ? and PASSWORD=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, txtUsername.getText());
            statement.setString(2, passPassword.getText());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "LOGED IN SUCCESFULLY");
                new JManagementSystem().setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD");
            }

        } catch (SQLException ex) {
            dbHelper.showError(ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cboxPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxPasswordActionPerformed
        if (cboxPassword.isSelected()) {
            passPassword.setEchoChar((char) 0);
        } else {
            passPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_cboxPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(this, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (dialogButton == JOptionPane.YES_OPTION) {
            Container frame = btnExit.getParent();
        do {
            frame = frame.getParent();
        } while (!(frame instanceof JFrame));
        ((JFrame) frame).dispose();
        } else if (dialogButton == JOptionPane.NO_OPTION) {
            setVisible(true);
        }
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void passPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passPasswordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        DbHelper dbHelper = new DbHelper();
        try {

            connection = dbHelper.getConnection();
            username = txtUsername.getText();
            String password = new String(passPassword.getPassword());
            String sql = "SELECT * FROM library.admin where USERNAME= ? and PASSWORD=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, txtUsername.getText());
            statement.setString(2, passPassword.getText());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "LOGED IN SUCCESFULL");
                new JManagementSystem().setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD");
            }

        } catch (SQLException ex) {
            dbHelper.showError(ex);
        }
        }
    }//GEN-LAST:event_passPasswordKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cboxPassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField passPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
