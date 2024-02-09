import java.util.Scanner;
import java.lang.String;

public class Kinput {
    public static void main(final String[] args) {

        String secret = "abracadabra";

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Type your name: ");

        String name = myObj.nextLine();          // Read user input
        System.out.print("Type your message: ");
        String message = myObj.nextLine();       // Read user input

        System.out.println("\nHello! You are " + name);
        System.out.println("and your message is \"" + message + "\"");

        /*
        if(name.compareTo("Stew") == 0) {
        */
        if( name.equalsIgnoreCase("stew") ) {
            System.out.println("Secret message is \"" + secret + "\"");
        }

    }
}
