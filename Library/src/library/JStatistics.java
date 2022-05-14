package library;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JStatistics extends javax.swing.JFrame {
    
    DefaultTableModel model;
    public JStatistics() {
        initComponents();
        addTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }
    
    public void addTable() {
        model = (DefaultTableModel) tblIssued.getModel();
        model.setRowCount(0);
        try {
            ArrayList<IssuedBook> books = getBooks();
            for (IssuedBook book : books) {
                Object[] row = {book.getIsbn(), book.getId(), book.getIssueDate(), book.getDueDate()};
                model.addRow(row);
            }
        } catch (SQLException ex) {

        }
    }

    public ArrayList<IssuedBook> getBooks() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<IssuedBook> books = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from library.issue");
            books = new ArrayList<IssuedBook>();
            while (resultSet.next()) {
                books.add((new IssuedBook(resultSet.getInt("ISBN"), resultSet.getInt("STUDENT_ID"), resultSet.getString("ISSUE_DATE"), resultSet.getString("DUE_DATE"))));
            }
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return books;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssued = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblIssued = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblIssued.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "STUDENT ID", "ISSUE DATE", "DUE DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblIssued);
        if (tblIssued.getColumnModel().getColumnCount() > 0) {
            tblIssued.getColumnModel().getColumn(0).setResizable(false);
            tblIssued.getColumnModel().getColumn(1).setResizable(false);
            tblIssued.getColumnModel().getColumn(2).setResizable(false);
            tblIssued.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 980, 470));

        btnClose.setBackground(java.awt.SystemColor.activeCaption);
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/xmark.png"))); // NOI18N
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, 200, -1));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 736, -1));

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 0, 51));
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/search.png"))); // NOI18N
        lblSearch.setText("SEARCH");
        getContentPane().add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, -1));

        lblIssued.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblIssued.setForeground(new java.awt.Color(255, 0, 0));
        lblIssued.setText("                       ISSUED BOOKS");
        getContentPane().add(lblIssued, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 0, 595, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/managementBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new JManagementSystem().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String search = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblIssued.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(JStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JStatistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JStatistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIssued;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblIssued;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
