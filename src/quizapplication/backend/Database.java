package quizapplication.backend;

import java.sql.*;

public class Database {
    
    private static Database instance = null;
    public Connection connection;
    
    private Database(){
            try {
            connection = DriverManager.getConnection(
               "jdbc:"+ 
               "mysql"
               +"://"+ 
               "localhost"
               +":"+
               "3306"
               +"/"+
               "quizdb",
               "",  //username
               ""   //password
            ); 
            
            System.out.println("Connected To Database Succesfully!");
            
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
  
    public static Connection getConnection()
    {
        if (instance == null) instance = new Database();
              
        return instance.connection;
    }   
}

