//import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TimesTables {
    public static void main(final String[] args) {

        int numQuestionsInt = 3; // How many questions to ask
        int numCorrectInt = 0; // How many answers are correct so far

        Scanner userInput1 = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Which tables [1-12]? ");
        String choiceStr = userInput1.nextLine();     // Read user input

        int choiceInt = 0;  // Initialise

        try {
            choiceInt = Integer.parseInt(choiceStr);
        }
        catch (NumberFormatException nfe) {
            System.out.println("That doesn't seem to be an integer.");
            System.exit(1);
        }

        if( choiceInt > 12 ) {
            System.out.println("That number is greater than 12");
            System.exit(1);
        }

        // Get time of day
        long time0 = System.currentTimeMillis();

        // Loop through the required number of questions
        for(int i = 1; i <= numQuestionsInt; i++){
            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randInt = ThreadLocalRandom.current().nextInt(1, 13);

            Scanner userInput2 = new Scanner(System.in); // Create another Scanner object
            System.out.print("Turn " + i + ": what is " + choiceStr + " times " + randInt + "? ");
            String answerStr = userInput2.nextLine(); // Read the user answer

            // Read in the user answer
            int answerInt = 0;
            try {
                answerInt = Integer.parseInt(answerStr);
            }
            catch (NumberFormatException e) {
                System.out.println("Since that isn't a number, it's definitely wrong.");
            }

            // Mark the user answer
            if( answerInt == choiceInt * randInt ) {
                System.out.println("Correct!");
                numCorrectInt++;
            }
            else {
                System.out.println("Wrong");
            }

        } // Finished looping through the required number of questions

        // Get time of day again
        long time1 = System.currentTimeMillis();

        // Calculate how long we took, in seconds
        long timeLong = (time1 - time0) / 1000;

        // Now convert everything to strings ready for printing
        String numCorrectStr   = Integer.toString(numCorrectInt);
        String numQuestionsStr = Integer.toString(numQuestionsInt);
        String timeStr         = Long.toString(timeLong);

        System.out.println("You scored " + numCorrectStr + " out of "
            + numQuestionsStr + " in " + timeStr + " seconds.");

    } // main

}
