
package kerv.NexusPack;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Displays the console menu and collects user input.
 *
 * @author Kerv Paulina
 */
public class ConsoleMenu {

    private final Scanner scanner;

    /**
     *
     * @param args
     */
    static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.menu();
    }

    public ConsoleMenu() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu and executes the selected option.
     */
    public void menu() {
        System.out.println("=============================================");
        System.out.println("\t\t\tWelcome to NexusPack!");
        System.out.println("=============================================");
        System.out.println("[1]. Compress a file");
        System.out.println("[2]. Decompress a file");
        System.out.println("[3]. Exit");

        runner(getUserChoice());
    }

    /**
     * Prompts the user for a menu choice between 1 and 3.
     * Handles invalid text inputs and out-of-range numbers.
     *
     * @return the user's menu selection
     */
    private int getUserChoice() {
        while (true) {
            try {
                System.out.print("Choose an option: ");
                int userInput = scanner.nextInt();

                if (userInput >= 1 && userInput <= 3) {
                    return userInput;
                }

                System.out.println("Wrong input! Please enter a number from [1 to 3].\n");

            } catch (InputMismatchException e) {
                // Clean scanner
                scanner.next();
                System.out.println("Please enter a valid number from the menu.\n");
            }
        }
    }


    /**
     * Executes the operation selected by the user.
     *
     * @param number the selected menu option
     */
    private void runner(int number) {
        switch (number) {
            case 1:
                // Compress a file
                break;

            case 2:
                // Decompress a file
                break;

            case 3:
                System.out.println("Thank you for using NexusPack, bye!");
                break;

            default:
                System.err.println("Wrong menu...");
        }
    }

}
