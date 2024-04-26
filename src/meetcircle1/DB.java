package meetcircle1;

import java.sql.*;

// Database connection
public class DB {
 
    Connection con;
    Statement statement;
 public DB(){
        
     try{
                 
         final String url = "jdbc:mysql://localhost:3306/MeetCircle";
         final String userName = "root";
         final String password = "Rahulpalchhetri@123";
         
         con = DriverManager.getConnection(url,userName,password);
         statement = con.createStatement();
     }  catch(Exception e){
         e.printStackTrace();
     }
     //return con;
 }
}
