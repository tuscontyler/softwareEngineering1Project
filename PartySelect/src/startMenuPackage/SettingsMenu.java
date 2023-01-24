package startMenuPackage;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
//import org.newdawn.slick.Sound.*;
//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.*;


public class SettingsMenu extends BasicGameState {
	
	double volumeValue = 50;
	private Music sound;
	boolean mute = false;
	int oneTime = 0;
		
	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		sound = new Music("music/PartySelect.wav");
		sound.loop();
	}
	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.drawString("Settings Menu", 340, 35);	//TODO: Implement sound settings when sound is added
		
		//Volume Mute and raise/lower
		g.drawString("Volume: ", 200, 200);
		
		g.drawRoundRect(275, 202, 15, 15, 1);
		g.drawString("Mute", 267, 220);
		
		g.drawRoundRect(325, 202, 15, 15, 1);
		g.drawString("Down", 317, 220);
		
		g.drawRoundRect(375, 202, 15, 15, 1);
		g.drawString("Up", 374, 220);
		
		g.drawString(volumeValue + "%", 425, 202);
		
		//Back to Menu
		g.drawString("Back", 100, 450);
	}
	@Override
	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		//System.out.println("X = " + posX + ", Y = " + posY);// this is for finding the x and y cordinates

		
		if((posX > 75 && posX < 175) && (posY > 125 && posY < 155)) { //clickable area for back button
			if(Mouse.isButtonDown(0)) {	
					sbg.enterState(1);
			}
		}
	   if((posX > 265 && posX < 295) && (posY > 380 && posY < 400)) {
			if(Mouse.isButtonDown(0) && oneTime < 1) 
			{
					//volume mutes
					if (!mute)
					{
						sound.pause();
						mute = true;
						oneTime++;
					}
					else
					{
						sound.play();
						mute = false;
						oneTime++;
					}
			}
			if(!Mouse.isButtonDown(0)) 
			{
				oneTime = 0;
			}
		}
	   if((posX > 325 && posX < 340) && (posY > 380 && posY < 400)) {
			if(Mouse.isButtonDown(0)&& oneTime < 1) 
			{
				//volume decreases by 10% unless value is already 0
				if(volumeValue != 0) 
				{
					volumeValue = volumeValue - 10;
					sound.setVolume((float)volumeValue/100);
					oneTime++;
				}	
			}
			if(!Mouse.isButtonDown(0)) 
			{
				oneTime = 0;

			}	
		}
	   if((posX > 375 && posX < 390) && (posY > 380 && posY < 400)) 
	   {
			if(Mouse.isButtonDown(0) && oneTime < 1) 
			{
				//volume increases by 10% unless value is already 100
				if(volumeValue < 100) 
				{
					volumeValue = volumeValue + 10;
					sound.setVolume((float)volumeValue/100);
					oneTime++;
				}
			}
			if(!Mouse.isButtonDown(0)) 
			{
				oneTime = 0;
			}
		}
	}
	@Override
	public int getID() {
		return 3;
	}
}