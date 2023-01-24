package characterPackage;

public class Item {

	private String itemName;
	private  String itemDescription;
	private double currencyBuyValue;
	private double currencySellValue;

	
	public Item()
	   {
		 this.currencyBuyValue = 0;
		 this.currencySellValue = 0;
	     this.itemName = "Empty Item Slot";
	     this.itemDescription = "Empty Item Description";
	   }
	
	
	public Item(double currencyValueInput,String itemNameInput,String itemDescriptionInput)
	   {
		setCurrencyBuyValue(currencyValueInput);
		this.currencySellValue=currencyBuyValue/2.0;
	    setItemName(itemNameInput);
		setItemDescription(itemDescriptionInput);
	   }
	
	
	
	public String getItemName() {
		return this.itemName;
	}
	private String setItemName(String itemNameInput) {
		 return this.itemName=itemNameInput;
	}
	
	
	
	
	public String getItemDescription() {
		return this.itemDescription;
	}
	
	private void setItemDescription(String itemDescriptionInput) {
		this.itemDescription = itemDescriptionInput;
	}
	
	
	
	
	private void setCurrencyBuyValue(double currencyBuyValueInput) {
		this.currencyBuyValue = currencyBuyValueInput;
	}
	public double getCurrencyBuyValue() {
		return this.currencyBuyValue;
	}
	
	
	
	
	private void setCurrencySellValue(double currencySellValueInput) {
		this.currencySellValue = currencySellValueInput;
	}
	public double getCurrencySellValue() {
		return this.currencySellValue;
	}
	
	
	public String toString() {
		return "Name: " + getItemName()
		+ "\n\nDescription: " + getItemDescription()
		+ "\n\nPrice: " + getCurrencyBuyValue();
	}
}

