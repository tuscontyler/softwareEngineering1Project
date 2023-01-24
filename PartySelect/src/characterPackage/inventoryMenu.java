package characterPackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import partySelectPackage.PartyMenu;

public class inventoryMenu extends BasicGameState{

	private Item inventory[];
	private Team team;
	int itemNumber = -1;
	private int inventorySize;
	private String goldAmount;
	public static int tempLevelID;
	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		team=PartyMenu.getParty();
		inventory = team.getTeamItems();
		inventorySize = inventory.length;
		
	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		int x = 20;
		int y = 20;
		for(int i = 0;i<inventorySize;i++) {
			if(inventory[i] == null) {			
					y = y + 20;				
			}else {
				g.drawString(inventory[i].getItemName(), x, y);	
					y = y + 20;	
			}	
		}
		
		if (itemNumber >= 0) {
			g.drawString(inventory[itemNumber].toString(), 100, 100);
		}	

		g.drawString("back", 700, 500);		
		g.drawString("Gold", 700, 50);
		
		goldAmount = String.valueOf(Team.getCurrencyBalance());
		
		g.drawString(goldAmount, 650, 50);
	}
	
	
	

	@Override
	
	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
	
		if((posX > 20 && posX < 240) && (posY > 564 && posY < 578)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 0;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 539 && posY < 550)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 1;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 516 && posY < 528)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 2;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 490 && posY < 502)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 3;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 464 && posY < 478)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 4;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 439 && posY < 450)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 5;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 416 && posY < 428)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 6;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 390 && posY < 402)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 7;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 364 && posY < 378)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 8;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 339 && posY < 350)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 9;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 316 && posY < 328)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 10;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 290 && posY < 302)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 11;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 264 && posY < 278)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 12;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 239 && posY < 250)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 13;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 216 && posY < 228)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 14;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 190 && posY < 202)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 15;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 164 && posY < 178)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 16;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 139 && posY < 150)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 17;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 116 && posY < 128)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 18;
			}
		}
		if((posX > 20 && posX < 240) && (posY > 90 && posY < 102)) { 
			if(Mouse.isButtonDown(0)) {	
				itemNumber = 19;
			}
		}
		
		if((posX > 685 && posX < 715) && (posY > 75 && posY < 110)) {//clickable to last screen
			if(Mouse.isButtonDown(0)) {	
				sbg.enterState(getTempLevelID());
			}
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 100;
	}
	
	public static void setTempId(int id) {
		tempLevelID = id;
		
	}
	public int getTempLevelID() {
		// TODO Auto-generated method stub
		return tempLevelID;
	}
}
