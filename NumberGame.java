import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    private static final int Max_Attempt=10;

    public static void main(String[] args) {
        Scanner se =new Scanner(System.in);
        Random ra = new Random();
        int score=0;
        boolean playaAgain;
        do {
            int random_number= ra.nextInt(100)+1;
            int attempts=0;
            System.out.println("I have generated a number between 1 to 100. Can you guess it?\nBut you have 10 attempts.");
            while (attempts<Max_Attempt)
            {
                System.out.print("Enter your guess: ");
                int userGuess = se.nextInt();
                attempts++;
                if(userGuess==random_number)
                {
                    System.out.println(" (: Congratulation! You guessed the number in "+attempts+" attempts. (:");
                    score++;
                    break;
                } else if (userGuess<random_number) {
                    System.out.println("Too low ): \nNow you have "+(Max_Attempt-attempts)+" attempts.\n");
                }
                else {
                    System.out.println("Too high ):\nNow you have "+(Max_Attempt-attempts)+" attempts.\n");
                }
            }
            if (attempts==Max_Attempt)
            {
                System.out.println(" ): Opps! You've used all attempts. The number was "+random_number+" .");
            }

            System.out.print("Do you Want to play again? (yes/no):");
            playaAgain = se.next().equalsIgnoreCase("yes");

        }while (playaAgain);
        System.out.println("Your final score is "+score);
        se.close();
    }
}
