import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleQuizMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Quiz> quizzes = new ArrayList<>();

        while (true) {
            System.out.println("Simple Quiz Maker");
            System.out.println("1. Create Quiz");
            System.out.println("2. Take Quiz");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter quiz name: ");
                    String quizName = scanner.nextLine();
                    Quiz newQuiz = new Quiz(quizName);
                    System.out.print("Enter the number of questions: ");
                    int numQuestions = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    for (int i = 0; i < numQuestions; i++) {
                        System.out.println("Question " + (i + 1) + ":");
                        System.out.print("Enter question: ");
                        String questionText = scanner.nextLine();

                        List<String> choices = new ArrayList<>();
                        for (int j = 0; j < 4; j++) {
                            System.out.print("Enter answer choice " + (j + 1) + ": ");
                            choices.add(scanner.nextLine());
                        }

                        System.out.print("Enter correct answer number (1-4): ");
                        int correctAnswer = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume the newline character

                        Question question = new Question(questionText, choices, correctAnswer);
                        newQuiz.addQuestion(question);
                    }

                    quizzes.add(newQuiz);
                    System.out.println("Quiz \"" + quizName + "\" created successfully!");
                    break;

                case 2:
                    if (quizzes.isEmpty()) {
                        System.out.println("No quizzes available. Create a quiz first.");
                        break;
                    }

                    System.out.println("Choose a quiz to take:");
                    for (int i = 0; i < quizzes.size(); i++) {
                        System.out.println((i + 1) + ". " + quizzes.get(i).getName());
                    }

                    System.out.print("Please select a quiz: ");
                    int quizChoice = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume the newline character

                    if (quizChoice >= 0 && quizChoice < quizzes.size()) {
                        quizzes.get(quizChoice).takeQuiz();
                    } else {
                        System.out.println("Invalid quiz selection.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Simple Quiz Maker!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

}
