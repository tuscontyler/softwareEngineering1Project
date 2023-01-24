package Level3Package;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import characterPackage.*;


public class L3_W4 extends BasicGameState {

	
	baseCharacter player1;
	
	Image map3 = null;
	
	Image PlayerStanding;
	
	private float x = 400, y = 350;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		map3 = new Image("images/Zone3.4.png");
		PlayerStanding = new Image("images/WizardStanding.png");
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map3.draw(0, 0);
		PlayerStanding.draw(x, y);
		
	}

	@Override
	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = window.getInput();
		
		if(input.isKeyDown(Input.KEY_W)) {
			
			y -= 0.2 * delta;
		}
		if(input.isKeyDown(Input.KEY_A)) {
			
			x -= 0.2 * delta;
		}
		if(input.isKeyDown(Input.KEY_S)) {
			
			y += 0.2 * delta;
		}
		if(input.isKeyDown(Input.KEY_D)) {
			
			x += 0.2 * delta;
		}
		if(input.isKeyDown(Input.KEY_I)) {
			inventoryMenu.setTempId(getID());
			sbg.enterState(100);
				}
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			
			sbg.enterState(1);
		}
		
		//Player steps through Red Door
		if((x >= 300 && x <= 430) && (y >= -53 && y <= 0)){ 
			sbg.enterState(23); 
		}
		
		//Player steps through Green Door
		if((x >= 300 && x <= 430) && (y >= 500 && y <= 553)){
			sbg.enterState(26);
		}
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 25;
	}
}