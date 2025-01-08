package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
     public  Conn(){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Root");
             s = c.createStatement();
         } catch (Exception e){
             e.printStackTrace();
         }
     }

   // PreparedStatement prepareStatement(String query) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   // }
}
