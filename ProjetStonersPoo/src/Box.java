/*
 * Classe abstraite des personnages, de la classe obstacle et de la classe Vide
 * @author Jules Wacquier et Jeremy Bourde
 * @version 1
 */
abstract class Box {
	protected Position posBox;
	protected boolean isVide;
	/*
	 * Constructeur Box
	 * @param Position 
	 */
	protected Box(Position p){
		this.posBox = new Position (p);
		this.isVide=false;
	}
	/*
	 * Constructeur Box vide
	 */
	protected Box(){
		this.posBox=new Position();
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
}