import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class DebugSong implements Song {

    @Override
    public Pattern getPattern() {
        return new Pattern("C+E+G C+E+G C+E+G C+E+G");
    }
    
}
