/**
 * Classe abstraite des des obstacles.
 * @author julesWacquier
 * @author jeremyBourde
 * @version 1.2
 */
public abstract class Obstacle extends Box {
	/**
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public abstract String toString();
	/**
	 * Constructeur vide
	 */
	protected Obstacle(){
		super();
	}
	/**
	 * Constructeur Obstacle
	 * @param p
	 * 		Position du futur obstacle
	 */
	protected Obstacle(Position p){
		super(p);
	}
}