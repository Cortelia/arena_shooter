package fr.cortelia.arena_shooter.player;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class PlayerInputProcessor implements InputProcessor{
	
	public boolean isMovingFoward = false;
	public boolean isMovingLeft = false;
	public boolean isMovingBackward = false;
	public boolean isMovingRight = false;
	
	public boolean isFiring = false;
	public boolean hasFired = false;

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
		// TODO Auto-generated method stub
		System.out.println("Controller keyTyped : "+character);
		
		
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		System.out.println("Controller touchDown : "+pointer + " = "+button+" ( "+screenX+","+screenY+" )");
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		System.out.println("Controller touchUp : "+pointer + " = "+button+" ( "+screenX+","+screenY+" )");
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		System.out.println("Controller keyUp : "+pointer + " ( "+screenX+","+screenY+" )");
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		//System.out.println("Controller mouseMoved : ( "+screenX+","+screenY+" )");
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Controller scrolled : "+amount);
		return false;
	}

}
