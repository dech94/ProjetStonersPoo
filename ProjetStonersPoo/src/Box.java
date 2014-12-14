import java.util.Iterator;

abstract class Box {
	protected Position p;
	protected boolean isVide;
	protected Box(Position p){
		this.p = new Position (p);
		this.isVide=false;
	}
	protected Box(){
		this.p=new Position();
	}
	public abstract String toString();
}