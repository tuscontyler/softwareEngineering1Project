package partySelectPackage;
import characterPackage.*;

import org.lwjgl.input.Mouse;
//import org.newdawn.slick.state.*;
import org.newdawn.slick.GameContainer;
//import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
//import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
//import org.newdawn.slick.state.transition.FadeInTransition;
//import org.newdawn.slick.state.transition.FadeOutTransition;

public class PartyMenu extends BasicGameState {
		
	public static Team party;
	
	private wizard wizardBox;
	private Image wizardImage;

	private cleric clericBox;
	private Image clericImage;
	
	private ranger rangerBox;
	private Image rangerImage;
	
	private warrior warriorBox;
	private Image warriorImage;
	
	private bard bardBox;
	private Image bardImage;
	
	private baseCharacter optionChosen;
	private baseCharacter temp = new baseCharacter();
	private Image img = null;
	
	public void init(GameContainer window, StateBasedGame arg1) throws SlickException {
		
		//Initialize variables
		party = new Team();
		optionChosen = temp;
		
		//Initialize all party options
		img = new Image("images/Menu.png");
		
		wizardBox = new wizard();
		wizardImage = new Image("images/WizardStanding.png");
				
		clericBox = new cleric();
		clericImage = new Image("images/ClericStanding.png");
		
		rangerBox = new ranger();
		rangerImage = new Image("images/Ranger Standing.png");
		
		warriorBox = new warrior();
		warriorImage = new Image("images/WarriorStanding.png");
		
		bardBox = new bard();
		bardImage = new Image("images/BardStanding.png");

	}

	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		img.draw(0, 0);
		
		g.drawString("Choose Your Party", 310, 35);
		
		g.drawString("Wizard", 100, 75);
		g.drawString("Cleric", 100, 150);
		g.drawString("Ranger", 100, 225);
		g.drawString("Warrior", 100, 300);
		g.drawString("Bard", 100, 375);
		
		g.drawString("Back", 100, 450);
		
		//If an option is selected, then an "Add to Party button will appear
		
		if (party.isInParty(optionChosen)) {	//Toggles "Add to party" and "Remove" text
			g.drawString("Remove", 400, 500);
		}
		else if (optionChosen != temp) {
			g.drawString("Add to Party", 300, 500);
		}
		
		//If a team is full, a "Start Adventure" option will appear
		
		if (party.isTeamFull()) {
			g.drawString("Start Adventure", 500, 500);
		}
		
		//BEGIN: Setting areas where party options are visible//
		
		if (optionChosen == wizardBox) {
			g.drawString(displayStats(wizardBox), 300, 100);
			g.drawImage(wizardImage, 500, 250);
		}
		
		if (optionChosen == clericBox) {
			g.drawString(displayStats(clericBox), 300, 100);
			g.drawImage(clericImage, 500, 250);
		}
		
		if (optionChosen == rangerBox) {
			g.drawString(displayStats(rangerBox), 300, 100);
			g.drawImage(rangerImage, 500, 250);
		}
		
		if (optionChosen == warriorBox) {
			g.drawString(displayStats(warriorBox), 300, 100);
			g.drawImage(warriorImage, 500, 250);
		}
		
		if (optionChosen == bardBox) {
			g.drawString(displayStats(bardBox), 300, 100);
			g.drawImage(bardImage, 500, 250);
		}
		
		//END: Setting areas where party options are visible//

	}

	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//System.out.println("X = " + posX + ", Y = " + posY); // this is for finding the x and y cordinates
		
		//BEGIN: Setting areas where party options are clickable//
		
		if((posX > 75 && posX < 175) && (posY > 500 && posY < 530)) { //clickable area for Wizard option
			if(Mouse.isButtonDown(0)) {	//TODO: Change to allow deselection on a double-click
				optionChosen = wizardBox;
			}
		}
		
		if((posX > 75 && posX < 175) && (posY > 425 && posY < 455)) {
			if(Mouse.isButtonDown(0)) {
				optionChosen = clericBox;
			}
		}
		
		if((posX > 75 && posX < 175) && (posY > 350 && posY < 380)) {
			if(Mouse.isButtonDown(0)) {
				optionChosen = rangerBox;
			}
		}
		
		if((posX > 75 && posX < 175) && (posY > 275 && posY < 305)) {
			if(Mouse.isButtonDown(0)) {
				optionChosen = warriorBox;
			}
		}
		
		if((posX > 75 && posX < 175) && (posY > 200 && posY < 230)) {
			if(Mouse.isButtonDown(0)) {
				optionChosen = bardBox;
			}
		}
		
		//END: Setting areas where party options are clickable//
		
		if((posX > 275 && posX < 425) && (posY > 70 && posY < 120)) {	//Clickable area for Add to Party button
			if(Mouse.isButtonDown(0) && (optionChosen != temp)) {
				if (!party.isInParty(optionChosen)) {
					addToParty(optionChosen);
				}
			}
		}
			
		if((posX > 375 && posX < 525) && (posY > 70 && posY < 120)) {	//Clickable area for Remove button
			if(Mouse.isButtonDown(0) && (optionChosen != temp)) {
				if (party.isInParty(optionChosen)) {
					removeFromParty(optionChosen);
				}
			}
		}
		
		if((posX > 75 && posX < 175) && (posY > 125 && posY < 155)) { //clickable area for back button
			if(Mouse.isButtonDown(0)) {	
					sbg.enterState(20);
			}
		}
		
		if((posX > 485 && posX < 655) && (posY > 70 && posY < 120)) { //clickable area for Start Adventure
			if(Mouse.isButtonDown(0)) {	

					sbg.enterState(4);
			}
		}
		
	}
	
	public String displayStats(baseCharacter bc) {
		return "Name: " + bc.getCharacterName()
		+ "\n\nDescription: " + bc.getCharacterDesctription()
		+ "\n\nHealth: " + bc.getBaseHealth()
		+ "\n\nArmor: " + bc.getBaseArmor()
		+ "\n\nMana: " + bc.getBaseMana()
		+ "\n\nSpeed: " + bc.getBaseSpeed();
	}
	
	public void addToParty(baseCharacter bc) {
		if (!party.isInParty(bc) && (!party.isTeamFull())) {
			party.addToTeam(bc);
			System.out.println("added");
		}
	}
	
	public void removeFromParty(baseCharacter bc) {
		if(party.isInParty(bc)) {
			party.removeFromTeam(bc);
			System.out.println("removed");
		}
	}
	
	public static Team getParty() {
		return party;
	}

	public int getID() {
		return 2;
	}
	
	}	