class Stoner extends Character {

	Stoner(Position p, Direction d){
		super(p,d);
	}

	public String toString(){
		if(isPetrified){
			return "x";
		}else{
			return "X";
		}
	}
}