/**
 * Classe fille de Character
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
 */
public class Stoner extends Character {
	/**
	 * Constructeur Stoner
	 * @param p
	 * 		Position
	 * @param d
	 * 		Direction
	 */
	Stoner(Position p, Direction d){
		super(p,d);
	}
	/**
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public String toString(){
		if(isPetrified){
			return "x";
		}else{
			return "X";
		}
	}
}