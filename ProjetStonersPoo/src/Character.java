abstract class Character extends Box implements Steerable{
	Direction d;
	Position p;
	Character(Position p, Direction d){
		super(p);
		this.d = new Direction(d);
	}
	public Direction getDirection() {
		return(this.d);
	}
	public void setDirection(Direction dir) {
		this.d=new Direction(dir);
	}
	void Move(){
		if(d.x == 1) {
			if(d.y == 1){
				p.x++;
				p.y++;
			}else {
				if(d.y == -1){
					p.x++;
					p.y--;
				}else{
					p.x++;
				}
			}
		}else{
			if(d.x == -1){
				if(d.y == 1){
					p.x--;
					p.y++;
				}else {
					if(d.y == -1){
						p.x--;
						p.y--;
					}else{
						p.x++;
					}
				}
			}else{
				if(d.y == 1){
					p.y++;
				}else {
					if(d.y == -1){
						p.y--;
					}
				}
			}
		}
	}
}