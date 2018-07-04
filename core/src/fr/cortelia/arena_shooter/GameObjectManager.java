package fr.cortelia.arena_shooter;

import java.util.TreeSet;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObjectManager {
	
	private TreeSet<GameObject> gameObjects = new TreeSet<GameObject>();
	private TreeSet<IRenderable> renderables = new TreeSet<IRenderable>();
	
	private SpriteBatch batch = new SpriteBatch();

	public void updateAll() {
		gameObjects.forEach( (go) ->  {go.stateUpdate();}) ;
	}
	
	public void renderAll() {
		batch.begin();
		batch.setProjectionMatrix(ArenaShooter.cam.combined);
		renderables.forEach( (go) -> go.render(batch) );
		batch.end();
	}
	
	
	public GameObjectManager subcribe (GameObject go) {
		if (this.gameObjects.add(go.subscribe(this)) && go instanceof IRenderable) {
			this.renderables.add((IRenderable)go);
		}
		return this;
	}
	
	public GameObjectManager unsubcribe (GameObject go) {
		this.gameObjects.remove(go);
		return this;
	}
	
	public GameObjectManager remove(GameObject go) {
		if (go instanceof IRenderable) this.renderables.remove((IRenderable) go);
		return this.unsubcribe(go.dispose());
	}
	
	public void removeAll() {
		gameObjects.forEach((go) -> {
			this.remove(go);
		});
	}
	
	public void dispose() {
		this.removeAll();
		this.batch.dispose();
	}
	
}
