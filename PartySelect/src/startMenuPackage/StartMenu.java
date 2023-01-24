package startMenuPackage; 

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenu extends BasicGameState{
	
	private Image img = null;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		
	img = new Image("images/Menu.png");
		
	}
	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		
		img.draw(0, 0);
		g.drawString("Start", 375, 300);	//adjusted X value for text position to make it look centered
		g.drawString("Settings", 365, 400);
		g.drawString("Quit", 380, 500);	
		g.drawString("Tempory Merchant Menu", 380, 550);
		
	}
	@Override
	public void update(GameContainer window, StateBasedGame sbg, int dalta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		if((posX > 300 && posX < 425) && (posY > 265 && posY < 315)) { //clickable area for starting the game first going to party selection
			if(Mouse.isButtonDown(0)) {	
					sbg.enterState(20);
			}
		}
		
		if((posX > 300 && posX < 425) && (posY > 175 && posY < 225)) { //clickable area for Settings
			if(Mouse.isButtonDown(0)) {	
					sbg.enterState(3);
			}
		}
		
		if((posX > 300 && posX < 425) && (posY > 75 && posY < 115)) { 
			if(Mouse.isButtonDown(0)) {	
					window.exit();
			}
		}
		if((posX > 300 && posX < 425) && (posY > 25 && posY < 60)) { 
			if(Mouse.isButtonDown(0)) {
				
				sbg.enterState(12);
			}
		}
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
