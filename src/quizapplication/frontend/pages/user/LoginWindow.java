package quizapplication.frontend.pages.user;

import javax.swing.*;

public class LoginWindow {
    JFrame frame;
    
    public void open() {
        frame = new JFrame("Login Window");
        JTextField usernameTextField = new JTextField(12);
        JLabel usernameLabel = new JLabel("Enter username: ");
        
        JPanel panel1 = new JPanel();
        panel1.add(usernameLabel);
        panel1.add(usernameTextField);
        
        frame.add(panel1);
        
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
    
    public void close(){
        frame.setVisible(false);
    }
}
