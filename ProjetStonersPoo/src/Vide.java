/*
 * Classe Vide permetant au personnages de se déplacer.
 * @author Jules Wacquier et Jeremy Bourde
 * @version 1
 */
class Vide extends Box {
	/*
	 * Constructeur Vide
	 * @param Position p
	 */
	Vide(Position p){
		super(p);
		this.isVide=true;
	}
	/*
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public String toString(){
		return ".";
	}
}