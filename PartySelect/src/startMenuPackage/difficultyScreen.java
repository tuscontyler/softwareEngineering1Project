package startMenuPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class difficultyScreen extends BasicGameState {

	private Image img = null;
	private Music bgm;	//BGM stands for background music
	private boolean difficultyChosen = false;
	private boolean onetime = false;
	private double gameDifficultyModifer =0;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		
		img = new Image("images/Menu.png");
		
	}
	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		
		img.draw(0, 0);
	
		g.drawString("easy", 175, 300);	//adjusted X value for text position to make it look centered
		
		g.drawString("Medium", 325, 300);	//adjusted X value for text position to make it look centered
		
		g.drawString("hard", 450, 300);	//adjusted X value for text position to make it look centered
		
		g.drawString("Insane", 575, 300);	//adjusted X value for text position to make it look centered
		
		if(difficultyChosen) {
		g.drawString("Next", 700, 500);
		}
		
		g.drawString("Back", 100, 500);	
		
		
	}
	@Override
	public void update(GameContainer window, StateBasedGame sbg, int dalta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		
		if((posX > 150 && posX < 225) && (posY > 265 && posY < 315)) { //clickable area for easy
			if(Mouse.isButtonDown(0) && onetime == false) {	
				System.out.println("easy selected");
				difficultyChosen=true;
				 onetime = true;
				 gameDifficultyModifer =1.0;
			}
			if(!Mouse.isButtonDown(0)) 
			{
				 onetime = false;
			}
		}
		
		if((posX > 310 && posX < 365) && (posY > 265 && posY < 315)) { //clickable area for medium
			if(Mouse.isButtonDown(0) && onetime == false) {	
				System.out.println("medium selected");
				difficultyChosen=true;
				 onetime = true;
				 gameDifficultyModifer =1.25;
			}
			if(!Mouse.isButtonDown(0)) 
			{
				 onetime = false;
			}
		}
		
		if((posX > 435 && posX < 490) && (posY > 265 && posY < 315)) { //clickable area for medium
			if(Mouse.isButtonDown(0) && onetime == false) {	
				System.out.println("hard selected");
				difficultyChosen=true;
				 onetime = true;
				 gameDifficultyModifer =1.5;
			}
			if(!Mouse.isButtonDown(0)) 
			{
				 onetime = false;
			}
		}
		
		if((posX > 560 && posX < 600) && (posY > 265 && posY < 315)) { //clickable area for medium
			if(Mouse.isButtonDown(0) && onetime == false) {	
				System.out.println("insane selected");
				difficultyChosen=true;
				 onetime = true;
				 gameDifficultyModifer =2.0;
			}
			if(!Mouse.isButtonDown(0)) 
			{
				 onetime = false;
			}
		}
		
		
		
		
		if((posX > 685 && posX < 715) && (posY > 75 && posY < 110)) {//clickable  to party screen 
			if(Mouse.isButtonDown(0)) {	
				sbg.enterState(2);
				
			}
		}
		if((posX > 85 && posX < 115) && (posY > 75 && posY < 110)) { ///clickable  to start screen
			if(Mouse.isButtonDown(0)) {	
				sbg.enterState(1);	
			}
			
		}
		
		
	
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 20;
	}
	public double getgameDifficultyModifer() {
		// TODO Auto-generated method stub
		return gameDifficultyModifer;
	}
}

