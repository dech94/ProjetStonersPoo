/**
 * Interface Collision qui permet d'implémenter la méthode react dans la classe qui l'implémente.
 * @author julesWacquier
 * @author jeremyBourde
 * @version 2.0
 */
public interface Collision{
	/**
	 * Cette méthode va faire réagir l'instance de classe qui l'implémente avec une Box afin de gerer les collisions 
	 * @param tempBox
	 * 		Box avec laquelle la méthode réagit
	 */
	void react(Box tempBox);
}