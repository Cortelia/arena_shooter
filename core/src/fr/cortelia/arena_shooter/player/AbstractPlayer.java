package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.GameObject;


public abstract class AbstractPlayer extends GameObject {
	
	protected String name;
	
	protected Vector2 origin = new Vector2(20,20);
	
	protected Vector2 position;
	
	protected int hitpoints;
	protected int armor;

	
	
	protected float MovementSpeed = 0.5f;
	
	public Vector2 getOrigin() {
		return this.origin.add(this.position);
	}
	
	public float getOriginX() {
		return this.origin.x+this.position.x;
	}
	
	public float getOriginY() {
		return this.origin.y+this.position.y;
	}
	
	protected void setOrigin(float x, float y) {
		this.origin.set(x, y);
	}
	
	public float getWidth() {
		return this.origin.x*2;
	}
	
	public float getHeigh() {
		return this.origin.y*2;
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
	
	public String getName () {
		return this.name;
	}
	
	public int getHitpoints () {
		return this.hitpoints;
	}
	
	public int getArmor () {
		return this.armor;
	}
	
	
	
	public abstract void move() ;
	
	public abstract void shoot() ;
	
	public abstract void receiveDamage () ;

}
