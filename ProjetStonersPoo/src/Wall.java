class Wall extends Obstacle {
	Wall(Position p){
		super(p);
	}
	public String toString(){
		return "#";
	}
	@Override
	public void react(Character c) {
		// TODO Auto-generated method stub
		Direction d = new Direction(c.getDirection());
		d.setX(-d.getX());
		d.setY(-d.getY());
		c.setDirection(d);
	}
	@Override
	public void react(Obstacle o) {
		// TODO Auto-generated method stub
	}
}