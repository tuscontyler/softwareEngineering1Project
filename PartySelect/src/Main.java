import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Level1Package.*;
import Level2Package.*;
import Level3Package.*;
import battlePackage.Battle;
import battlePackage.BronzeDragonFight;
import battlePackage.GoldenDragonFight;
import battlePackage.SilverDragonFight;
import characterPackage.inventoryMenu;
import characterPackage.merchantMenu;
import partySelectPackage.PartyMenu;
import startMenuPackage.*;

public class Main extends StateBasedGame {

	public Main(String title) {
		super(title);
		
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main("Golden Dragon Dungeon"));
		app.setDisplayMode(800, 600, false);
		app.setShowFPS(false);
		app.start();
	}

	public void initStatesList(GameContainer window) throws SlickException {
		this.addState(new StartMenu()); //ID = 1
		this.addState(new difficultyScreen());// ID= 20
		this.addState(new inventoryMenu());// ID= 100
		this.addState(new PartyMenu());	//ID = 2
		this.addState(new SettingsMenu()); //ID = 3
		this.addState(new Level1Window1()); //ID = 4
		this.addState(new Battle()); //ID = 5
		this.addState(new Level1Window2()); //ID = 6
		this.addState(new Level1Window3()); //ID = 7
		this.addState(new Level1Window4()); //ID = 8
		this.addState(new merchantMenu()); //ID = 12
		this.addState(new L2_W1()); //ID = 15
		this.addState(new L2_W2()); //ID = 16
		this.addState(new L2_W3()); //ID = 17
		this.addState(new L2_W4()); //ID = 18
		this.addState(new L2_W5()); //ID = 19
		this.addState(new L2_W6()); //ID = 21
		this.addState(new L3_W1()); //ID = 22		
		this.addState(new L3_W2()); //ID = 23	
		this.addState(new L3_W3()); //ID = 24	
		this.addState(new L3_W4()); //ID = 25	
		this.addState(new L3_W5()); //ID = 26	
		this.addState(new L3_W6()); //ID = 27	
		this.addState(new L3_W7()); //ID = 28
		this.addState(new L3_W8()); //ID = 29	
		this.addState(new BronzeDragonFight()); //ID = 111
		this.addState(new SilverDragonFight()); //ID = 222
		this.addState(new GoldenDragonFight()); //ID = 333

	}

}
