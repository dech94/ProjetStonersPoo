/*
 * Interface Collision qui permet d'implémenter la méthode react dans la classe qui l'implémente.
 * @author Jules Wacquier & Jeremy Bourde
 * @version 2.0
 */
interface Collision{
	/*
	 * Cette méthode va faire réagir l'instance de classe qui l'implémente avec une Box afin de gerer les collisions 
	 * @param Box tempBox
	 * 		Box avec laquelle la méthode réagit
	 */
	void react(Box tempBox);
}