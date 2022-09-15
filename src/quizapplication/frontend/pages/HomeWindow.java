package quizapplication.frontend.pages;

import javax.swing.*;

public class HomeWindow {
    JFrame frame;
    
    public void open() {
        frame = new JFrame("Home Window");
        JButton createButton = new JButton("Create a question");
        JButton showAllButton = new JButton("Show all questions");
        
        JPanel panel1 = new JPanel();
        panel1.add(createButton);
        panel1.add(showAllButton);
        
        frame.add(panel1);
        
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
    
    public void close(){
        frame.setVisible(false);
    }
}

// input -> output
// Textfield

// input -> output
// Buttons -> popup
