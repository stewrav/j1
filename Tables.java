//import java.lang.String;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Tables {

    public static void main(final String[] args) {

        // How many questions to ask
        int numQuestionsInt = 5;

        // Turn the number of questions into a string, for printing later
        String numQuestionsStr = Integer.toString(numQuestionsInt);

        // The number of answers that are correct so far
        int numCorrectInt = 0;

        // Create a Scanner object
        Scanner userInput1 = new Scanner(System.in);

        // Read user input using the Scanner object
        System.out.print("Which tables [1-12]? ");
        String choiceStr = userInput1.nextLine();

        // Try to turn the user answer into an integer
        int choiceInt = 0;
        try {
            choiceInt = Integer.parseInt(choiceStr);
        } catch (NumberFormatException nfe) {
            System.out.println("That doesn't seem to be an integer.");
            System.exit(1);
        }

        // Insist that the questions are not too difficult
        if (choiceInt > 12) {
            System.out.println("That number is greater than 12");
            System.exit(1);
        }

        // Get the time of day before the questions begin
        long time0 = System.currentTimeMillis();

        // Loop through the required number of questions
        for (int i = 1; i <= numQuestionsInt; i++) {

            // Generate a random number between 1 and 12
            int randInt = ThreadLocalRandom.current().nextInt(1, 12 + 1);

            // Convert i & randInt to strings, ready for asking the user
            String iStr = Integer.toString(i);
            String randStr = Integer.toString(randInt);

            // Ask the question
            System.out.print("Q" + iStr + "/" + numQuestionsStr + ": what is "
                    + choiceStr + " times " + randStr + "? ");

            // Read the user answer
            Scanner userInput2 = new Scanner(System.in);
            String answerStr = userInput2.nextLine();

            // Attempt to turn the user answer string into an integer
            int answerInt;
            try {
                answerInt = Integer.parseInt(answerStr);
            } catch (NumberFormatException e) {
                System.out.println("That isn't a number.");
                answerInt = 0;
            }

            // Mark the user answer
            if (answerInt == choiceInt * randInt) {
                System.out.println("Correct!");
                numCorrectInt++;
            } else {
                System.out.println("Wrong");
            }

            // Finished looping through the required number of questions
        }

        // Get the time of day now that we have finished the questions
        long time1 = System.currentTimeMillis();

        // Calculate how long we took, in seconds
        long timeLong = (time1 - time0) / 1000;

        // Now convert everything to strings ready for printing
        String numCorrectStr = Integer.toString(numCorrectInt);
        String timeStr = Long.toString(timeLong);

        System.out.println("You scored " + numCorrectStr + " out of "
                + numQuestionsStr + " in " + timeStr + " seconds.");

        // End of main
    }

// End of Tables class
}
