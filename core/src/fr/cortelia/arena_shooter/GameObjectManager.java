package fr.cortelia.arena_shooter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.scenes.scene2d.Action;

public class GameObjectManager {
	
	private List<GameObject> gameObjects = new LinkedList<GameObject>();

	public void updateAll() {
		gameObjects.forEach( (go) ->  {go.stateUpdate();}) ;
	}
	
	public void renderAll() {
		gameObjects.forEach( (go) -> {
				if (go instanceof IRenderable) {
					((IRenderable) go).render();				
				}
		});
	}
	
	
	public GameObjectManager subcribe (GameObject go) {
		this.add(go.subscribe(this));
		return this;
	}
	
	public void add (GameObject go) {
		this.gameObjects.add(go);
	}
	
	public void remove(GameObject go) {
		this.gameObjects.remove(go);
	}
	
	public GameObjectManager dispose(GameObject go) {
		this.remove(go.dispose());
		return this;
	}
	
	public void disposeAll() {
		gameObjects.forEach((go) -> {
			this.dispose(go);
		});
	}
	
}
