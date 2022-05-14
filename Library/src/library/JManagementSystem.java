package library;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class JManagementSystem extends javax.swing.JFrame {

    DefaultTableModel studentModel;
    DefaultTableModel bookModel;

    public JManagementSystem() {
        initComponents();
        addStudentToTable();
        addBookToTable();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/managementBackground.jpg")));
    }

    public void addStudentToTable() {
        studentModel = (DefaultTableModel) tblStudents.getModel();
        studentModel.setRowCount(0);
        try {
            ArrayList<Student> students = getStudents();
            for (Student student : students) {
                Object[] row = {student.getId(), student.getName(), student.getSurname(), student.getDepartment()};
                studentModel.addRow(row);
            }
        } catch (SQLException ex) {

        }
    }

    public void addBookToTable() {
        bookModel = (DefaultTableModel) tblBooks.getModel();
        bookModel.setRowCount(0);
        try {
            ArrayList<Book> books = getBooks();
            for (Book book : books) {
                Object[] row = {book.getIsbn(), book.getName(), book.getWriter(), book.getPage(), book.getPublisher(), book.getPublisherYear(), book.getIssued()};
                bookModel.addRow(row);
            }
        } catch (SQLException ex) {

        }
    }

    public ArrayList<Book> getBooks() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Book> books = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from library.books");
            books = new ArrayList<Book>();
            while (resultSet.next()) {
                books.add((new Book(resultSet.getInt("ISBN"), resultSet.getString("NAME"), resultSet.getString("WRITER"), resultSet.getInt("PAGE"), resultSet.getString("PUBLISHER"), resultSet.getInt("PUBLISHER_YEAR"), resultSet.getString("ISSUED"))));
            }
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return books;
    }

    public ArrayList<Student> getStudents() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Student> students = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from library.students");
            students = new ArrayList<Student>();
            while (resultSet.next()) {
                students.add((new Student(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getString("SURNAME"), resultSet.getString("DEPARTMENT"))));
            }
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return students;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnStudent = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnIssue = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        txtSearchBook = new javax.swing.JTextField();
        lblSearchBook = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        txtSearchStudent = new javax.swing.JTextField();
        lblSearchStudent = new javax.swing.JLabel();
        btnDeleteStudent = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnStudent.setBackground(java.awt.SystemColor.activeCaption);
        btnStudent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/student.png"))); // NOI18N
        btnStudent.setText("NEW STUDENT");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        jPanel2.add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        btnBook.setBackground(java.awt.SystemColor.activeCaption);
        btnBook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/book.png"))); // NOI18N
        btnBook.setText("NEW BOOK");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });
        jPanel2.add(btnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        btnStatistics.setBackground(java.awt.SystemColor.activeCaption);
        btnStatistics.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Statics.png"))); // NOI18N
        btnStatistics.setText("STATİSTİCS");
        btnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });
        jPanel2.add(btnStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        btnIssue.setBackground(java.awt.SystemColor.activeCaption);
        btnIssue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIssue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/issue.png"))); // NOI18N
        btnIssue.setText("ISSUE BOOK");
        btnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueActionPerformed(evt);
            }
        });
        jPanel2.add(btnIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        btnReturn.setBackground(java.awt.SystemColor.activeCaption);
        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/returnBookButton.png"))); // NOI18N
        btnReturn.setText("RETURN BOOK");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        jPanel2.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        btnLogout.setBackground(java.awt.SystemColor.activeCaption);
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/exit.png"))); // NOI18N
        btnLogout.setText("LOG OUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, -1, -1));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 267, -1, -1));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1008, 1008));

        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "NAME", "WRITER", "PAGE", "PUBLISHER", "PUBLISHER YEAR", "ISSUED"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBooks);

        txtSearchBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSearchBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBookKeyReleased(evt);
            }
        });

        lblSearchBook.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSearchBook.setText("SEARCH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BOOKS", jPanel1);

        jPanel3.setMinimumSize(new java.awt.Dimension(100, 80));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "SURNAME", "DEPARTMENT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblStudents.setEditingColumn(0);
        tblStudents.setEditingRow(0);
        jScrollPane2.setViewportView(tblStudents);

        txtSearchStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSearchStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentKeyReleased(evt);
            }
        });

        lblSearchStudent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSearchStudent.setText("SEARCH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchStudent))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1380, 1380, 1380))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearchStudent))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("STUDENTS", jPanel3);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 790, 480));

        btnDeleteStudent.setBackground(java.awt.SystemColor.activeCaption);
        btnDeleteStudent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteStudent.setText("DELETE STUDENT");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 410, -1, -1));

        btnDeleteBook.setBackground(java.awt.SystemColor.activeCaption);
        btnDeleteBook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteBook.setText("DELETE BOOK");
        btnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));
        jPanel2.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1382, 799);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        new JNewStudent().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        new JNewBook().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueActionPerformed
        new JIssueBook().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnIssueActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        new JReturnBook().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void txtSearchBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBookKeyReleased
        String search = txtSearchBook.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(bookModel);
        tblBooks.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchBookKeyReleased

    private void txtSearchStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentKeyReleased
        String search = txtSearchStudent.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(studentModel);
        tblStudents.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txtSearchStudentKeyReleased

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(this, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (dialogButton == JOptionPane.YES_OPTION) {

            Container frame = btnLogout.getParent();
            do {
                frame = frame.getParent();
            } while (!(frame instanceof JFrame));
            ((JFrame) frame).dispose();

        } else if (dialogButton == JOptionPane.NO_OPTION) {
            setVisible(true);

        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        new JStatistics().setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnStatisticsActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        Connection connection;
        PreparedStatement statement;
        DbHelper helper = new DbHelper();
        if (tblStudents.getSelectedRow() != -1) {
            String value = String.valueOf(tblStudents.getValueAt(tblStudents.getSelectedRow(), tblStudents.getSelectedColumn()));
            int value2 = Integer.valueOf(value);
            studentModel.removeRow(tblStudents.getSelectedRow());
            try {
                connection = helper.getConnection();
                String sql = "delete from library.students where ID = ? ";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, value2);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } catch (SQLException exception) {
                helper.showError(exception);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Choose a student!");
        }
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookActionPerformed
        Connection connection;
        PreparedStatement statement;
        DbHelper helper = new DbHelper();
        if (tblBooks.getSelectedRow() != -1) {
            String value = String.valueOf(tblBooks.getValueAt(tblBooks.getSelectedRow(), tblBooks.getSelectedColumn()));
            int value2 = Integer.valueOf(value);
            bookModel.removeRow(tblBooks.getSelectedRow());
            try {
                connection = helper.getConnection();
                String sql = "delete from library.books where ISBN = ? ";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, value2);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deleted successfully");
            } catch (SQLException exception) {
                helper.showError(exception);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Choose a book!");
        }
    }//GEN-LAST:event_btnDeleteBookActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JManagementSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnIssue;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton btnStudent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblSearchBook;
    private javax.swing.JLabel lblSearchStudent;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtSearchBook;
    private javax.swing.JTextField txtSearchStudent;
    // End of variables declaration//GEN-END:variables
}
