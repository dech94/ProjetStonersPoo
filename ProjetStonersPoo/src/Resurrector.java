/**
 * Classe fille de Character
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
 */
public class Resurrector extends Character {
	/**
	 * Constructeur Resurector
	 * @param p
	 * 		Position
	 * @param d
	 * 		Direction
	 */
	Resurrector(Position p, Direction d){
		super(p,d);
	}
	/**
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public String toString(){
		if(isPetrified){
			return"r";
		}else{
			return "R";
		}
	}
}