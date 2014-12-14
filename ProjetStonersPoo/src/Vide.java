class Vide extends Box {
	Vide(Position p){
		super(p);
		this.isVide=true;
	}
	public String toString(){
		return ".";
	}
}