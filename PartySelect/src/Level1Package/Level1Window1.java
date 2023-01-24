package Level1Package;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import characterPackage.*;
//import partySelectPackage.PartyMenu;

public class Level1Window1 extends BasicGameState {
	
	//PartyMenu pm = new PartyMenu();
	//Team team = pm.getParty();
	
	baseCharacter player1;
	
	Image map1 = null;
	
	Image PlayerStanding;
	
	private float x = 400, y = 350;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map1 = new Image("images/Zone1.1.png");
		//player1 = team.getFirstMember();
		PlayerStanding = new Image("images/WizardStanding.png");
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map1.draw(0, 0);
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
		
		//shortcut for Level 2
		if(input.isKeyDown(Input.KEY_2)) {
			
			sbg.enterState(15);
		}
		
		
		//Player steps through Green Door
		if((x >= -31 && x <= 38) && (y >= 200 && y <= 305)) { 
			sbg.enterState(6); 
		}
		
		//Player steps through Brown Door
		if((x >= 300 && x <= 430) && (y >= -53 && y <= 0)){ 
				sbg.enterState(8); 
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
