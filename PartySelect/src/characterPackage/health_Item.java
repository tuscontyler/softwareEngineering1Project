package characterPackage;

public class health_Item extends Item {
final String ITEM_TYPE = "HEALING CONSUMABLE";
final boolean COMBAT_ITEM = false;
private double healthValue;
private String itemName;

	
	
public health_Item() {
super();
this.itemName = "health potion";
this.healthValue = 20;
}

public health_Item(double healthValueInput,double currencyBuyValueInput, String itemNameInput,String itemDescriptionInput){
super(currencyBuyValueInput,itemNameInput,itemDescriptionInput);
  setHealthValue(healthValueInput);
   }
	
	
	
	private void setHealthValue(double healthValueInput) {
		this.healthValue=healthValueInput;
	}
	
	public double getHealthValue() {
		return this.healthValue;
	}
	
	
	public String getITEMTYPE() {
		return ITEM_TYPE;
	}
	
}
