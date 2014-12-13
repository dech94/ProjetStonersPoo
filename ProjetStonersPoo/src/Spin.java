class Spin extends Obstacle {
	Spin(Position p){
		super(p);
	}
	public String toString(){
		return "@";
	}
	@Override
	public void react(Character c) {
		// TODO Auto-generated method stub
		Direction d = new Direction(c.getDirection());
		d.setX(((-1)+(int)Math.random()*(1-(-1)+1)));
		d.setY(((-1)+(int)Math.random()*(1-(-1)+1)));
		c.setDirection(d);
	}
	@Override
	public void react(Obstacle o) {
		// TODO Auto-generated method stub
		
	}
}