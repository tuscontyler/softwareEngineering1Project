package battlePackage;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class SilverDragon extends Enemy {

	public SilverDragon() {
		setEnemyName("Silver Dragon");	//Default enemy will always be a basic Slime
		setEnemyDescription("The second strongest dragon of them all.");
		this.maxEnemyHealth = 200;
		this.enemyStrength = 15;
		this.enemyArmor = 10;
		this.enemySpeed = 3;
		this.itemDropTier = 3;
		this.goldToDrop = 1000;
		this.canBeFledFrom = false;
		this.currentHealth = maxEnemyHealth;
		
		try {
			this.enemySprite = new SpriteSheet("images/SilverDragon.png", 225, 150);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.enemyAnimation = new Animation(enemySprite, 200);
	}
}
