package zooPackage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {
	private static Clip clip;

	public static void playMusic(String filePath) {
		try {
			File audioFile = new File(filePath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);

			clip.start();

			// Sleep for the duration of the clip to allow it to play
//			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException  e) {
			e.printStackTrace();
		}
	}
}
