package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class cleric extends baseCharacter {
	final String CLASS_TYPE = "CLERIC";
	
	public int maxHealth = super.getBaseHealth() + 10;
	public int maxMana = super.getBaseMana();
	public int maxSpeed = super.getBaseSpeed() - 10;
	public int armorRating = super.getBaseArmor() + 2;

	public cleric() {
		this.characterName="Cleric";
		this.characterDescription="Heal the sick.";
		this.baseHealth = maxHealth;
		this.baseMana = maxMana;
		this.baseArmor= armorRating;
		this.baseSpeed = maxSpeed;
		this.currentHealth = baseHealth;
		
		try {
			this.characterArt = new Image("images/ClericStanding.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

	public String getCLASSTYPE() {
		return this.CLASS_TYPE;
	}
}