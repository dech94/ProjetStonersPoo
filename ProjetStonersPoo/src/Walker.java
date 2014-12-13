class Walker extends Character {

	Walker(Position p, Direction d){
		super(p,d);
	}

	public String toString() {
		if(isPetrified){
			return "0";
		}else{
			return "O";
		}
	}
}