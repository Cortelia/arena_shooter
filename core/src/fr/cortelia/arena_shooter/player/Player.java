package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue.Triangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import fr.cortelia.arena_shooter.ArenaShooter;
import fr.cortelia.arena_shooter.IRenderable;

public class Player extends AbstractPlayer implements IRenderable{

	private float angle;

	private SpriteBatch batch;
	private Texture img;
	private Sprite sprite;
	
	private PlayerInputProcessor controller;

	public Player(PlayerInputProcessor controller) {
		this(new Vector2(0,0), controller);
	}
	
	public Player(Vector2 position, PlayerInputProcessor controller) {
		this.position = position;
		this.controller = controller;
		batch = new SpriteBatch();
		img = new Texture("../core/assets/badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setSize(this.getWidth(), this.getHeigh());
		sprite.setOrigin(this.getOriginX(), this.getOriginY());
	}
	
	@Override
	public void move() {
		this.position = this.calculateMovement(position);
		this.sprite.setPosition(this.position.x, this.position.y);
		// TODO
		angle = MathUtils.radiansToDegrees*this.calculateOrientation();
		//System.out.println("angle : "+ angle);
		//System.out.println("origin : ("+ this.getOriginX() + " , "+this.getOriginY()+")");
		sprite.setRotation(angle);
	}
	
	private Vector2 calculateMovement(Vector2 position) {
		float verticalMovement = 0;
		float horizontalMovement = 0;
		
		if (this.controller.isMovingFoward) verticalMovement += this.MovementSpeed;
		if (this.controller.isMovingBackward) verticalMovement += -this.MovementSpeed;
		if (this.controller.isMovingRight) horizontalMovement += this.MovementSpeed;
		if (this.controller.isMovingLeft) horizontalMovement += -this.MovementSpeed;
		return position.add(horizontalMovement, verticalMovement);
	}
	
	private float calculateOrientation() {
		return MathUtils.atan2(this.controller.mousePosition.y-this.getOriginY(), this.controller.mousePosition.x-this.getOriginX());
		//return (float) Math.atan2(this.controller.mousePosition.y, this.controller.mousePosition.x);
	}

	public boolean isFiring() {
		return this.controller.isFiring;
	}
	
	@Override
	public void shoot() {
		// TODO implementing shoot using Weapon weaponEquiped.shoot()
	}
	@Override
	public void receiveDamage() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void stateUpdate() {
		if (this.isFiring()) this.shoot();
		this.move();
		
		this.calculateOrientation();
	}
	
	@Override
	public void render() {	
		batch.setProjectionMatrix(ArenaShooter.cam.combined);

		float X = this.position.x;
		float Y = this.position.y;
		
		batch.begin();
		
		sprite.draw(batch);
		
		batch.end();

	}

	
	
	
}
