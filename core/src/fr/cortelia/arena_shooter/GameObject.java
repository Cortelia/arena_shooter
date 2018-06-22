package fr.cortelia.arena_shooter;

public abstract class GameObject {
	
	private GameObjectManager gom;
	
	public abstract void stateUpdate() ;
	
	public void subscribe(GameObjectManager gom) {
		gom.add(this);
		this.gom = gom;
	}
	
	public void dispose () {
		gom.remove(this);
	}
}
