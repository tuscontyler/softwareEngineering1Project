package Level2Package;


import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Level1Package.Level1Window3;
import characterPackage.*;

public class L2_W6 extends BasicGameState{
	
	baseCharacter player1;
	
	Image map2 = null;
	
	Team party = new Team();
	
	Image PlayerStanding;
	
	SpriteSheet enemySprite;	//This is the room where the Silver Dragon is
	Animation enemyAnimation;
	
	SpriteSheet portalIdleSprite;
	Animation portalIdleAnimation;
	
	SpriteSheet portalOpenSprite;
	Animation portalOpenAnimation;
	
	private float x = 400, y = 350;
	
	private int onlyPayOneTime;
	
	public static boolean isSilverDefeated;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map2 = new Image("images/Zone2.6.png");
		//player1 = team.getFirstMember();
		PlayerStanding = new Image("images/WizardStanding.png");
		
		enemySprite = new SpriteSheet("images/SilverDragon.png", 225, 150);
		enemyAnimation = new Animation(enemySprite, 200);
		
		portalIdleSprite = new SpriteSheet("images/portal2.png", 128, 128);
		portalIdleAnimation = new Animation(portalIdleSprite, 200);
		
		portalOpenSprite = new SpriteSheet("images/portal2open.png", 128, 128);
		portalOpenAnimation = new Animation(portalOpenSprite, 200);
		
		onlyPayOneTime = 0;
		
		isSilverDefeated = false;
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map2.draw(0, 0);
		PlayerStanding.draw(x, y);
		
		if (!isSilverDefeated) {
			enemyAnimation.draw(400, 100);
		}
		
		if(isSilverDefeated) {
			portalOpenAnimation.setLooping(false);
			portalOpenAnimation.draw(100, 100);
			
			portalIdleAnimation.setLooping(true);
			
			if (portalOpenAnimation.isStopped()) {
				portalIdleAnimation.draw(100, 100);
			}
		}
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
		

		
		//Player steps through Brown Door
		if((x >= 718 && x <= 774) && (y >= 200 && y <= 305)){
			sbg.enterState(19);
		}
		
		enemyAnimation.update(delta);
		//Player collides with dragon
		if((!isSilverDefeated) && (x >= 400 && x <= 560) && (y >= 30 && y <= 220)) {	//dragon collision
			sbg.enterState(222);
		}
		
		//If Bronze Dragon is defeated, spawn a portal to Level 3
		if((isSilverDefeated) && (x >= 50 && x <= 150) && (y >= 50 && y <= 150)) {
			sbg.enterState(22);	//first room of level 3
		}
		
		if (isSilverDefeated && onlyPayOneTime < 1) {
			party.addCurrency(1000);	//payout from killing Bronze Dragon
			onlyPayOneTime++;
		}
		
	}
	
	public static void setDragon(boolean state) {
		isSilverDefeated = state;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 21;
}
}
	

