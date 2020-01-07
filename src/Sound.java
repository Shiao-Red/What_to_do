import java.io.File;
import javax.sound.sampled.*;

public class Sound {

	Thread t;
	byte[] data;
	AudioFormat format;
	int length;
	Clip clip;

	public Sound(String name) throws Exception {
		AudioInputStream in = AudioSystem.getAudioInputStream(new File(name));
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.loop(clip.LOOP_CONTINUOUSLY);
			
			t=new Thread() {
				public void run() {
					clip.start();
				}
			};
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
}