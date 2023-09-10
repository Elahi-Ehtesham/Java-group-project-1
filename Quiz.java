import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Quiz {
    private String name;
    private List<Question> questions;
    private int score;

    public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void  takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        score = 0;

        System.out.println("Welcome to the " + name + " Quiz!");
        for (Question q : questions) {
            System.out.println(q.getQuestion());
            List<String> choices = q.getChoices();
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((char) ('A' + i) + ") " + choices.get(i));
            }
            System.out.print("Your answer: ");
            char userAnswer = scanner.nextLine().toUpperCase().charAt(0);
            int userChoice = userAnswer - 'A';

            if (q.isCorrect(userChoice)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + (char) 'A' + q.isCorrect());
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public String getName() {
        return name;
    }
}