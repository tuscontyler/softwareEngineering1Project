package Level1Package;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import characterPackage.*;

public class Level1Window4 extends BasicGameState{
	
	baseCharacter player1;
	
	Image map1 = null;
	
	Image PlayerStanding;
	
	SpriteSheet enemySprite;	//This is the room where the Bronze Dragon is
	Animation enemyAnimation;
	
	SpriteSheet portalIdleSprite;
	Animation portalIdleAnimation;
	
	SpriteSheet portalOpenSprite;
	Animation portalOpenAnimation;
	
	Team party = new Team();
	
	private float x = 400, y = 350;
	
	private int onlyPayOneTime;
	
	public static boolean isBronzeDefeated;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map1 = new Image("images/Zone1.4.png");
		//player1 = team.getFirstMember();
		PlayerStanding = new Image("images/WizardStanding.png");
		
		enemySprite = new SpriteSheet("images/BronzeDragon.png", 225, 150);
		enemyAnimation = new Animation(enemySprite, 200);
		
		portalIdleSprite = new SpriteSheet("images/portal2.png", 128, 128);
		portalIdleAnimation = new Animation(portalIdleSprite, 200);
		
		portalOpenSprite = new SpriteSheet("images/portal2open.png", 128, 128);
		portalOpenAnimation = new Animation(portalOpenSprite, 200);
		
		onlyPayOneTime = 0;
		isBronzeDefeated = false;
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map1.draw(0, 0);
		PlayerStanding.draw(x, y);
		
		if (!isBronzeDefeated && Level1Window3.getEnemyStatus()) {	//Spawns dragon if slime in other room is dead and dragon is not
			enemyAnimation.draw(400, 100);
		}
		
		if(isBronzeDefeated) {
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
		if((x >= 300 && x <= 430) && (y >= 500 && y <= 553)){
			sbg.enterState(4);
		}
		
		enemyAnimation.update(delta);
		//Player collides with dragon
		if((!isBronzeDefeated) && (x >= 400 && x <= 560) && (y >= 30 && y <= 220)) {
			sbg.enterState(111);
			
			y += 75;	//shifts player coordinates away from monster so that they don't automatically collide when battle ends
		}
		
		//If Bronze Dragon is defeated, spawn a portal to Level 2
		if((isBronzeDefeated) && (x >= 50 && x <= 150) && (y >= 50 && y <= 150)) {
			sbg.enterState(15);	//first room of level 2
		}
		
		if (isBronzeDefeated && onlyPayOneTime < 1) {
			party.addCurrency(500);	//payout from killing Bronze Dragon
			onlyPayOneTime++;
		}
		
	}
	
	public static void setDragon(boolean state) {
		isBronzeDefeated = state;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 8;
	}

}