abstract class Obstacle extends Box {
	public abstract String toString();
	protected Obstacle(){
		super();
	}
	protected Obstacle(Position p){
		super(p);
	}
}