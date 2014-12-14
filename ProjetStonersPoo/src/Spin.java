/**
 * Classe fille de Obstacle
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
 */
public class Spin extends Obstacle {
	/**
	 * Constructeur Spin
	 * @param p
	 * 		Position
	 */
	Spin(Position p){
		super(p);
	}
	/**
	 * (non-Javadoc)
	 * @see Obstacle#toString()
	 */
	public String toString(){
		return "@";
	}
}