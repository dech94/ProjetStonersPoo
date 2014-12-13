import java.util.Iterator;

abstract class Box {
	protected Position p;
	protected Box(Position p){
		this.p = new Position (p);
	}
	protected Box(){
		this.p=new Position();
	}
	public abstract String toString();
	public abstract void react(Character box);
	public void Move() {
		// TODO Auto-generated method stub
	
	}
}