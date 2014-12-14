/**
 * Classe Vide permetant au personnages de se déplacer.
 * @author julesWacquier
 * @author jeremyBourde
 * @version 1.3
 */
public class Vide extends Box {
	/**
	 * Constructeur Vide
	 * @param p
	 * 		Position de la future case Vide
	 */
	public Vide(Position p){
		super(p);
		this.isVide=true;
	}
	/**
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public String toString(){
		return ".";
	}
}