package fr.cortelia.arena_shooter.item;

import fr.cortelia.arena_shooter.player.AbstractPlayer;

public class Weapon {
	
	private String id; 
	private String name; 
	private String weaponType; 
	
	private float baseDamage;
	private float attackCD;
	
	private AbstractPlayer owner;
	
	/////////////////////
	// Getter / Setter
	/////////////////////
	
	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public String getWeaponType() {
		return this.weaponType;
	}

	public float getBaseDamage() {
		return this.baseDamage;
	}

	public float getAttackCD() {
		return this.attackCD;
	}
	
	public AbstractPlayer getOwner() {
		return this.owner;
	}
	
	public void setOwner(AbstractPlayer player) {
		this.owner = player;
	}
	
	/////////////////////
	// CONSTRUCTORS
	/////////////////////	
	
	public Weapon(String name, String weaponType, float baseDamage, float attackCD, AbstractPlayer owner) {
		this.name = name;
		this.weaponType = weaponType;
		this.baseDamage = baseDamage;
		this.attackCD = attackCD;
		this.owner = owner;
	}
	
	/////////////////////
	// METHODS
	/////////////////////
	
	public void attack(float angle) {
		System.out.println("shooting with "+this.name+" aiming at "+angle+" degrees");
	}

	public float dealDamage() {
		return this.baseDamage;
	}
	

}
