import java.util.Iterator;

abstract class Character extends Box implements Steerable, Collision{
	Direction d;
	Direction stock;
	Position p;
	boolean isPetrified;
	Character(Position p, Direction d){
		this.p=new Position(p);
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
		int i,j;
		boolean deplacement=false;
		Box t[][]=Game.getT();
		Position cible= new Position();
		cible.setX((this.p.getX()+ this.d.getX()));
		cible.setY((this.p.getY()+ this.d.getY()));
				Box currentP = t[cible.getX()][cible.getY()];
				if(currentP.p.equals(cible)){
					this.react(currentP);
		}
		//if(cible.getX()!=0 || cible.getY()!=0 || cible.getX()!=Game.getLargeur() || cible.getY()!=Game.getHauteur()){
		if(currentP.isVide) {
			deplacement=true;
		}
		if(deplacement){
		Game.getT()[this.p.getX()][this.p.getY()]=new Vide(this.p);
		this.p.setX(cible.getX());
		this.p.setY(cible.getY());
		Game.getT()[cible.getX()][cible.getY()]=this;
		}
	}
	public void MoveTo(){
		
	}
	void Stop(){
		this.stock=new Direction(d);
		this.d.setX(0);
		this.d.setY(0);
		isPetrified=true;
	}
	void Run(){
		isPetrified=false;
		this.d=new Direction(stock);
	}
	public void react(Box c){
		
		Direction d = new Direction(this.getDirection());
		if(c instanceof Resurrector){
			System.out.println("changement 1");
			((Resurrector) c).Run();
		}else{
			if(c instanceof Stoner){
				System.out.println("changement 2");
				((Stoner) c).Stop();
			}else{
				if(c instanceof Walker){
					System.out.println("changement 3");
					((Walker) c).d.setX(-((Walker) c).d.getX());
					((Walker) c).d.setY(-((Walker) c).d.getY());
					if(!this.isPetrified){
						System.out.println("changement 4");
						d.setX(-d.getX());
						d.setY(-d.getY());
						this.setDirection(d);
					}
				}else{
					if (c instanceof Wall){
						System.out.println("changement 5");
						d.setX(-d.getX());
						d.setY(-d.getY());
						this.setDirection(d);
					}else{
						if(c instanceof Spin){
							System.out.println("changement 6");
							d.setX(((-1)+(int)Math.random()*(1-(-1)+1)));
							d.setY(((-1)+(int)Math.random()*(1-(-1)+1)));
							this.setDirection(d);
						}else{
							if(c instanceof Vide){
								System.out.println("rien");
							}else{
								System.out.println("bug");
							}
						}
					}
				}
			}
		}
	}
}