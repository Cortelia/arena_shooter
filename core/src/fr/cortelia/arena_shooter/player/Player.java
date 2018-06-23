package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.IRenderable;

public class Player extends AbstractPlayer implements IRenderable{

	private PlayerInputProcessor controller;

	public Player(PlayerInputProcessor controller) {
		this(new Vector2(0,0), controller);
	}
	
	public Player(Vector2 position, PlayerInputProcessor controller) {
		this.position = position;
		this.controller = controller;
	}
	
	@Override
	public void move() {
		this.position = this.calculateMovement(position);
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
	}
	
	@Override
	public void render() {
		ShapeRenderer shapeRenderer = new ShapeRenderer();
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(0, 1, 1, 1);
		shapeRenderer.rect(this.position.x, this.position.y, 10, 10);
		shapeRenderer.end();
	}

	
	
	
}
