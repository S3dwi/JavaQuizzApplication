package quizapplication.backend.models;

import java.sql.*;
import quizapplication.backend.Database;

public class User {
    public int id;
    public String username;
    Connection databaseConnection;
    
    public User(){
        this.databaseConnection = Database.getConnection();
    }
    public User(String username){
        this.username = username;
        this.databaseConnection = Database.getConnection();
    }
    
    // Needs all fields to be assigned except the id.
    public User register(){
        String sql = "INSERT INTO " + "user" +" (username) VALUES ("+this.username+")";
        try(Statement statement = databaseConnection.createStatement()){
//            statement.executeUpdate(sql);
            if(statement.executeUpdate(sql) > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.id = generatedKeys.getInt("id");
                }
                System.out.println("Created new user");
            }
        }catch(Exception e){
            System.out.println("something went wrong when user is registering..: "+e.getMessage());
        }
        return this;
    }
    
    // Needs all fields to be assigned except the id.
    public User login(){
        String sql = "SELECT * FROM " + "user" + " WHERE username='"+this.username+"'";
        try (Statement stmt = databaseConnection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql);
            while (results.next()) {
                this.id = results.getInt("id");
            }
            System.out.println("Logged in");
        }catch(Exception e){
            System.out.println("User is not registered: "+e.getMessage());
        }
        return this;
    }
}
