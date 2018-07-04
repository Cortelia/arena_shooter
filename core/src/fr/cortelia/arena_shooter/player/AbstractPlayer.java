package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.ArenaShooter;
import fr.cortelia.arena_shooter.GameObject;
import fr.cortelia.arena_shooter.IRenderable;
import fr.cortelia.arena_shooter.item.Weapon;


public abstract class AbstractPlayer extends GameObject implements IRenderable {
	
	// TODO unimplemented id generation and usage
	protected String id;
	protected String name;
	
	protected float width;
	protected float heigh;
	protected Vector2 position = new Vector2(Vector2.Zero);
	protected float angle;
	
	protected Sprite sprite;
	
	protected int hitpoints;
	protected int armor;
	protected float MovementSpeed = 0.5f;
	
	protected Weapon equipedWeapon;
	
	/////////////////////
	// Getter / Setter
	/////////////////////
	
	/**
	 * get Player center position x coordinate
	 * @return float
	 */
	public float getCenterX() {
		return this.sprite.getOriginX()+this.getX();
	}
	
	/**
	 * get Player center position y coordinate
	 * @return float
	 */
	public float getCenterY() {
		return this.sprite.getOriginY()+this.getY();
	}
	
	/**
	 * get Player width
	 * @return float
	 */
	public float getWidth() {
		return this.width;
	}
	
	/**
	 * get Player heigh
	 * @return float
	 */
	public float getHeigh() {
		return this.heigh;
	}
	
	/**
	 * set Player dimension using Vector2
	 * @param dimension Vector2
	 */
	public void setDimension(Vector2 dimension) {
		this.setDimension(dimension.x, dimension.y);
	}
	
	/**
	 * set Player dimension 
	 * @param width float
	 * @param heigh float
	 */
	public void setDimension(float width, float heigh) {
		this.width = width;
		this.heigh = heigh;
		this.setSpriteDimension(width, heigh);
	}
	
	/**
	 * get Player x coordinate
	 * @return float
	 */
	public float getX () {
		return this.position.x;
	}
	
	/**
	 * get Player y coordinate
	 * @return float
	 */
	public float getY () {
		return this.position.y;
	}
	
	/**
	 * get Player Vector2 coordinate
	 * @return Vector2
	 */
	public Vector2 getPosition () {
		return this.position;
	}
	
	/**
	 * set Player coordinate using Vector2
	 * @param position Vector2
	 */
	public void setPosition (Vector2 position) {
		this.setPosition(position.x, position.y);
	}
	
	/**
	 * set Player coordiante
	 * @param x float
	 * @param y float
	 */
	public void setPosition(float x, float y) {
		this.position.set( x, y);
		this.setSpritePosition(x, y);
	}
	
	/**
	 * add a vector2 to Player position
	 * @param moovement Vector2
	 */
	public void addPosition(Vector2 moovement) {
		this.addPosition(moovement.x, moovement.y);
	}
	
	/**
	 * add x and y coordinates to player position
	 * @param x float
	 * @param y float
	 */
	public void addPosition(float x, float y) {
		this.position.add(x,y);
		this.setSpritePosition(this.position);
	}
	
	protected void setSpritePosition(Vector2 position) {
		this.setSpritePosition(position.x, position.y);
	}
	
	protected void setSpritePosition(float x, float y) {
		if (this.sprite != null) this.sprite.setPosition(x, y);
	}
	
	protected void setSpriteDimension(float width, float heigh) {
		this.sprite.setSize(width, heigh);
		this.sprite.setOriginCenter();
	}
	
	/**
	 * set Player orientation angle based
	 * @param degrees float
	 */
	public void setAngle(float degrees) {
		this.sprite.setRotation(degrees+90);
	}
	
	/**
	 * return player orientation as float degrees
	 * @return flaot
	 */
	public float getAngle () {
		return this.sprite != null ? this.sprite.getRotation() : 0;
	}
	
	/**
	 * return Player name
	 * @return String
	 */
	public String getName () {
		return this.name;
	}
	
	/**
	 * return Player hitpoints
	 * @return int
	 */
	public int getHitpoints () {
		return this.hitpoints;
	}
	
	/**
	 * return Player armor
	 * @return int
	 */
	public int getArmor () {
		return this.armor;
	}
	
	public Weapon getEquipedWeapon() {
		return this.equipedWeapon;
	}
	
	public void setEquipedWeapon(Weapon weapon) {
		this.equipedWeapon = weapon;
		weapon.setOwner(this);
	}
	
	// Constructors
	
	protected AbstractPlayer(String name, Texture img) {
		this(name, img, new Vector2(Vector2.Zero));
	}
	
	protected AbstractPlayer(String name, Texture img, Vector2 position) {
		this(name, img, position, 0);
	}
	
	protected AbstractPlayer(String name, Texture img, Vector2 position, float angle) {
		this.name = name;
		this.sprite = new Sprite(img);
		this.sprite.flip(false, true);
		this.setDimension(40, 40);
		this.setPosition(position);
		this.setAngle(angle);
	}
	
	/////////////////////
	// Default Methods
	/////////////////////
	
	/**
	 * any action from the player should be done here.
	 */
	protected void shoot() {
		this.equipedWeapon.attack(this.angle);
	}
	
	/////////////////////
	// Override Methods
	/////////////////////
	
	/**
	 * update Abstract player by calling moove, rotate and shoot methods
	 * this method is called by the suscribed gameObjectManager
	 */
	@Override
	public void stateUpdate() {
		move();
		rotate();
		shoot();
	}
	/**
	 * render graphics
	 * called by the suscribed gameObjectManager
	 */
	@Override
	public void render(SpriteBatch batch) {	
		sprite.draw(batch);
	}
	
	/////////////////////
	// Abstract Methods
	/////////////////////
	
	/**
	 * any update about the position of the Player should be done here
	 */
	protected abstract void move();
	
	/**
	 * any update about the orientation of the Player should be done here
	 */
	protected abstract void rotate();
	
	/**
	 * define the logic when the player receive damage.
	 */
	public abstract void receiveDamage () ;
	
	// Static Methods
	
}
