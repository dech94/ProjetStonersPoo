/*
 * Classe Direction permetant de stocker une direction
 * @author Jules Wacquier & Jeremy Bourde
 * @version 1.0
 */
public class Direction {
	private int x,y;
	public boolean isCorrect;
	/*
	 * Constructeur de Direction
	 * @param x
	 * 		future valeure de x;
	 * @param y
	 * 		future valeure de y
	 */
	public Direction(int x, int y) {
		this.x=x;
		this.y=y;
		if((x<2 && x>-2) && (y<2 && y>-2)){
			this.isCorrect=true;
		}else{
			this.isCorrect=false;
		}
	}
	/*
	 * Constructeur de Direction
	 * @param d
	 * 		future Direction;
	 */
	public Direction(Direction d){
		this.x=d.x;
		this.y=d.y;
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