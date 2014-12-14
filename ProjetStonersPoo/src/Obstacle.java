/*
 * Classe abstraite des des obstacles.
 * @author Jules Wacquier et Jeremy Bourde
 * @version 1
 */
abstract class Obstacle extends Box {
	/*
	 * (non-Javadoc)
	 * @see Box#toString()
	 */
	public abstract String toString();
	/*
	 * Constructeur vide
	 */
	protected Obstacle(){
		super();
	}
	/*
	 * Constructeur Obstacle
	 * @param Position p
	 */
	protected Obstacle(Position p){
		super(p);
	}
}