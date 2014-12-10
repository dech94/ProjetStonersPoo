abstract class Character extends Box implements Steerable{
	Direction d;
	Position p;
	Character(Position p, Direction d){
		super(p);
		this.d = new Direction(d);
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