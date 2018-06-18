package fr.cortelia.arena_shooter.utility;

import com.badlogic.gdx.math.Vector2;

public class Vector2D extends Vector2 {
	
	public float getX() {
		return this.x;
	}
	
	public void setX(float value) {
		this.x = value;
	}
	
	public float gety() {
		return this.y;
	}
	
	public void sety(float value) {
		this.y = value;
	}
	
	private Vector2D() {}
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D(Vector2D v) {
		this.set(v);
	}
	
	public Vector2D set (Vector2D v) {
		return this.set(v.x, v.y);
	}
	
	public Vector2D set (float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public float length() {
		return super.len();
	}
	
	public static float length(float x, float y) {
		return Vector2.len(x, y);
	}
	
	
	public Vector2D substract(Vector2D v) {
		return this.substract(v.x, v.y);
	}
	
	public Vector2D substract(float x, float y) {
		this.x -= x;
		this.y -= y;
		return this;
	}
	
	public Vector2D add (Vector2D v) {
		return this.add(v.x, v.y);
	}
	
	public Vector2D add (float x, float y) {
		this.x += x;
		this.y += y;
		return this;
	}
	
	public Vector2D setZero () {
		return this.set(0, 0);
	}
	
	
	
}
