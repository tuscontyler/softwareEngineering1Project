package battlePackage;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GoldenDragon extends Enemy {

	public GoldenDragon() {
		setEnemyName("Golden Dragon");	//Default enemy will always be a basic Slime
		setEnemyDescription("The strongest dragon of them all!");
		this.maxEnemyHealth = 500;
		this.enemyStrength = 15;
		this.enemyArmor = 10;
		this.enemySpeed = 3;
		this.itemDropTier = 3;
		this.goldToDrop = 10000;
		this.canBeFledFrom = false;
		this.currentHealth = maxEnemyHealth;
		
		try {
			this.enemySprite = new SpriteSheet("images/GoldenDragon.png", 225, 150);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.enemyAnimation = new Animation(enemySprite, 200);
	}
}
