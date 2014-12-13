import com.sun.istack.internal.NotNull;

class Position {
	int x,y;
	Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
	Position(Position p){
		this.x=p.x;
		this.y=p.y;
	}
	Position(){
		this.x=0;
		this.y=0;
	}
	boolean isValid(){
		if(x>0 && x<Game.largeur){
			if(y>0 && y<Game.hauteur){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public boolean equals(Position p) {
        return (((p.x + p.y) - (this.x + this.y)) == 0);
    }
	public int compare(Object ob1, Object ob2) {
        Position p1 = (Position) ob1, p2 = (Position) ob2;
        return ((p2.x + p2.y) - (p1.x + p1.y));
    }
}