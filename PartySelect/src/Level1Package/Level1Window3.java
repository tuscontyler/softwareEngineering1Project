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

public class Level1Window3 extends BasicGameState{
	
	baseCharacter player1;
	
	Image map1 = null;
	
	Image PlayerStanding;
	
	SpriteSheet enemySprite;
	Animation enemyAnimation;
	
	public static boolean isEnemyDefeated;
	
	int onlyPayOneTime;
	public Team party = new Team();
	
	private float x = 400, y = 350;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		map1 = new Image("images/Zone1.3.png");
		//player1 = team.getFirstMember();
		PlayerStanding = new Image("images/WizardStanding.png");
		
		enemySprite = new SpriteSheet("images/slime1.png", 128, 128);
		enemyAnimation = new Animation(enemySprite, 200);
		
		onlyPayOneTime = 0;
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		map1.draw(0, 0);
		PlayerStanding.draw(x, y);
		
		if (!isEnemyDefeated) {	
			enemyAnimation.draw(200, 100);
		}
		
	}

	@Override
	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = window.getInput();
		
		//Player Movement
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
		

		
		//Player steps through Blue Door
		if((x >= 300 && x <= 430) && (y >= 500 && y <= 553)){
			sbg.enterState(6);
		}
		
		enemyAnimation.update(delta);
		//Player collides with enemy
		if((x >= 150 && x <= 250) && (y >= 50 && y <= 150)){
			sbg.enterState(5);
			
			x += 75;	//shifts player coordinates away from monster so that they don't automatically collide when battle ends
		}
		
		if (isEnemyDefeated && onlyPayOneTime < 1) {
			party.addCurrency(50);	//payout from killing one slime
			onlyPayOneTime++;
		}
		
	}
	
	public static void setEnemy(boolean state) {
		isEnemyDefeated = state;
	}
	
	public static boolean getEnemyStatus() {
		return isEnemyDefeated;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 7;
	}

}

