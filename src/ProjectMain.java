import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Note;

/**
 * Application that plays a hand-written song using JFugue 5.0's library.
 * This is my submission for my semester-long project for my music class.
 * in Spring 2021.
 * 
 * @author Francisco Reyna 
 * University of Texas at Austin Computer Science
 */

public class ProjectMain {
    
    // Constants
    private static char INTRO_CHAR = '*';
    private static int INTRO_N = 35;

    public static void main(String[] args) {
        displayIntro();
        displayChoices();
        
        Scanner kb = new Scanner(System.in);
        Song songChoice = getUserChoice(kb);
        Player player = new Player();
        Pattern songPattern = songChoice.getPattern();
        player.play(songPattern);
    }

    /**
     * Asks the user for input (select a song) from the displayed list
     * @param kb Scanner used to get input from the keyboard
     * @return The Song Object for whatever song the User selected.
     */
    private static Song getUserChoice(Scanner kb) {
        Song song = null;
        boolean validChoice = false;
        // While loop used to continue asking until a valid choice is entered
        while (!validChoice) {    
            System.out.print("\nChoice: ");
            int choice = kb.nextInt();
            switch (choice) {
                case 1:
                    song = new OdeToJoy();
                    System.out.println("Selected Song: Ode To Joy");
                    validChoice = true;
                    break;
                case 2: 
                    song = new WatashiNoUso();
                    System.out.println("Selected Song: Watashi No Uso");
                    validChoice = true;
                    break;
                default: 
                    System.out.println("That is not a valid choice.");
                    break;
            }
        }
        return song;
    }

    // Prints the song choices
    private static void displayChoices() {
        System.out.println(printCharNTimes(INTRO_CHAR, INTRO_N));
        System.out.println("What song would you like to play?");
        System.out.println("(Input a Number)");
        System.out.println();
        // Songs
        int songNum = 1;
        System.out.println(songNum + "- Ode To Joy");
        songNum++;
        System.out.println(songNum + "- Watashi no Uso");
        System.out.println(printCharNTimes(INTRO_CHAR, INTRO_N));
    }

    /**
     * Displays the introductory comments to the application
     */
    private static void displayIntro() {
        System.out.println(printCharNTimes(INTRO_CHAR, INTRO_N));
        System.out.println("Welcome to Francisco's Independent");
        System.out.println("Scholarship Project for MUS303E.");
        System.out.println(printCharNTimes(INTRO_CHAR, INTRO_N));
        System.out.println();
    }

    /**
     * Creates a string of char ch, n times
     * @param ch The char that is to be appended
     * @param n How many times we want ch to be repeated within the return string
     * @return The final concatenated string
     */
    private static String printCharNTimes(char ch, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void playSong(String song) {}

}
