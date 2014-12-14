/**
 * Classe fille de Character
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
*/
public class Walker extends Character {
	/**
	 * Constructeur Walker
	 * @param p
	 * 		Position
	 * @param d
	 * 		Direction
	 */
	Walker(Position p, Direction d){
		super(p,d);
	}
	/**
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public String toString() {
		if(isPetrified){
			return "0";
		}else{
			return "O";
		}
	}
}