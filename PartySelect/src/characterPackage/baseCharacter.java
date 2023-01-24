package characterPackage;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import battlePackage.Fightable;

public class baseCharacter implements Fightable {
	private final int MAX_ARMOR_EQUiPPED = 1;
	protected String characterName;
	protected String characterDescription;
	protected int baseHealth;
	protected int baseMana;
	protected int baseArmor;
	protected int baseSpeed;
	protected int currentHealth;
	protected int currentMana;
	private Item EquippedArmor[];
	
	protected Image characterArt;


	public baseCharacter() {
		this.characterName="Default name";
		this.characterDescription="Default Description";
		this.baseHealth = 100;
		this.baseMana = 100;
		this.baseArmor=10;
		this.baseSpeed=30;
		EquippedArmor = new Item[MAX_ARMOR_EQUiPPED];
		
		try {
			this.characterArt = new Image("images/Ranger standing.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		this.currentHealth = baseHealth;
		this.currentMana = baseMana;
		
	}



public baseCharacter(String characterNameInput,String characterDescriptionInput, int baseHealthInput, int baseManaInput,int baseArmorInput,int baseSpeedInput){
	this.characterName = characterNameInput;
	this.characterDescription = characterDescriptionInput;
	this.baseHealth = baseHealthInput;
	this.baseMana = baseManaInput;
	this.baseArmor = baseArmorInput;
	this.baseSpeed= baseSpeedInput;
	EquippedArmor = new Item[MAX_ARMOR_EQUiPPED];
	
	this.currentHealth = baseHealth;
	this.currentMana = baseMana;
}




public String  getCharacterName() {
	return this.characterName;
}
public void setCharacterName(String characterNameInput) {
	this.characterName=characterNameInput;
}


public String  getCharacterDesctription() { 
	return this.characterDescription;
}
public void setCharacterDescription(String CharacterDesctriptionInput) {
	this.characterDescription=CharacterDesctriptionInput;
}

public int getBaseHealth() {
	return this.baseHealth;
}
public void setBaseHealth(int baseHealthInput) {
	this.baseHealth=baseHealthInput;
}

public void setCurrentHealth(int amount) {
	this.currentHealth = amount;
}
public int getCurrentHealth() {
	return currentHealth;
}

public int getBaseMana() {
	return this.baseMana;
}
public void setBaseMana(int baseManaInput) {
	this.baseMana = baseManaInput;
}

public void setCurrentMana(int amount) {
	this.currentMana = amount;
}
public int getCurrentMana() {
	return currentMana;
}


public int getBaseArmor() {
	return this.baseArmor;
}
public void setBaseArmor(int baseArmorInput) {
	this.baseArmor=baseArmorInput;
}

public int getBaseSpeed() {
	return this.baseSpeed;
}
public void setBaseSpeed(int baseSpeedInput) {
	this.baseSpeed=baseSpeedInput;
}

public Image getArt() {
	return characterArt;
}



@Override
public int getSpeed() {
	return this.baseSpeed;
}



@Override
public boolean isDefeated() {
	if (currentHealth <= 0) {
		return true;
	}
	return false;
}

@Override
public String getName() {
	return characterName;
}

@Override
public boolean isCharacter() {
	return true;
}



@Override
public void setHealth(int amount) {
	this.currentHealth = amount;
	
}

@Override
public void attack(Fightable target, int amount) {
	target.setHealth(target.getCurrentHealth() - amount);
}



@Override
public int getStrength() {
	//TODO: replace with equipped weapon's strength when items are implemented
	return 5;
}



//EquipArmor Fucntion
//if has current equipped, swap it with the passed in and send old one back to teaminventory




}
