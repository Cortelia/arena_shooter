package fr.cortelia.arena_shooter;

public abstract class GameObject {
	
	// UNCHECKED peut etre non nécessaire
	private GameObjectManager manager;
	
	public abstract void stateUpdate() ;
	
	public GameObjectManager getGameOjectManager() {
		return this.manager;
	}
	
	public GameObject subscribe(GameObjectManager gom) {
		if (manager != null) {
			manager.unsubcribe(this);
		}
		this.manager = gom;
		return this;
	}
	
	public GameObject dispose () {
		manager = null;
		return this;
	}
}
