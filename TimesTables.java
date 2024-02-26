//import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TimesTables {
    public static void main(final String[] args) {

        //System.out.println("args.length == " + args.length);

        int numQuestionsInt = 3;
        int numCorrectInt = 0;

        Scanner userInput1 = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Which tables [1-12]? ");
        String choiceStr = userInput1.nextLine();     // Read user input

        int choiceInt = 0;  // Initialise

        try {
            choiceInt = Integer.parseInt(choiceStr);
        }
        catch (NumberFormatException e) {
            System.out.println("That doesn't seem to be an integer.");
            System.exit(1);
        }

        if( choiceInt > 12 ) {
            System.out.println("That number is greater than 12");
            System.exit(1);
        }

        for(int i = 1; i <= numQuestionsInt; i++){
            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randInt = ThreadLocalRandom.current().nextInt(1, 13);

            Scanner userInput2 = new Scanner(System.in); // Create another Scanner object
            System.out.print("Turn " + i + ": what is " + choiceStr + " times " + randInt + "? ");
            String answerStr = userInput2.nextLine(); // Read the user answer

            int answerInt = 0;
            try {
                answerInt = Integer.parseInt(answerStr);
                //System.out.println("choiceStr randInt answerStr == " + choiceStr + " " + randInt + " " + answerStr);
            }
            catch (NumberFormatException e) {
                System.out.println("Since that isn't a number, it's definitely wrong.");
            }

            if( answerInt == choiceInt * randInt ) {
                System.out.println("Correct!");
                numCorrectInt++;
            }
            else {
                System.out.println("Wrong");
            }
        }

        System.out.println("You scored " + numCorrectInt + " out of " + numQuestionsInt + ".");

    } // main

} // TimesTables
