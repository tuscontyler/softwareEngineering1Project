package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class warrior extends baseCharacter {
	final String CLASS_TYPE = "WARRIOR";
	
	
	//Max health = baseHealth - 10
	//max mana = baseMana - 20
	//armor Rating = 16
	
	public int maxHealth = super.getBaseHealth() + 30;
	public int maxMana = super.getBaseMana() - 30;
	public int maxSpeed = super.getBaseSpeed() - 20;
	public int armorRating = super.getBaseArmor() + 6;



	public warrior() {
		this.characterName="Warrior";
		this.characterDescription="Trained in many styles of fighting.";
		this.baseHealth = maxHealth;
		this.baseMana = maxMana;
		this.baseArmor= armorRating;
		this.baseSpeed = maxSpeed;
		this.currentHealth = baseHealth;
		
		try {
			this.characterArt = new Image("images/WarriorStanding.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public String getCLASSTYPE() {
		return this.CLASS_TYPE;
	}
}
