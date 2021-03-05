import java.io.File;
import java.io.IOException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.ChordProgression;
import org.jfugue.theory.Note;

public class TestFile {

    private static Player PLAYER = new Player();
    public static void main(String[] args) {
        ChordProgression c = new ChordProgression("I III V");
        //PLAYER.play(string);
        //ChordProgressionExample();
        ChordEx();
    }

    private static void ChordProgressionExample() {
        ChordProgression cp = new ChordProgression("I V VI");
        Chord[] chords = cp.setKey("C").getChords();
        for (Chord chord : chords) {
            System.out.print("Chord "+chord+" has these notes: ");
            Note[] notes = chord.getNotes();
            for (Note note : notes) {
                System.out.print(note+" ");
            }
            System.out.println();
        }
        Player player = new Player();
        player.play(cp);
    }

    private static void ChordEx() {
        // A harmony; the MusicString is “C5q+E5q+G5q”
        PLAYER.play("T[Allegro] [Piano] Cq+Eq+Gq C+E+G C D E "); // plays a chord, then a C by itself
        //Chord ch = new Chord("C+E+G");
        Pattern song = new Pattern();
        song.setTempo(120); // BPM??
        song.add("");
    }

    private static void ex() {
        Pattern p = new Pattern();
        //Notes = C, D, E, F, G, A, B, or R for a rest
        //After specifying the note itself, you may then append a sharp or flat, octave, duration, or chord,
    }

    private static void saveToMidi() {
        Player player = new Player();
        Pattern pattern = new Pattern("A5q B5q C5q"); 
        
        //player.saveMidi(pattern, new File("MySong.midi"));
            
    }

    /** Notes
     * 
     *  whole w
        half h
        quarter q
        eighth i
        sixteenth s
        thirty-second t
        sixty-fourth x
        one-twenty-eighth o
     * 
     * For example, a C6 note, half duration would be C6h, and a D-flat major chord,
        whole duration would be DbmajW. 
     * 
     * 
     */
}
