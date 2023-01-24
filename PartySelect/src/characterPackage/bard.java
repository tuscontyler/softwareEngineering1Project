package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class bard extends baseCharacter {
	final String CLASS_TYPE = "BARD";
	//Max health = baseHealth - 10
	//max mana = baseMana - 20
	//armor Rating = 10
	public int maxHealth = super.getBaseHealth() + 10;
	public int maxMana = super.getBaseMana() - 20;
	public int maxSpeed = super.getBaseSpeed() + 20;
	//public double armorRating = super.getBaseArmor(); No modifier

	public bard() {
		this.characterName="Bard";
		this.characterDescription="Sing your heart out.";
		this.baseHealth = maxHealth;
		this.baseSpeed = maxSpeed;
		this.baseMana = maxMana;
		this.currentHealth = baseHealth;
		
		try {
			this.characterArt = new Image("images/BardStanding.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}

	public String getCLASSTYPE() {
		return this.CLASS_TYPE;
	}
}
