import java.util.Iterator;

abstract class Character extends Box implements Steerable{
	Direction d;
	Direction stock;
	Position p;
	boolean isPetrified;
	int test=5;
	Character(Position p, Direction d){
		super(p);
		this.d = new Direction(d);
		isPetrified=false;
	}
	public Direction getDirection() {
		return(this.d);
	}
	public void setDirection(Direction d) {
		this.d=new Direction(d);
	}
	public void Move(){
		boolean occuper = false;
		Position cible= new Position();
		cible.setX((this.p.getX()+ this.d.x));
		cible.setY((this.p.getY()+ this.d.y));
		Iterator <Box> it = Game.obstacle.iterator();
		while((it.hasNext())&&(occuper== false)){
			Box currentP = it.next();
			if(currentP.p.equals(cible)){
				currentP.react(this);
				occuper = true;
			}
		}
		MoveNext(p);
	}
		/*Position next=p;
		if(next.isValid()){
			if(d.x == 1) {
				if(d.y == 1){
					next.x++;
					next.y++;
				}else {
					if(d.y == -1){
						next.x++;
						next.y--;
					}else{
						next.x++;
					}
				}
			}else{
				if(d.x == -1){
					if(d.y == 1){
						next.x--;
						next.y++;
					}else {
						if(d.y == -1){
							next.x--;
							next.y--;
						}else{
							next.x--;
						}
					}
				}else{
					if(d.y == 1){
						next.y++;
					}else {
						if(d.y == -1){
							next.y--;
						}
					}
				}
			}
		}else{
			if(d.x == 1) {
				if(d.y == 1){
					next.x=Game.largeur;
					next.y=Game.largeur;
				}else {
					if(d.y == -1){
						next.x=Game.largeur;
						next.y=0;
					}else{
						next.x=Game.largeur;
					}
				}
			}else{
				if(d.x == -1){
					if(d.y == 1){
						next.x=0;
						next.y=Game.largeur;
					}else {
						if(d.y == -1){
							next.x=0;
							next.y=0;
						}else{
							next.x=0;
						}
					}
				}else{
					if(d.y == 1){
						next.y=Game.largeur;
					}else {
						if(d.y == -1){
							next.y=0;
						}
					}
				}
			}
		}*/
	void MoveNext(Position p){
		Game.t[p.getX()][p.getY()]=this;
	}
	void Stop(){
		this.stock=new Direction(d);
		this.d.x=0;
		this.d.y=0;
		isPetrified=true;
	}
	void Run(){
		isPetrified=false;
		this.d=new Direction(stock);
	}
	public void react(Character c){
		Direction d = new Direction(c.getDirection());
		if(c instanceof Resurrector){
			this.Run();
		}else{
			if(c instanceof Stoner){
				this.Stop();
			}else{
				this.d.x=-this.d.x;
				this.d.y=-this.d.y;
				if(!c.isPetrified){
					d.x=-d.x;
					d.y=-d.y;
					c.setDirection(d);
				}
			}
		}
	}
	public void react(Box box) {
		// TODO Auto-generated method stub
		box.react(this);
	}
}