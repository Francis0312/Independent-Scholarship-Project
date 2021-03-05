import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

/**
 * 
 */
public class Lit implements Song {

    // Song method
    public Pattern getPattern() {
        Pattern pattern = null;
        try {
            pattern = MidiFileManager.loadPatternFromMidi(new File("Lit.mid"));
            pattern.setTempo("Presto");
        } catch (IOException e) {
            System.out.println("ERROR: Failed to load Debug MIDI file.");
        } catch (InvalidMidiDataException e) {
            System.out.println("ERROR: Failed to parse MIDI data for debug song");
        } 
        return pattern;
    }

    public String getSongName() {
        return "Lit";
    }
}