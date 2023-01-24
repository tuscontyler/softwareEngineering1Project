package startMenuPackage;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class MusicControl 
{	
	private Music[] bgm;
	
	MusicControl()
	{
		bgm = new Music[10];
		try {
			bgm[0] = new Music("Sounds/placeholder.wav");
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	void musicToPlay(int songToPlay)
	{
		bgm[songToPlay].loop();
		//bgm[songToPlay].setVolume((float) 0.5);
	}
	void lowerMusic(double volumeValue, int currentSong)
	{
		//bgm[currentSong].pause();
		bgm[currentSong].setVolume(0.1f);
		System.out.println(volumeValue);
		
	}

}
