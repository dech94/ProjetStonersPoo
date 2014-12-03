abstract class Character extends Box implements Steerable{
	Direction d;
	Position p;
	Character(Position p, Direction d){
		super(p);
		this.d = new Direction(d);
	}
	
}