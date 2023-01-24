package Level2Package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import characterPackage.*;


public class L2_W1 extends BasicGameState {

	
	baseCharacter player1;
	
	Image map2 = null;
	
	Image PlayerStanding;
	
	private float x = 400, y = 350;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		map2 = new Image("images/Zone2.1.png");
		PlayerStanding = new Image("images/WizardStanding.png");
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map2.draw(0, 0);
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
		
		//shortcut for Level 3
		if(input.isKeyDown(Input.KEY_3)) {
					
			sbg.enterState(22);
		}
		
		//Player steps through Yellow Door
		if((x >= -31 && x <= 38) && (y >= 200 && y <= 305)) { 
			sbg.enterState(16); 
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 15;
	}

}

