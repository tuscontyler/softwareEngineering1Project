package characterPackage;
public class Team {
	final int MAX_PARTY_SIZE = 3;
	final int MAX_INVENTORY_SIZE = 50;	
	private baseCharacter Team[];
	private Item TeamInventory[];
	private static int currencyBalance;
	private int numberOfTeamMembers=0;
	private int itemsInInventory=0;
	private int teamMemberIndex;
	private int invenIndex;
	
	public Team() {
		Team = new baseCharacter[MAX_PARTY_SIZE];
		TeamInventory = new Item[MAX_INVENTORY_SIZE];
		setCurrencyBalance(0);
	}
	
	
	
	public Team(int currencyBalanceInput,int numPartyMembers) {
		Team = new baseCharacter[MAX_PARTY_SIZE];
		TeamInventory = new Item[MAX_INVENTORY_SIZE];
		setCurrencyBalance(currencyBalanceInput);
	}
	
	public boolean isTeamFull() {
		if(numberOfTeamMembers==MAX_PARTY_SIZE) {
			return true;
		}else {
			return false;	
		}
	}
	public boolean isInventoryFull() {
		if(itemsInInventory==MAX_INVENTORY_SIZE) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isInParty(baseCharacter bc) {
		for (int i = 0; i < MAX_PARTY_SIZE; ++i) {
			if (Team[i] == bc) {
				return true;
			}
		}
		return false;
	}
	
	public void addToTeam (baseCharacter bc) { //overloaded method for adding a baseCharacter to a Team
		
		if(isTeamFull()==false) {
			
			Team[teamMemberIndex] = bc;
			numberOfTeamMembers++;
			teamMemberIndex++;
			
		}
	}

	
public void addToTeam(String characterClass,String characterNameInput,String characterDescriptionInput, int baseHealthInput, int baseManaInput,int baseArmorInput,int baseSpeedInput) {
		
		if(isTeamFull()==false) {
			
			if(characterClass.equalsIgnoreCase("wizard")) {
				Team[teamMemberIndex] = new wizard();
				Team[teamMemberIndex].setCharacterName(characterNameInput);
				Team[teamMemberIndex].setCharacterDescription(characterDescriptionInput);
				Team[teamMemberIndex].setBaseHealth(baseHealthInput);
				Team[teamMemberIndex].setBaseMana(baseManaInput);
				Team[teamMemberIndex].setBaseArmor(baseArmorInput);
				Team[teamMemberIndex].setBaseSpeed(baseSpeedInput);
				numberOfTeamMembers++;
				teamMemberIndex++;
			}
			if(characterClass.equalsIgnoreCase("cleric")) {
				
				Team[teamMemberIndex] = new cleric();
				Team[teamMemberIndex].setCharacterName(characterNameInput);
				Team[teamMemberIndex].setCharacterDescription(characterDescriptionInput);
				Team[teamMemberIndex].setBaseHealth(baseHealthInput);
				Team[teamMemberIndex].setBaseMana(baseManaInput);
				Team[teamMemberIndex].setBaseArmor(baseArmorInput);
				Team[teamMemberIndex].setBaseSpeed(baseSpeedInput);
				numberOfTeamMembers++;
				teamMemberIndex++;
			}
			if(characterClass.equalsIgnoreCase("warrior")) {
				
				Team[teamMemberIndex] = new warrior();
				Team[teamMemberIndex].setCharacterName(characterNameInput);
				Team[teamMemberIndex].setCharacterDescription(characterDescriptionInput);
				Team[teamMemberIndex].setBaseHealth(baseHealthInput);
				Team[teamMemberIndex].setBaseMana(baseManaInput);
				Team[teamMemberIndex].setBaseArmor(baseArmorInput);
				Team[teamMemberIndex].setBaseSpeed(baseSpeedInput);
				numberOfTeamMembers++;
				teamMemberIndex++;
				
			}
			if(characterClass.equalsIgnoreCase("ranger")) {
				Team[teamMemberIndex] = new ranger();
				Team[teamMemberIndex].setCharacterName(characterNameInput);
				Team[teamMemberIndex].setCharacterDescription(characterDescriptionInput);
				Team[teamMemberIndex].setBaseHealth(baseHealthInput);
				Team[teamMemberIndex].setBaseMana(baseManaInput);
				Team[teamMemberIndex].setBaseArmor(baseArmorInput);
				Team[teamMemberIndex].setBaseSpeed(baseSpeedInput);
				numberOfTeamMembers++;
				teamMemberIndex++;
			}
			if(characterClass.equalsIgnoreCase("bard")) {
				Team[teamMemberIndex] = new bard();
				Team[teamMemberIndex].setCharacterName(characterNameInput);
				Team[teamMemberIndex].setCharacterDescription(characterDescriptionInput);
				Team[teamMemberIndex].setBaseHealth(baseHealthInput);
				Team[teamMemberIndex].setBaseMana(baseManaInput);
				Team[teamMemberIndex].setBaseArmor(baseArmorInput);
				Team[teamMemberIndex].setBaseSpeed(baseSpeedInput);
				numberOfTeamMembers++;
				teamMemberIndex++;
			}
			
			
		}else {
			System.out.println("Team is full");
		}
		
	}

public void removeFromTeam(baseCharacter bc) {	//overloaded method
	int indexToRemove = -1;
	
	for (int i = 0; i < MAX_PARTY_SIZE; ++i) {	//Loop checks which part of the team array the character to remove is in
		if (Team[i] == bc) {
			indexToRemove = i;
		}
	}
	
	if(indexToRemove != -1) {	//This check prevents wrong character from being removed if correct one not found
		int lastIndex = Team.length -1;
		
		for (int index = indexToRemove; index < lastIndex;++index) {
			Team[index] = Team[index +1];
		}
		Team[lastIndex]=null;
	}
	
	numberOfTeamMembers--;
	
}

public void removeFromTeam(int teamMemberChoice) {
	int indexToRemove = teamMemberChoice-1;
	int lastIndex = Team.length -1;
	
	for (int index = indexToRemove; index < lastIndex;++index) {
		Team[index] = Team[index +1];
	}
	Team[lastIndex]=null;
}


public void addToInventory(Item itemToAdd) {
	if(isInventoryFull()==false) {
	TeamInventory[invenIndex] =  itemToAdd;
	System.out.println(itemToAdd.getItemName());
	System.out.println(TeamInventory[invenIndex].getItemDescription());
	++invenIndex;
	++itemsInInventory;
	}else {
		System.out.println("Sorry the inventory is full, cannot add: " +itemToAdd.toString());
	}
}
public void removeFromInventory(int inventoryItemChoice) {
	int indexToRemove = inventoryItemChoice-1;
	int lastIndex = TeamInventory.length -1;
	
	for (int index = indexToRemove; index < lastIndex;++index) {
		TeamInventory[index] = TeamInventory[index +1];
	}
	TeamInventory[lastIndex]=null;
}

public baseCharacter getFirstMember() {
	return Team[0];
}

public baseCharacter getSecondMember() {
	return Team[1];
}

public baseCharacter getThirdMember() {
	return Team[2];
}
	
	private void clearCurrencyBalance() {
		this.currencyBalance = 0;
	}
	private void setCurrencyBalance(int currencyAmmount) {
		this.currencyBalance=currencyAmmount;
	}
	
	static double getCurrencyBalance() {
		return currencyBalance;
	}
	public void addCurrency(int currencyAmmount) {
		this.currencyBalance += currencyAmmount;
	}
	private void subCurrency(int currencyAmmount) {
		this.currencyBalance -= currencyAmmount;
	}
	
	Item[] getTeamItems() {
		return TeamInventory;
		
	}
	public String toString()
	{
		return "Current Balance: " + getCurrencyBalance();
	}




}
