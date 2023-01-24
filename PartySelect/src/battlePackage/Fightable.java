package battlePackage;

public interface Fightable {
	public int getSpeed();
	public String getName();
	public int getStrength();
	
	public boolean isDefeated();
	public boolean isCharacter();
	
	public int getCurrentHealth();
	public void setHealth(int amount);
	
	public void attack(Fightable target, int damage);
}
