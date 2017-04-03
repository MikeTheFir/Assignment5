
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pistm9061
 */
public class A5Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get user input
        Scanner in = new Scanner(System.in);
        int right = 0;
        int wrong = 0;
        // enter a word
        System.out.println("Player 1: Enter a word");

        // create two strings one of which will be hidden in the next step
        String word = in.nextLine();
        int length = word.length();
        String unhidden = word;

        // replace letters in word with dashes
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(i, i + 1);
            char temp1 = temp.charAt(0);

            word = word.replace(temp1, '-');
        }

        // clearing the screen
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }

        // creating a stringbuilder
        StringBuilder graham = new StringBuilder(word);

        // start of guessing
        while ((wrong < 5) && (right < length)) {
            int q = 0;
            // show start of the hungman
            if (wrong == 0) {
                System.out.println("----------");
                System.out.println("|        |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
            }
            // show the word with current correctly guessed letters and ask for guess
            System.out.println(graham);
            System.out.println("Please enter your guess");
            // next letter typed is the guess
            String guess = in.nextLine();
            char guesss = guess.charAt(0);

            // compare guess against letters in word and if correct replace dash with that letter
            for (int i = 0; i < length;) {
                char letter = unhidden.charAt(i);
                if (guesss == letter) {
                    System.out.println("Congrats you guessed one right.");
                    right++;
                    q++;
                    graham.setCharAt(i, guesss);
                }
                i++;
            }

            // adding parts to the gallows with how many guesses they got wrong
            if (q < 1) {
                wrong++;
                System.out.println("Oh no. That isn't right");
                if (wrong == 1) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 2) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|        |");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 3) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|");
                    System.out.println("|");
                }
                if (wrong == 4) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|        |");
                    System.out.println("|");
                }
                if (wrong == 5) {
                    System.out.println("----------");
                    System.out.println("|        |");
                    System.out.println("|       ( )");
                    System.out.println("|       \\|/");
                    System.out.println("|        |");
                    System.out.println("|       / \\");
                }
            }

        }
        // tell them they won
        if (right == length) {
            System.out.println(graham);
            System.out.println("Congratulations, you won!");

            // tell them they lost and what the word was
        } else {
            System.out.println("The word was " + unhidden + ". You lose!");
            break;
        }

    }
}
//                 +-------+_
//                 |       | \
//                \O/      |  \
//           ______|_______|___\
//__________/|_____|\______|||||\____