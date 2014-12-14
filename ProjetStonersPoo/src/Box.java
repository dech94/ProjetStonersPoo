/*
 * Classe abstraite des personnages, de la classe obstacle et de la classe Vide
 * @author Jules Wacquier & Jeremy Bourde
 * @version 1.2
 */
public abstract class Box {
	protected Position posBox;
	protected boolean isVide;
	/*
	 * Constructeur Box
	 * @param p
	 * 		Position de la future box 
	 */
	protected Box(Position p){
		this.posBox = new Position (p);
		this.isVide=false;
	}
	/*
	 * Constructeur Box vide
	 */
	protected Box(){
		this.posBox=new Position(0,0);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
}