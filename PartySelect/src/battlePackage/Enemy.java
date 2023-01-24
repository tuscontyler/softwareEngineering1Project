package battlePackage;

import java.util.Random;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

import characterPackage.Item;
import characterPackage.baseCharacter;

public class Enemy implements Fightable {
	private String enemyName;
	private String enemyDescription;
	int maxEnemyHealth;
	int enemyStrength;
	int enemyArmor;
	int enemySpeed;				//used to determine both turn order in battle and hit chance of attacks against enemy
	int itemDropTier;			//refer to item spreadsheet on Drive. 1 = common, 2 = uncommon, 3 = rare
	int goldToDrop;
	boolean canBeFledFrom; 		//will be set to false for bosses
	int currentHealth;
	
	Random rand = new Random();	//Java Random class needed to choose a random target of enemy attacks
	
	SpriteSheet enemySprite; 			//TODO: Import pictures
	Animation enemyAnimation;
	
	public Enemy() { //throws statement required for spritesheet class
		this.enemyName = "Ordinary Slime";	//Default enemy will always be a basic Slime
		this.enemyDescription = "A slimy slime that feels... slimy.";
		this.maxEnemyHealth = 10;
		this.enemyStrength = 3;
		this.enemyArmor = 5;
		this.enemySpeed = 3;
		this.itemDropTier = 1;
		this.goldToDrop = 50;
		this.canBeFledFrom = true;
		this.currentHealth = maxEnemyHealth;
		
		try {
			this.enemySprite = new SpriteSheet("images/slime1.png", 128, 128);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.enemyAnimation = new Animation(enemySprite, 200);
	}
	
	public Enemy(String enemyName, String enemyDescription, int maxEnemyHealth, int enemyStrength, int enemyArmor, int enemySpeed, int itemDropTier, int goldToDrop, boolean canBeFledFrom) throws SlickException {
		this.enemyName = enemyName;
		this.enemyDescription = enemyDescription;
		this.maxEnemyHealth = maxEnemyHealth;
		this.enemyStrength = enemyStrength;
		this.enemyArmor = enemyArmor;
		this.enemySpeed = enemySpeed;
		this.itemDropTier = itemDropTier;
		this.goldToDrop = goldToDrop;
		this.canBeFledFrom = canBeFledFrom;
		this.currentHealth = maxEnemyHealth;
		
		this.enemySprite = new SpriteSheet("images/slime1.png", 128, 128);	//TODO: create global file of enemies to pull from
		this.enemyAnimation = new Animation(enemySprite, 200);
	}
	
	public void healEnemy(int amountToHeal) {					//Heals by specified amount
		if ((currentHealth + amountToHeal) > maxEnemyHealth) {	//Prevents from going over max HP
			currentHealth = maxEnemyHealth;
		}
		else {
			currentHealth += amountToHeal;
		}
	}
	
	public void hurtEnemy(int amountToHurt) {					//Does specified amount of damage to enemy
		if ((currentHealth - amountToHurt) < 0) {				//Prevents from going under 0HP
			currentHealth = 0;
		}
		else {
			currentHealth -= amountToHurt;
		}
	}
	
	int chooseTarget() {	//Since there are 3 characters, target will be chosen randomly from the 3
		return rand.nextInt(3);		//Returns a 0, 1, or 2 at random
	}
	
	public Item dropItem() {
		//Check enemy's item tier, then randomly select an item to drop within that tier
		return new Item();
	}
	
	public int dropGold() {
		return goldToDrop;
	}
	
	public Animation getEnemyAnimation() {
		return enemyAnimation;
	}
	
	public void setEnemyName(String name) {
		name = enemyName;
	}
	
	public String getEnemyName() {
		return enemyName;
	}
	
	public void setEnemyDescription(String desc) {
		desc = enemyDescription;
	}
	
	public String getEnemyDescription() {
		return enemyDescription;
	}
	
	public int getCurrentEnemyHealth() {
		return currentHealth;
	}
	
	public int getMaxEnemyHealth() {
		return maxEnemyHealth;
	}
	
	public int getBaseSpeed() {
		return enemySpeed;
	}
	
	public int getStrength() {
		return enemyStrength;
	}

	@Override
	public int getSpeed() {
		return enemySpeed;
	}
	
	@Override
	public boolean isDefeated() {	//Checks if an enemy's health has hit 0
		if (currentHealth <= 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String getName() {
		return enemyName;
	}
	
	@Override
	public boolean isCharacter() {
		return false;
	}

	@Override
	public int getCurrentHealth() {
		return currentHealth;
	}

	@Override
	public void setHealth(int amount) {
		this.currentHealth = amount;
		
	}

	@Override
	public void attack(Fightable target, int amount) {
		target.setHealth(target.getCurrentHealth() - amount);
	}
	
}
