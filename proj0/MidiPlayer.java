import javax.sound.midi.*;
import java.io.File;

public class MidiPlayer {

    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);

            Sequence sequence = MidiSystem.getSequence(new File("audio/Pirates of the Caribbean - He's a Pirate (2).mid"));
            sequencer.setSequence(sequence);

            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
