package characterPackage;

public class globalItemInventory {
	private Item globalInventory[];
	private int index;
	
	globalItemInventory(){
		globalInventory = new Item[100];
		
		
	}
	
	globalItemInventory(int globalInventorySize){
		globalInventory = new Item[globalInventorySize];
		index=0;
		for(int i = 0;i<3;i++) {
		this.globalInventory[index] = new health_Item(10,50,"Minor Health Potion","Restores some health");
		index++;
		}
		for(int i = 0;i<3;i++) {
			globalInventory[index] = new health_Item(25,100,"Standard Health Potion","Restores some health");
			index++;
			}
		for(int i = 0;i<3;i++) {
			globalInventory[index] = new health_Item(100,300,"Mega Health Potion","Restores some health");
			index++;
			}
		for(int i = 0;i<3;i++) {
			globalInventory[index] = new health_Item(10,50,"Minor Mana Potion","Restores some Mana ");
			index++;
			}
			for(int i = 0;i<3;i++) {
				globalInventory[index] = new health_Item(25,100,"Standard Mana  Potion","Restores some Mana ");
				index++;
				}
			for(int i = 0;i<3;i++) {
				globalInventory[index] = new health_Item(100,300,"Mega Mana  Potion","Restores some Mana ");
				index++;
				}
			for(int i = 0;i<3;i++) {
				globalInventory[index] = new health_Item(10,1000,"Revive Token","Used to revive a team member");
				index++;
				}
			for(int i = 0;i<3;i++) {
				globalInventory[index] = new health_Item(200,500,"Mysterious Potion","Restore Health and Mana fully");
				index++;
				}
			globalInventory[index] = new weapon_Item(1,0,50,"Wooden Sword","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(3,0,150,"Iron Sword","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(2,0,300,"Golden Sword","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(1,0,50,"Wooden axe","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(2,0,150,"Iron axe","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(2,0,300,"Golden axe","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(5,0,100,"Multi-directional handgun","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(10,0,150,"Ban Hammer","Increase attack damage");
			index++;
			globalInventory[index] = new weapon_Item(2,0,50,"Wooden Staff","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,5,150,"Iron Staff","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,3,300,"Golden Staff","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(1,0,50,"Wooden Wand","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,3,150,"Iron Wand","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,2,300,"Golden Wand","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,10,100,"Cursed Artifact","Increase magic damage");
			index++;
			globalInventory[index] = new weapon_Item(0,0,150,"A Literal Broom","Increase magic damage");
			index++;
			
			globalInventory[index] = new armor(1,5,"Paper Bag","Increase defense by 1");
			index++;
			globalInventory[index] = new armor(2,20,"Torn Shirt","Increase defense by 2");
			index++;
			globalInventory[index] = new armor(3,25,"Standard Adventuring Gear","Increase defense by 3");
			index++;
			globalInventory[index] = new armor(5,50,"Snazzy Robe","Increase defense by 5");
			index++;
			globalInventory[index] = new armor(5,75,"Walkin' Boots","Increase defense by 5");
			index++;
			globalInventory[index] = new armor(7,100,"Chain Mail","Increase defense by 7");
			index++;
			globalInventory[index] = new armor(1,5,"Paper Bag","Increase defense by 1");
			index++;
			globalInventory[index] = new armor(2,20,"Torn Shirt","Increase defense by 2");
			index++;
			globalInventory[index] = new armor(3,25,"Standard Adventuring Gear","Increase defense by 3");
			index++;
			globalInventory[index] = new armor(5,50,"Snazzy Robe","Increase defense by 5");
			index++;
			globalInventory[index] = new armor(5,75,"Walkin' Boots","Increase defense by 5");
			index++;
			globalInventory[index] = new armor(7,100,"Chain Mail","Increase defense by 7");
			index++;
			globalInventory[index] = new armor(7,100,"Safety Helmmet","Increase defense by 7");
			index++;
			globalInventory[index]= new armor(10,200,"Royal Guard's Armor","Increase defense by 10");
			index++;
			globalInventory[index] = new armor(10,400,"Fashion Statement","Increase defense by 10");
			index++;
			globalInventory[index] = new armor(15,700,"Crown fo Kings","Increase defense by 15");
			index++;
			globalInventory[index] = new armor(15,700,"Dragon Scale Armor","Increase defense by 15");
			index++;
	}
	
	
	Item[] getGlobaleItems()
	{
		return this.globalInventory;
	}
	
	Item pullItem(int itemPositionChoice) { //pass in the item position, not index, cannot be 0
	int indexToPull=itemPositionChoice-1;
		return globalInventory[indexToPull]; //returns the object, this is used as a parameter for the Team class addToInventory function
		
	}
	void removeFromInventory(int inventoryItemChoice) { //pass in the item position, not index, cannot be 0, else will create an error
		int indexToRemove = inventoryItemChoice-1;
		int lastIndex = index;
		
		for (int index = indexToRemove; index < lastIndex;++index) {
			globalInventory[index] = globalInventory[index +1];
		}
		globalInventory[lastIndex]=null;
	}
	
	
	
}

