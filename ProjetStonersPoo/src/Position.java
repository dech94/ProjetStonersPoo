/*
 * Classe Direction permetant de stocker une Position
 * @author Jules Wacquier & Jeremy Bourde
 * @version 2.0
 */
class Position {
	private int x,y;
	/*
	 * Constructeur de Position
	 * @param x
	 * 		future valeure de x;
	 * @param y
	 * 		future valeure de y
	 */
	Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
	/*
	 * Constructeur de Position
	 * @param p
	 * 		future Position;
	 */
	Position(Position p){
		this.x=p.x;
		this.y=p.y;
	}
	/*
	 * methode testant l'egalite de 2 Positions
	 * @return true si les Positions sont egales 
	 */
	public boolean equals(Position p) {
        return (((p.x + p.y) - (this.x + this.y)) == 0);
    }
	/*
	 * Setter
	 * @param x
	 * 		future valeure de x
	 */
	public void setX(int x){
		this.x=x;
	}
	/*
	 * Setter
	 * @param y
	 * 		future valeure de y
	 */
	public void setY(int y){
		this.y=y;
	}
	/*
	 * Getter
	 * @return Valeure de x
	 */
	public int getX(){
		return this.x;
	}
	/*
	 * Getter
	 * @return Valeure de y
	 */
	public int getY(){
		return this.y;
	}
}
