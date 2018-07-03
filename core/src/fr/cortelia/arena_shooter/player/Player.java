package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import fr.cortelia.arena_shooter.ArenaShooter;
import fr.cortelia.arena_shooter.IRenderable;

public class Player extends AbstractPlayer {
	
	private PlayerInputProcessor controller;

	public boolean isFiring() {
		return this.controller.isFiring;
	}
	
	public Player(PlayerInputProcessor controller) {
		this(new Vector2(Vector2.Zero), controller);
	}
	
	public Player(Vector2 position, PlayerInputProcessor controller) {
		super("player", new Texture("../core/assets/badlogic.jpg"), position);
		this.controller = controller;
	}
	
	@Override
	protected void move() {
		float verticalMovement = 0;
		float horizontalMovement = 0;
		
		if (this.controller.isMovingFoward) verticalMovement += this.MovementSpeed;
		if (this.controller.isMovingBackward) verticalMovement += -this.MovementSpeed;
		if (this.controller.isMovingRight) horizontalMovement += this.MovementSpeed;
		if (this.controller.isMovingLeft) horizontalMovement += -this.MovementSpeed;
		this.addPosition(horizontalMovement, verticalMovement);
	}

	@Override
	protected void rotate() {
		this.setAngle(MathUtils.radiansToDegrees*MathUtils.atan2(this.controller.mousePosition.y-this.getCenterY(), this.controller.mousePosition.x-this.getCenterX()) );
	}

	@Override
	protected void shoot() {
		// TODO implementing shoot using Weapon weaponEquiped.shoot()
	}
	
	@Override
	public void receiveDamage() {
		// TODO Auto-generated method stub
	}

	

}
