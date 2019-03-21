import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMusicCmdLine {

    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.play(instrument, note);
        }
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage first = new ShortMessage();
            first.setMessage(192, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(first, 1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, 15);
            track.add(noteOff);
            
            ShortMessage first2 = new ShortMessage();
            first2.setMessage(192, 1, 80, 0);
            MidiEvent changeInstrument2 = new MidiEvent(first2, 16);
            track.add(changeInstrument2);

            ShortMessage a2 = new ShortMessage();
            a2.setMessage(144, 1, 30, 100);
            MidiEvent noteOn2 = new MidiEvent(a2, 1);
            track.add(noteOn2);

            ShortMessage b2 = new ShortMessage();
            b2.setMessage(128, 1, 30, 100);
            MidiEvent noteOff2 = new MidiEvent(b2, 15);
            track.add(noteOff2);

            player.setSequence(seq);
            player.start();

        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

    }
}
