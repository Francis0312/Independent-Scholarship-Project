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
        // Objects used every iteration
        Scanner kb = new Scanner(System.in);
        Player player = new Player();
        // Fence Post - first run is guaranteed
        displayChoices();
        Song songChoice = getUserChoice(kb);
        // Endless loop of the main program
        boolean quit = songChoice == null;
        while (!quit) {
            // Playing the chosen song.
            Pattern songPattern = songChoice.getPattern();
            player.play(songPattern);
            // Getting User Choice
            displayChoices();
            songChoice = getUserChoice(kb);
            quit = songChoice == null; // If userChoice returns null, then exit 
        }
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
                case -1:
                    System.out.println("DEBUG Option chosen");
                    song = new DebugSong();
                    validChoice = true;
                    break;
                case 0: 
                    System.out.println("Exiting ... ");
                    validChoice = true;
                    break;
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
                case 3: 
                    song = new IsabellasLullaby();
                    System.out.println("Selected Song: Isabella's Lullaby");
                    validChoice = true;
                    break;
                case 4: 
                    song = new OneSummersDay();
                    System.out.println("Selected Song: One Summer's Day");
                    validChoice = true;
                    break;
                default: 
                    System.out.println("That is not a valid choice.");
                    break;
            }
        }
        System.out.println();
        return song;
    }

    /**
     * Prints the song choices
     */
    private static void displayChoices() {
        System.out.println(printCharNTimes(INTRO_CHAR, INTRO_N));
        System.out.println("What song would you like to play?");
        System.out.println("Input a Number (0 to exit)");
        System.out.println();
        // Songs
        int songNum = 1;
        System.out.println(songNum + "- Ode To Joy");
        songNum++;
        System.out.println(songNum + "- Watashi no Uso");
        songNum++;
        System.out.println(songNum + "- Isabella's Lullaby");
        songNum++;
        System.out.println(songNum + "- One Summer's Day");
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

}
