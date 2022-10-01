import java.util.Scanner;

/*
 * Class: RandomNumberGuesser
 * Instructor:
 * Description: This class is a driver class for RNG, it is responsible for game executing.
 * It contains static methods to control game execution.
 * Due: MM/DD/YYYY
 * Platform/compiler: javac 11.0.16
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: __________
*/

public class RandomNumberGuesser {
    private static int secretNum = RNG.rand();
    private static int guess, low = 0, high = 100;

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This application generates a random integer between 0 and 100 and asks the user to guess repeatedly until they guess correctly.\n");
        System.out.println("Programmer: Basang");

        while(true){
            enterGuess();

            if(RNG.getCount() == 7){
                exitGame("You have exceeded the maximum number of guesses, 7. Try again");
                System.out.println("Programmer: Basang");
            }
            else if(guess == secretNum){
                keepGuess();
            }
            else if(RNG.inputValidation(guess, low, high)){
                checkGuess();
            }
        }
    }

    public static void enterGuess(){
        System.out.print("Enter your guess between "+low+" and "+high+": ");
        guess = in.nextInt();
    }

    public static void checkGuess(){
        if(guess < secretNum){
            System.out.println("Your guess is too low!");
            System.out.println("Programmer: Basang");
            low = guess;
        }
        else{
            System.out.println("Your guess is too high!");
            System.out.println("Programmer: Basang");
            high = guess;
        }
        System.out.println("Number of guesses: " +RNG.getCount()+ "\n");
    }

    public static void keepGuess(){
        String nextGame;

        System.out.println("Congratulations, you guessed correctly. Would you like to guess again? (yes/no)");
        System.out.println("Programmer: Basang");
        in.nextLine();
        nextGame = in.nextLine();

        if(nextGame.equals("yes")){
            newGame();
        }
        else {
            exitGame("Exit...");
        }
    }

    public static void newGame(){
        secretNum = RNG.rand();
        low = 0;
        high = 100;
        RNG.resetCount();
        System.out.println("New number generated. Let's guess!");
        System.out.println("Programmer: Basang");
    }

    public static void exitGame(String reason){
        System.out.println(reason);
        System.out.println("Programmer: Basang");
        System.exit(0);
    }
}
