/**
 * Interface Steerable imposée contenant les méthodes pour changer la direction de l'instance de classe qui l'implémente.
 * @author julesWacquier
 * @author jeremyBourde
 * @version 1.0
 */
public interface Steerable {
	/**
	 * getter de Direction
	 * @return La direction de l'instance de la classe qui l'implémente.
	 */
	Direction getDirection();
	/**
	 * setter de Direction
	 * @param d
	 * 		Direction a modifier
	 */
	void setDirection(Direction d);
}