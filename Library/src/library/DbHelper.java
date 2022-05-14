package library;
import java.sql.*;

public class DbHelper {
    private String userName="root";
    private String password="mehmetknc2720";
    private String dbUrl="jdbc:mysql://localhost:3306/library";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    
    public void showError(SQLException exception){
        System.out.println("Error message: "+exception.getMessage());
        System.out.println("Error code: "+exception.getErrorCode());
    }
}