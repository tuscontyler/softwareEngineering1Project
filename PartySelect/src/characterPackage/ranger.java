package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ranger extends baseCharacter {
	final String CLASS_TYPE = "RANGER";
	//Max health = baseHealth 
	//max mana = 0
	//armor Rating = 12
	public int maxHealth = super.getBaseHealth();
	public int maxMana = 0;
	public int maxSpeed = super.getBaseSpeed() + 10;
	public int armorRating = super.getBaseArmor() + 2;



	public ranger() {
		this.characterName="Ranger";
		this.characterDescription="Glass cannon with no mana.";
		this.baseHealth = maxHealth;
		this.baseMana = maxMana;
		this.baseArmor= armorRating;
		this.baseSpeed = maxSpeed;
		this.currentHealth = baseHealth;
		this.currentMana = baseMana;
		
		try {
			this.characterArt = new Image("images/Ranger Standing.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

	public String getCLASSTYPE() {
		return this.CLASS_TYPE;
	}
}
