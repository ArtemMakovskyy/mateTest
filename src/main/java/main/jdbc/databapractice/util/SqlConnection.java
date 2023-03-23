package main.jdbc.databapractice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnection {
   static  {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
   }
   public static Connection getConnection(){
       Properties dbPropetties = new Properties();
       dbPropetties.put("user","root");
       dbPropetties.put("password","FTOfth96");
       try {
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/tea_shop_db",dbPropetties);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

}
