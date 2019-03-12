/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_310;

/**
 *
 * @author User
 * this is for practicing SQL in Java
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;



public class LoadDriver {
  
    public static void main(String[] args) {
//        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Connection conn = null;
      
            try {
//              Class.forName("com.mysql.jdbc.Driver").newInstance();
              conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                                            "user=root&password=root");
              
              java.sql.Statement stmt = conn.createStatement();
//              rs = stmt.executeQuery("SELECT foo FROM bar");
              
              // or alternatively, if you don't know ahead of time that
              // the query will be a SELECT...
              
              if (stmt.execute("SELECT * FROM Customer")) {
                ResultSet resultSet = stmt.getResultSet();
                
                while (resultSet.next()) {
                  // print the columns of the current row (indexed by name)
                  System.out.print(resultSet.getString("CustomerID"));
                  System.out.print(", ");
                  System.out.print(resultSet.getString("CompanyName"));
                  System.out.print(", ");
                  System.out.print(resultSet.getString("ContactName"));
                  System.out.println();
                }
              }
              // Do something with the Connection
              
              
            
            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
              }
//        } catch (Exception ex) {
//            // handle the error
//        }
    }
}
