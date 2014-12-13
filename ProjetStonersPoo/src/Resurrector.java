class Resurrector extends Character {

	Resurrector(Position p, Direction d){
		super(p,d);
	}

	public String toString(){
		if(isPetrified){
			return"r";
		}else{
			return "R";
		}
	}
}