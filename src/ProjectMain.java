import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Note;
import java.util.ArrayList;
import java.util.List;

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
    private static int EXIT_CHOICE = 0;
    private static int INTRO_N = 35;
    private static List<Song> songList = new ArrayList<>();

    public static void main(String[] args) {
        initSongList();
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
            // Early return null to terminate program
            if (choice == EXIT_CHOICE) {
                return song;
            } 
            // Make sure it is valid
            validChoice = choice >= 1 && choice < songList.size();
            if (validChoice) {
                song = songList.get(choice);
                System.out.println("Selected Song: " + song.getSongName());
            } else {
                System.out.println("That is not a valid choice.");
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
        System.out.println("Input a Number");
        System.out.println();
        // Songs
        System.out.println("0- *Exit Application*");
        for (int curSong = 1; curSong < songList.size(); curSong++) {
            System.out.println(curSong + " - " + songList.get(curSong).getSongName());
        }
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

    // Initializes the List of Songs
    private static void initSongList() {
        songList.add(new DebugSong());
        // Starting at Index 1 of List
        songList.add(new OneSummersDay());
        songList.add(new WatashiNoUso());
        songList.add(new IsabellasLullaby());
        songList.add(new Liebesleid());
        songList.add(new MerryGoRoundOfLife());
        songList.add(new MoonlightSonata());
        songList.add(new HikaruNara());
    }
}
