import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;

/**
 * 
 */
public class OneSummersDay implements Song {

    // Song method
    public Pattern getPattern() {
        Pattern pattern = null;
        try {
            pattern = MidiFileManager.loadPatternFromMidi(new File("OneSummersDay.mid"));
        } catch (IOException e) {
            System.out.println("ERROR: Failed to load Debug MIDI file.");
        } catch (InvalidMidiDataException e) {
            System.out.println("ERROR: Failed to parse MIDI data for debug song");
        } 
        return pattern;
    }

    public String getSongName() {
        return "One Summer's Day";
    }
}