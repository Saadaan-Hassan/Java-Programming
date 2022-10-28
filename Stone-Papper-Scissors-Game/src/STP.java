import java.security.SecureRandom;
import java.util.Scanner;

public class STP {

    private SecureRandom rand = new SecureRandom();
    private Scanner sc = new Scanner(System.in);

    private final String CHOICES[] = { "Rock", "Paper", "Scissor" };
    private int counter = 0;

    STP() {
        for (int i = 0; i < 5; i++) {
            int ran = rand.nextInt(3);

            System.out.println("Select one of the given options: ");
            System.out.printf("1- Rock\n2- Paper\n3- Sciccors\n");
            System.out.print("Enter Your Choice: " );
            int userInput = sc.nextInt();

            if (userInput == ran+1) {
                System.out.println("You selected " + CHOICES[userInput-1] + " and computer selected " + CHOICES[ran] + ". Match Draw");
            } else if((userInput == 1 && (ran+1) == 2) || (userInput == 2 && (ran+1) == 3) || (userInput == 3 && (ran+1) == 1)){
                
                System.out.println("You selected " + CHOICES[userInput-1] + " and computer selected " + CHOICES[ran] + ". Computer Wins");
            }
            else if((userInput == 1 && (ran + 1) == 3) || (userInput == 2 && (ran+1) == 1) || (userInput == 3 && (ran+1) == 2)){
                System.out.println("You selected " + CHOICES[userInput-1] + " and computer selected " + CHOICES[ran] + ". You Win");
                counter++;
            }
            // System.out.println(CHOICES[ran]);
        }
    }

    public int score() {
        return counter;
    }
}