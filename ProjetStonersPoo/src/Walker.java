class Walker extends Character {

	Walker(Position p, Direction d){
		super(p,d);
	}
	@Override
	public Direction getDirection() {
		// TODO Auto-generated method stub
		return this.d;
	}

	@Override
	public void setDirection(Direction d) {
		// TODO Auto-generated method stub
		this.d=new Direction(d);
	}
	@Override
	public void react(Character c) {
		// TODO Auto-generated method stub
		if(c instanceof Resurrector){
			
		}else{
			if(c instanceof Stoner){
				
			}else{
				
			}
		}
	}
	public String toString() {
		return "O";
		
	}
}