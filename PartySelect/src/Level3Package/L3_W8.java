package Level3Package;

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

public class L3_W8 extends BasicGameState{
	
	baseCharacter player1;
	
	Team party = new Team();
	
	Image map3 = null;
	
	Image PlayerStanding;
	
	SpriteSheet enemySprite;	//This is the room where the Golden Dragon is
	Animation enemyAnimation;
	
	private float x = 400, y = 350;
	
	private int onlyPayOneTime;
	
	public static boolean isGoldenDefeated;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map3 = new Image("images/Zone3.8.png");
		//player1 = team.getFirstMember();
		PlayerStanding = new Image("images/WizardStanding.png");
		
		enemySprite = new SpriteSheet("images/GoldenDragon.png", 225, 150);
		enemyAnimation = new Animation(enemySprite, 200);
		
		onlyPayOneTime = 0;
		
		isGoldenDefeated = false;
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map3.draw(0, 0);
		PlayerStanding.draw(x, y);
		
		if (!isGoldenDefeated) {
			enemyAnimation.draw(400, 100);
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
			sbg.enterState(28);
		}
		
		if((!isGoldenDefeated) && (x >= 400 && x <= 560) && (y >= 30 && y <= 220)) {	//dragon collision
			sbg.enterState(333);
		}
		
		if (isGoldenDefeated && onlyPayOneTime < 1) {
			party.addCurrency(10000);	//payout from killing Golden Dragon
			onlyPayOneTime++;
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 29;
	}

	public static void setDragon(boolean b) {
		isGoldenDefeated =  b;
	}

}