package fr.cortelia.arena_shooter;

public abstract class GameObject {
	
	// UNCHECKED peut �tre non n�cessaire
	private GameObjectManager manager;
	
	public abstract void stateUpdate() ;
	
	public GameObject subscribe(GameObjectManager gom) {
		if (manager != null) {
			manager.remove(this);
		}
		this.manager = gom;
		return this;
	}
	
	public GameObject dispose () {
		manager = null;
		return this;
	}
}
