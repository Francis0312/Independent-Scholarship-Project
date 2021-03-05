import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * 
 */
public class IsabellasLullaby implements Song {

    // Song method
    public Pattern getPattern() {
        Pattern pattern = null;
        try {
            pattern = MidiFileManager.loadPatternFromMidi(new File("IsabellaLullaby.mid"));
        } catch (IOException e) {
            System.out.println("ERROR: Failed to load Debug MIDI file.");
        } catch (InvalidMidiDataException e) {
            System.out.println("ERROR: Failed to parse MIDI data for debug song");
        } 
        return pattern;
    }
}