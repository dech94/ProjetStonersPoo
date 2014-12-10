class Resurrector extends Character {

	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return this.d;
	}

	@Override
	public void setDirection(Direction d) {
		// TODO Auto-generated method stub
		this.d=d;
	}
	Resurrector(Position p, Direction d){
		super(p,d);
	}

	@Override
	public void react(Character c) {
		// TODO Auto-generated method stub
		
	}
	public String toString(){
		return "R";
	}
}