abstract class Obstacle extends Box implements Collision {
	public abstract String toString();
	protected Obstacle(){
		super();
	}
	protected Obstacle(Position p){
		super(p);
	}
	public abstract void react(Character c);
}