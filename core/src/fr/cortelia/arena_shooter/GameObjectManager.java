package fr.cortelia.arena_shooter;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.badlogic.gdx.scenes.scene2d.Action;

public class GameObjectManager {
	
	private List<GameObject> gameObjects = new LinkedList<GameObject>();

	public void updateAll() {
		gameObjects.forEach(new Consumer<GameObject>() {

			@Override
			public void accept(GameObject t) {
				t.stateUpdate();
			}
			
		});
	}
	
	public void renderAll() {
		gameObjects.forEach(new Consumer<GameObject>() {

			@Override
			public void accept(GameObject t) {
				if (t instanceof IRenderable) {
					((IRenderable) t).render();				
				}
			}
			
		});
	}
	
	
	public void subcribe (GameObject go) {
		go.subscribe(this);
	}
	
	public void add (GameObject go) {
		this.gameObjects.add(go);
	}
	
	public void remove(GameObject go) {
		this.gameObjects.remove(go);
	}
	
	public void dispose(GameObject go) {
		go.dispose();
	}
	
}
