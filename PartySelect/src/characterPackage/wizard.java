package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class wizard extends baseCharacter {
	final String CLASS_TYPE = "WIZARD";
	public int maxHealth = super.getBaseHealth() - 20;
	public int maxMana = super.getBaseMana() + 20;
	public int armorRating = super.getBaseArmor() - 2;
	//no speed modifier
	
	
	
	public wizard() {
		this.characterName="Wizard";
		this.characterDescription="You're a wizard!";
		this.baseHealth = maxHealth;
		this.baseMana = maxMana;
		this.baseArmor= armorRating;
		this.currentHealth = baseHealth;
		this.currentMana = baseMana;
		
		try {
			this.characterArt = new Image("images/WizardStanding.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	
	}
	
	public String getCLASSTYPE() {
		return this.CLASS_TYPE;
	}
}
