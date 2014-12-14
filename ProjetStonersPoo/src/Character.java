/*
 * Abstract Class Character implements Steerable and Collision Interface 
 * @author Jules Wacquier & Jeremy Bourde
 * @version 3.0
 */
public abstract class Character extends Box implements Steerable, Collision{
	protected Direction dirChar;
	protected Direction tmp;
	protected Position posChar;
	protected boolean isPetrified;
	/*
	 * Constructeur Character
	 * @param p
	 * 		Position du futur personnage
	 * @param d
	 * 		Direction du futur personnage
	 */
	public Character(Position p, Direction d){
		this.posChar=new Position(p);
		this.dirChar = new Direction(d);
		isPetrified=false;
	}
	/*
	 * (non-Javadoc)
	 * @see Steerable#getDirection()
	 */
	public Direction getDirection() {
		return(this.dirChar);
	}
	/*
	 * (non-Javadoc)
	 * @see Steerable#setDirection(Direction)
	 */
	public void setDirection(Direction d) {
		this.dirChar=new Direction(d);
	}
	/*
	 * Methode permetant de déplacer le personnage
	 */
	public void move(){
		boolean deplacement=false;
		Box t[][]=Game.getT();
		Position cible= new Position(0,0);
		cible.setX((this.posChar.getX()+ this.dirChar.getX()));
		cible.setY((this.posChar.getY()+ this.dirChar.getY()));
				Box currentP = t[cible.getX()][cible.getY()];
				if(currentP.posBox.equals(cible)){
					this.react(currentP);
		}
		if(currentP.isVide) {
			deplacement=true;
		}
		if(deplacement){
		Game.getT()[this.posChar.getX()][this.posChar.getY()]=new Vide(this.posChar);
		this.posChar.setX(cible.getX());
		this.posChar.setY(cible.getY());
		Game.getT()[cible.getX()][cible.getY()]=this;
		}
	}
	/*
	 * Methode provoquant la petrification du personnage
	 */
	protected void Stop(){
		this.tmp=new Direction(dirChar);
		this.dirChar.setX(0);
		this.dirChar.setY(0);
		isPetrified=true;
	}
	/*
	 * Methode supprimant l'état de petrification du personnage 
	 */
	protected void Run(){
		isPetrified=false;
		this.dirChar=new Direction(tmp);
	}
	/*
	 * (non-Javadoc)
	 * @see Collision#react(Box)
	 */
	public void react(Box c){
		
		Direction d = new Direction(this.getDirection());
		if(c instanceof Resurrector){
			//System.out.println("changement 1");
			((Resurrector) c).Run();
		}else{
			if(c instanceof Stoner){
				//System.out.println("changement 2");
				((Stoner) c).Stop();
			}else{
				if(c instanceof Walker){
					//System.out.println("changement 3");
					((Walker) c).dirChar.setX(-((Walker) c).dirChar.getX());
					((Walker) c).dirChar.setY(-((Walker) c).dirChar.getY());
					if(!this.isPetrified){
						//System.out.println("changement 4");
						d.setX(-d.getX());
						d.setY(-d.getY());
						this.setDirection(d);
					}
				}else{
					if (c instanceof Wall){
						//System.out.println("changement 5");
						d.setX(-d.getX());
						d.setY(-d.getY());
						this.setDirection(d);
					}else{
						if(c instanceof Spin){
							//System.out.println("changement 6");
							d.setX(((-1)+(int)Math.random()*(1-(-1)+1)));
							d.setY(((-1)+(int)Math.random()*(1-(-1)+1)));
							this.setDirection(d);
						}else{
							if(c instanceof Vide){
								//System.out.println("rien");
							}else{
								//System.out.println("bug");
							}
						}
					}
				}
			}
		}
	}
}