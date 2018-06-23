package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor{
	
	public boolean isMovingFoward = false;
	public boolean isMovingLeft = false;
	public boolean isMovingBackward = false;
	public boolean isMovingRight = false;
	
	public boolean isFiring = false;

	@Override
	public boolean keyDown(int keycode) {
		
		switch (keycode) {
		case Keys.UP:
			isMovingFoward = true;
			break;
		case Keys.DOWN:
			isMovingBackward = true;
			break;
		case Keys.LEFT:
			isMovingLeft = true;
			break;
		case Keys.RIGHT:
			isMovingRight = true;
			break;
		case Keys.SPACE:
			isFiring = true;
			break;
			
		default:
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch (keycode) {
		case Keys.UP:
			isMovingFoward = false;
			break;
		case Keys.DOWN:
			isMovingBackward = false;
			break;
		case Keys.LEFT:
			isMovingLeft = false;
			break;
		case Keys.RIGHT:
			isMovingRight = false;
			break;

		default:
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// should be not used
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
