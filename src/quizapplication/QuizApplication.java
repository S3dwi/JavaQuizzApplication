package quizapplication;

import quizapplication.backend.models.Question;
import quizapplication.frontend.pages.HomeWindow;

public class QuizApplication {

    public static void main(String[] args) {
        HomeWindow home = new HomeWindow();
        home.open();
    }
    
}
