package fr.cortelia.arena_shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import fr.cortelia.arena_shooter.player.Player;
import fr.cortelia.arena_shooter.player.PlayerInputProcessor;

public class ArenaShooter extends ApplicationAdapter {
	
	public GameObjectManager gom;
	public final static OrthographicCamera cam = new OrthographicCamera();
	
	@Override
	public void create () {
		
		PlayerInputProcessor controller = new PlayerInputProcessor();
		Gdx.input.setInputProcessor(controller);
		
		this.gom = new GameObjectManager();
		
		gom.subcribe(new Player(controller));
		
	}
	
	

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
		cam.setToOrtho(true, width, height);
	}



	@Override
	public void render () {
		cam.update();
		
		this.gom.updateAll();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.gom.renderAll();
		
	}
	
	@Override
	public void dispose () {
		
	}
}
