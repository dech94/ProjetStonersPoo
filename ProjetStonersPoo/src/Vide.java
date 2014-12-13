class Vide extends Box {
	Vide(Position p){
		super(p);
	}
	public String toString(){
		return ".";
	}
	@Override
	public void react(Character c) {
		// TODO Auto-generated method stub
		c.p=new Position(this.p);
	}
}