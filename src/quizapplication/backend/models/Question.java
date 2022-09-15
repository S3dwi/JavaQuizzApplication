package quizapplication.backend.models;

import quizapplication.backend.Database;
import java.sql.*;
import java.util.*;

public class Question {  
    public int id;
    public String title;
    public String correctAnswer;
    public String wrongAnswer;
    public int userId;
    Connection databaseConnection;

    public Question() {
        this.databaseConnection = Database.getConnection();
    }
    public Question(String title, String correctAnswer, String wrongAnswer) {
        this.title = title;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.databaseConnection = Database.getConnection();
    }
    
    // Needs id field to be assigned only.
    public Question getOne(){
        String sql = "SELECT * FROM " + "question" + " WHERE id="+this.id;
        try (Statement stmt = databaseConnection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql);
            while (results.next()) {
                this.id = results.getInt("id");
                this.title = results.getString("title");
                this.correctAnswer = results.getString("correctAnswer");
                this.wrongAnswer = results.getString("wrongAnswer");
                this.userId = results.getInt("userId");
            }
            System.out.println("Succesfully got one Question");
        }catch(Exception e){
            System.out.println("something went wrong : "+e.getMessage());
        }
        return this;
    }
    
    // No Need for any field to be assigned.
    public ArrayList getAll(){
        String sql = "SELECT * FROM " + "question" + " WHERE userId="+this.userId;
        
        ArrayList<Question> allQuestions = new ArrayList<>();
        
        try (Statement stmt = databaseConnection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql);
            while (results.next()) {
                Question question = new Question(
                        results.getString("title"), 
                        results.getString("correctAnswer"),
                        results.getString("wrongAnswer")
                );
                question.id = results.getInt("id");
                question.userId = results.getInt("userId");
                allQuestions.add(question);
            }
            System.out.println("Succesfully got all Questions");
        }catch(Exception e){
            System.out.println("something went wrong : "+e.getMessage());
        }
        
        return allQuestions;
    }
    
    // Needs all fields to be assigned except the id.
    public Question create(){
        String sql = "INSERT INTO " + "question" +" (title, correctAnswer, wrongAnswer, userId) VALUES ("+ this.title + ","+ this.correctAnswer + "," + this.wrongAnswer + ","+ this.userId + ","+")";
        try(Statement statement = databaseConnection.createStatement()){
//            statement.executeUpdate(sql);
            if(statement.executeUpdate(sql) > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    this.id = generatedKeys.getInt("id");
                }
                System.out.println("Created new Question");
            }
        }catch(Exception e){
            System.out.println("something went wrong when creating the question..: "+e.getMessage());
        }
        return this;
    }
}
