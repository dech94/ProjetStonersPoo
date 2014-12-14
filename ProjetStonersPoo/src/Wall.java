/**
 * Classe fille de Obstacle
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
 */
public class Wall extends Obstacle {
	/**
	 * Constructeur Wall
	 * @param p
	 * 		Position
	 */
	Wall(Position p){
		super(p);
	}
	/**
	 * (non-Javadoc)
	 * @see Obstacle#toString()
	 */
	public String toString(){
		return "#";
	}
}