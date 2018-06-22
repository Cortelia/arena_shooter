package fr.cortelia.arena_shooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;

import fr.cortelia.arena_shooter.player.Player;
import fr.cortelia.arena_shooter.player.PlayerInputProcessor;
import fr.cortelia.arena_shooter.utility.Vector2D;

public class ArenaShooter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameObjectManager gom;
	
	ShapeRenderer shapeRenderer;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("../core/assets/badlogic.jpg");
		
		PlayerInputProcessor controller = new PlayerInputProcessor();
		Gdx.input.setInputProcessor(controller);
		
		this.gom = new GameObjectManager();
		
		Player p = new Player(controller);
		p.subscribe(this.gom);

		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		this.gom.updateAll();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		this.gom.renderAll();
		
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
		
		
		
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
