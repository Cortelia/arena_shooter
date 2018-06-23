package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.GameObject;


public abstract class AbstractPlayer extends GameObject {
	
	protected String name;
	
	protected int hitpoints;
	protected int armor;

	protected Vector2 position;
	
	protected float MovementSpeed = 0.25f;
	
	public String getName () {
		return this.name;
	}
	
	public int getHitpoints () {
		return this.hitpoints;
	}
	
	public int getArmor () {
		return this.armor;
	}
	
	public float getX () {
		return this.position.x;
	}
	
	public float getY () {
		return this.position.y;
	}
	
	public void setPosition (Vector2 position) {
		// TODO check if position is in the game border
		this.position = position;
	}
	
	public Vector2 getPosition () {
		return this.position;
	}
	
	public abstract void move() ;
	
	public abstract void shoot() ;
	
	public abstract void receiveDamage () ;

}
