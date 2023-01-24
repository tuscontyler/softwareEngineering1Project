package battlePackage;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Level1Package.Level1Window3;
import partySelectPackage.PartyMenu;
import characterPackage.*;

public class Battle extends BasicGameState {
	int oneTime;
	
	MouseListener hasPlayerClicked;
	
	Enemy foe = new Enemy();
	Animation foeAnimation;
	
	Team party = new Team();
	
	Fightable turnOrder[] = new Fightable[4];	//holds characters and enemies
	
	Image bg;
	Music bgm;
	
	Image character1;
	Image character2;
	Image character3;
	
	Rectangle textBox;
	
	boolean battleStarted;
	boolean showingDescription;
	boolean showingCantRun;
	boolean enemyTakingAction;
	boolean enemyDefeated;
	
	boolean turnOver;
	
	String currentTarget;
	String currentOption;

	@Override
	public void init(GameContainer window, StateBasedGame sbg) throws SlickException {
		oneTime = 0;	//variable to make sure that buttons are only pressed once
		
		//Load background and bgm
		bg = new Image("images/battlebg.png");
		
		textBox = new Rectangle(80, 370, 640, 200);

		bgm = new Music("music/BattleSong2.wav");
		
		battleStarted = false;	
		showingDescription = false;
		showingCantRun = false;
		enemyTakingAction = false;
		enemyDefeated = false;
		
		currentTarget = "";
		
		//Choose which enemy spawns. Load their animation.
		foeAnimation = foe.getEnemyAnimation();
		
		//TODO: Get the player's chosen party
		//Team party = PartyMenu.getParty();

		party.addToTeam(new wizard());	//FOR TESTING ONLY
		party.addToTeam(new cleric());
		party.addToTeam(new ranger());
		
		character1 = party.getFirstMember().getArt();
		character2 = party.getSecondMember().getArt();
		character3 = party.getThirdMember().getArt();
		
		//Determine movement order by comparing everyone's speed stats
		turnOrder = determineTurnOrder(foe, party.getFirstMember(), party.getSecondMember(), party.getThirdMember());
		
		turnOver = false;
		
		//System.out.println(party.getFirstMember().getName() + ", " + party.getSecondMember().getName() + ", " + party.getThirdMember().getName());
		
		//System.out.println("The turn order is " + turnOrder[0].getName() +  turnOrder[1].getName() + turnOrder[2].getName() + turnOrder[3].getName());

	}

	@Override
	public void render(GameContainer window, StateBasedGame sbg, Graphics g) throws SlickException {
		battleStarted = true;
			
		//Render background image and music
		bg.draw(0,0);
		
		//Render black rectangle on bottom of screen that text will go on top of
		g.setColor(Color.black);
		g.fill(textBox);
		g.draw(textBox);
		
		//Render 3 party members
		character1.draw(675, 50);
		character2.draw(675, 150);
		character3.draw(675, 250);
		
		//Render everyone's health as a fraction
		g.drawString("Health: " + party.getFirstMember().getCurrentHealth() + " / " + party.getFirstMember().getBaseHealth(), 500, 75);
		g.drawString("Health: " + party.getSecondMember().getCurrentHealth() + " / " + party.getSecondMember().getBaseHealth(), 500, 175);
		g.drawString("Health: " + party.getThirdMember().getCurrentHealth() + " / " + party.getThirdMember().getBaseHealth(), 500, 275);
		g.drawString("Health: " + foe.getCurrentEnemyHealth() + " / " + foe.getMaxEnemyHealth(), 250, 200);
		
		//Render party members' mana
		g.setColor(Color.blue);
		g.drawString("Mana: " + party.getFirstMember().getCurrentMana() + " / " + party.getFirstMember().getBaseMana(), 500, 100);
		g.drawString("Mana: " + party.getSecondMember().getCurrentMana() + " / " + party.getSecondMember().getBaseMana(), 500, 200);
		g.drawString("Mana: " + party.getThirdMember().getCurrentMana() + " / " + party.getThirdMember().getBaseMana(), 500, 300);
		
		//Render enemy image or animation
		foeAnimation.draw(100,150);
		
		//Render text that says "___ wants to fight!" for a few seconds
		g.setColor(Color.white);
		g.drawString(foe.getEnemyName() + " wants to fight!", 275, 400);
		
		//Render choice buttons (Fight, Magic, Item, Look, Flee) IF it is player's turn and nothing else is on screen
		
		if (enemyDefeated) {
			showVictory(g);
			battleStarted = false;
			bgm.stop();
			Level1Window3.setEnemy(true);
		}
		
		else if (showingDescription) {
			showDescription(g);
		}
		
		else if (enemyTakingAction) {
			showEnemyAction(g);
		}
		
		else {
			g.drawString("FIGHT", 125, 480);
			g.drawString("MAGIC", 250, 480);
			g.drawString("ITEM", 375, 480);
			g.drawString("LOOK", 500, 480);
			g.drawString("FLEE", 625, 480);
		}
		
		battleCycle(turnOrder, sbg);
	}

	@Override
	public void update(GameContainer window, StateBasedGame sbg, int delta) throws SlickException {
		if (battleStarted && !bgm.playing()) {
			bgm.loop();
		}
		
		//Update animations
		foeAnimation.update(delta);
		
	}
	
	public void battleCycle(Fightable[] turnOrder, StateBasedGame sbg) {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		//System.out.println("X: " + posX + "   Y: " + posY);
		
		int currentTurn = 0;
		
		while (currentTurn < 3) {
			
			System.out.println("It is " + turnOrder[0].getName() + "'s turn");
			
			/*
			if (turnOver) {
				System.out.println("turn is over");
			}
			*/
			
			if (!turnOrder[currentTurn].isCharacter()) {	//runs if it is currently the enemy's turn
				
				enemyTakingAction = true;
				
				if(enemyTakingAction) {
					takeTurn((Enemy)turnOrder[currentTurn]);
					enemyTakingAction = false;
				}
				
				
			}
			
			//========FIGHT option========
			
			else if((posX > 110 && posX < 180) && (posY > 95 && posY < 125)) { //clickable area for FIGHT
					if(Mouse.isButtonDown(0) && oneTime < 1) {
						turnOrder[currentTurn].attack(foe, turnOrder[currentTurn].getStrength());
						
						oneTime++;
					}
				}
				
				//turnOver = true;
				
				if (foe.isDefeated()) {
					enemyDefeated = true;
				}
				
				if(!Mouse.isButtonDown(0)) 
				{
					oneTime = 0;
				}
				
			//========MAGIC option========
			
			else if((posX > 240 && posX < 310) && (posY > 95 && posY < 125)) { //clickable area for MAGIC
				if(Mouse.isButtonDown(0) && oneTime < 1) {
					if (((baseCharacter)turnOrder[currentTurn]).getCurrentMana() >= 10) {		//Cast Fightable object to baseCharacter because only they have mana
						
						turnOrder[currentTurn].attack(foe, turnOrder[currentTurn].getStrength() * 2);	//Mana attacks are more powerful than regular attacks; x2 multiplier
						((baseCharacter)turnOrder[currentTurn]).setCurrentMana( ((baseCharacter)turnOrder[currentTurn]).getCurrentMana() - 10);			//Decrease current mana by 10
					
						oneTime++;
					}
					
				}
				
				//turnOver = true;
				
				if (foe.isDefeated()) {
					enemyDefeated = true;
					
				}
				
				if(!Mouse.isButtonDown(0)) {
					oneTime = 0;
				}
			}
				
			//========FLEE option========
				
			else if((posX > 615 && posX < 670) && (posY > 95 && posY < 125)) { //clickable area for FLEE
					if(Mouse.isButtonDown(0) && oneTime < 1) {
						
						if (foe.canBeFledFrom) {	//running away
							bgm.stop();
							battleStarted = false;
							sbg.enterState(7);	//return to level
						}
						
						else {	//not being allowed to run
							showCantRun(null);
						}
						
						
					}
				}	
			
			//========LOOK option========
			
			if((posX > 490 && posX < 550) && (posY > 95 && posY < 125)) { //clickable area for LOOK
				if(Mouse.isButtonDown(0)) {
					showingDescription = true;
				}
			}
			
			//========BACK button that appears when the LOOK window is up
			
			if((posX > 350 && posX < 445) && (posY > 75 && posY < 105)) { //clickable area for BACK
				if(Mouse.isButtonDown(0) && oneTime < 1) {
					showingDescription = false;
				}
				
				if(!Mouse.isButtonDown(0)) {
					oneTime = 0;
				}
			}
			
			//========BACK TO LEVEL button that appears on the victory screen
			
			if((posX > 540 && posX < 675) && (posY > 75 && posY < 105)) { //clickable area for BACK TO LEVEL
				if(Mouse.isButtonDown(0) && !showingDescription ) {
					sbg.enterState(4);	//return to level
					
				}
				//party.addCurrency(foe.dropGold());
			}		
			
			currentTurn++;
			
		}	//END of while loop
	}
	
	public Fightable[] determineTurnOrder(Enemy foe, baseCharacter first, baseCharacter second, baseCharacter third) {
		int foeSpeed = foe.getSpeed();
		int firstSpeed = first.getSpeed();
		int secondSpeed = second.getSpeed();
		int thirdSpeed = third.getSpeed();
		
		//create array of ints
		
		int speeds[] = {foeSpeed, firstSpeed, secondSpeed, thirdSpeed};
		
		//System.out.println("Speeds are " + foeSpeed + " " + firstSpeed + " " + secondSpeed + " " + thirdSpeed);
		
		int temp = -1; 
		
		//sort ints in speed array from highest to lowest
		
		for (int i = 0; i < 4; ++i) {
			for (int j = i + 1; j < 4; ++j) {
				if (speeds[j] > speeds[i]) {
					temp = speeds[i];
					speeds[i] = speeds[j];
					speeds[j] = temp;
				}
			}
		}
			
		//assign objects to turnOrder array based on speed
		
		for (int k = 0; k < 4; ++k) {
			if (speeds[k] == foeSpeed) {
				turnOrder[k] = foe;
			}
			else if (speeds[k] == firstSpeed) {
				turnOrder[k] = first;
			}
			else if (speeds[k] == secondSpeed) {
				turnOrder[k] = second;
			}
			else if (speeds[k] == thirdSpeed) {
				turnOrder[k] = third;
			}
		}
		
		return turnOrder;
	}
	
	//========HELPER METHODS========
	
	public void showDescription(Graphics g) {
		g.drawString(foe.getEnemyDescription(), 250, 450);
		g.drawString("BACK", 375, 500);
	}
	
	public void showVictory(Graphics g) {
		g.drawString("You win! You got " + foe.dropGold() + " gold.", 275, 450);
		g.drawString("BACK TO LEVEL", 550, 500);
		
	}
	
	public void showCantRun(Graphics g) {
		g.drawString("You can't run away!", 250, 450);
		g.drawString("BACK", 375, 500);
	}
	
	public void showEnemyAction(Graphics g) {
		g.drawString(foe.getEnemyName() + " attacks " + currentTarget + "!", 275, 450);
	}
	
	public void showTurn(Graphics g, Fightable f) {
		g.drawString("It is " + f.getName() + "'s turn.", 200, 450);
	}
	
	public void takeTurn(Enemy foe) {
		int positionToAttack = foe.chooseTarget();
		
		if (positionToAttack == 0) {
			foe.attack((Fightable)party.getFirstMember(), foe.getStrength());
			currentTarget = party.getFirstMember().getCharacterName();
		}
		else if (positionToAttack == 1) {
			foe.attack((Fightable)party.getSecondMember(), foe.getStrength());
			currentTarget = party.getSecondMember().getCharacterName();
		}
		else if (positionToAttack == 2) {
			foe.attack((Fightable)party.getThirdMember(), foe.getStrength());
			currentTarget = party.getThirdMember().getCharacterName();
		}
		
		enemyTakingAction = false;
	}

	@Override
	public int getID() {
		return 5;
	}

}
