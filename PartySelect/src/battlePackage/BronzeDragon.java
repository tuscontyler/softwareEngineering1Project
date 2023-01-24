package battlePackage;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class BronzeDragon extends Enemy {

	public BronzeDragon() {
		setEnemyName("Bronze Dragon");	//Default enemy will always be a basic Slime
		setEnemyDescription("The third strongest dragon of them all.");
		this.maxEnemyHealth = 100;
		this.enemyStrength = 15;
		this.enemyArmor = 10;
		this.enemySpeed = 3;
		this.itemDropTier = 3;
		this.goldToDrop = 500;
		this.canBeFledFrom = false;
		this.currentHealth = maxEnemyHealth;
		
		try {
			this.enemySprite = new SpriteSheet("images/BronzeDragon.png", 225, 150);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.enemyAnimation = new Animation(enemySprite, 200);
	}
}