package characterPackage;

public class weapon_Item extends Item {
	final String ITEM_TYPE = "WEAPON ITEM";
	private double attackDamage;
	private double magicDamage;
	private String itemName;
	
	
	
	
	
	public weapon_Item() {
		super();
		this.itemName = "weapon item";
	}
	
	
	public weapon_Item(double attackDamageInput,double magicDamageInput,double currencyBuyValueInput, String itemNameInput,String itemDescriptionInput)
	{
	super(currencyBuyValueInput,itemNameInput,itemDescriptionInput);
	setAttackDamage(attackDamageInput);
	setMagicDamage(magicDamageInput);
	}
	
	private void setAttackDamage(double attackDamageInput) {
	this.attackDamage = attackDamageInput;
	
	}
	private void setMagicDamage(double magicDamageInput) {
	this.magicDamage = magicDamageInput;
	}
	private double getAttackDamage() {
		return magicDamage;
		
		}
		private double getMagicDamage() {
		return magicDamage;
		}
	
	public String toString() {
		if(attackDamage>0) {
			return getItemName()+ ", "+getItemDescription() +",Attack damage : "+ getAttackDamage();	
		}
		else{
		return getItemName()+ ", "+getItemDescription() +",Magic damage : "+ getMagicDamage();	
		}
	}
}
