package fr.cortelia.arena_shooter.item;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.GameObject;
import fr.cortelia.arena_shooter.IRenderable;
import fr.cortelia.arena_shooter.player.AbstractPlayer;

public class Projectile extends GameObject implements IRenderable {

	/////////////////////
	// Properties
	/////////////////////
	
	private Weapon origin;
	
	private Vector2 position;
	private Vector2 target;
	
	private float maxDistance = 100;
	private float movementSpeed = 1;
	
	private Sprite sprite;
	
	/////////////////////
	// Fields
	/////////////////////
	
	/////////////////////
	// Getter / Setter
	/////////////////////
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
		
	}

	public Vector2 getTarget() {
		return target;
	}

	public void setTarget(Vector2 target) {
		this.target = target;
	}

	public Weapon getOrigin() {
		return origin;
	}

	public float getMaxDistance() {
		return maxDistance;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	/////////////////////
	// Constructors
	/////////////////////
	
	Projectile(Weapon origin, Sprite sprite){
		this(origin, sprite, 100, 1);
	}
	
	Projectile(Weapon origin, Sprite sprite, float maxDistance, float movementSpeed){
		this.origin = origin;
		this.maxDistance = maxDistance;
		this.movementSpeed = movementSpeed;
		this.sprite = new Sprite(sprite);
	}
	
	public Projectile(Projectile p, Vector2 position, float angle) {
		this(p.getOrigin(), p.getSprite(), p.getMaxDistance(), p.getMovementSpeed());
		this.position = position;
		this.target = defineTarget(angle);
	}
	
	/////////////////////
	// Methods
	/////////////////////
	
	// TODO check if destination is reach
	private boolean isMaxRange() {
		return false;
	}
	
	public boolean fireAt(AbstractPlayer owner) {
		owner.getGameOjectManager().subcribe( new Projectile(this, owner.getPosition(), owner.getAngle()) );
		return true;
	}
	
	private Vector2 defineTarget(float angle) {
		return new Vector2(this.position).setAngle(angle).setLength(this.maxDistance);
	}
	
	/////////////////////
	// Overrides
	/////////////////////
	
	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateUpdate() {
		// TODO Auto-generated method stub

	}

	/////////////////////
	// Static Methods
	/////////////////////
	
}
