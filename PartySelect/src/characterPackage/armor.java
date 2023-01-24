package characterPackage;

public class armor extends Item {

	final String ITEM_TYPE = "ARMOR";
	private int armorRating;
	private String itemName;
	
	
	public armor() {
		
		super();
		this.itemName = "basic armor";
		this.armorRating = 1;
	}
	
	public armor(int armorRatingInput,double currencyBuyValueInput, String itemNameInput,String itemDescriptionInput) {
		super(currencyBuyValueInput,itemNameInput,itemDescriptionInput);
	      setArmorRating(armorRatingInput);
	}
	
	
	
	
	private void setArmorRating(int armorRatingInput ) {
		this.armorRating=armorRatingInput;
	}
	public int getArmorRating() {
		return armorRating;
	}
	
	
	public String getITEMTYPE() {
		return ITEM_TYPE;
	}
	public String toString() {
		return getItemName()+ ", "+getItemDescription() +" ,defence value : "+ getArmorRating();
		
		
	}
	
}
