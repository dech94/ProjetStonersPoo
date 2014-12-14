/*
 * Classe Game permettant d'initialiser le jeu
 * @author Jules Wacquier & Jeremy Bourde
 * @version 5.0
 */
import java.util.ArrayList;
import java.util.Iterator;
class Game {
	int hauteur;
	int largeur;
	int time;
	private static Box[][]t;
	private ArrayList<Character>listeCharacter;
	/*
	 * Constructeur d'une partie aléatoire
	 * @param nbWalker
	 * 			nombre de Walker
	 * @param nbStoner
	 * 			nombre de Stoner
	 * @param nbResurrector
	 * 			nombre de Resurrector
	 * @param nbSpin
	 * 			nombre de Spin
	 * @param nbWall
	 * 			nombre de Wall (sans compter les limites du jeu)
	 * @param hauteur
	 * 			hauteur du jeu
	 * @param largeur
	 * 			largeur du jeu
	 * @param time
	 * 			temps entre 2 actions
	 */
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall,int hauteur, int largeur, int time){
		int i,j,k;
		this.hauteur=hauteur;
		this.largeur=largeur;
		this.time=time;
		listeCharacter = new ArrayList<Character>();
		setT(new Box[getHauteur()+1][getLargeur()+1]);
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		for(i=0;i<this.getHauteur()+1;i++) {
			for(j=0;j<this.getLargeur()+1;j++) {
				k=(int)(Math.random()*((getHauteur()+getLargeur())/2));
				p.setX(i);
				p.setY(j);
				System.out.println(p.getX()+";"+p.getY());
				d.setX((-1) + (int)(Math.random() * ((1 - (-1)) + 1)));
				d.setY((-1) + (int)(Math.random() * ((1 - (-1)) + 1)));
				if((i==0)||(i==getHauteur())||(j==0)||(j==getLargeur())){
					Wall w = new Wall(p);
					getT()[i][j]=w;
				}else{
					if(k==0 && nbWalker>0){
						Walker w = new Walker(p,d);
						getT()[i][j]=w;
						listeCharacter.add(w);
						nbWalker--;
					}else{
						if(k==1 && nbStoner>0){
							Stoner s = new Stoner(p,d);
							getT()[i][j]=s;
							listeCharacter.add(s);
							nbStoner--;
						}else{
							if(k==2 && nbResurrector>0){
								Resurrector r = new Resurrector(p,d);
								getT()[i][j]=r;
								listeCharacter.add(r);
								nbResurrector--;
							}else{
								if(k==3 && nbSpin>0){
									Spin s = new Spin(p);
									getT()[i][j]=s;
									nbSpin--;
								}else{
									if(k==4 && nbWall>0){
										Wall w = new Wall(p);
										getT()[i][j]=w;
										nbWall--;
									}else{
										Vide v = new Vide(p);
										getT()[i][j]=v;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	/*
	 * methode permetant de mettre en pause le Thread principal
	 * @throws Si on a une pause sur le thread principal
	 */
	private void Lap(int x) throws InterruptedException{
		Thread.sleep(x);
	}
	/*
	 * methode permetant de demarer une partie
	 * @throws Si on a une pause sur le thread principal
	 */
	void Play() throws InterruptedException {
		int k=0;
		boolean play=true;
		while(play){
			System.out.println(this.toString());
			Lap(time);
			Iterator<Character> it = listeCharacter.iterator();
			while (it.hasNext()){
				Character c=it.next();
				/* test
				System.out.println(c.toString());
				System.out.println("direction="+c.dirChar.getX()+";"+c.dirChar.getY());
				System.out.println("position ="+c.posChar.getX()+";"+c.posChar.getY());
				*/
				c.move();
				}
		}
		k++;
		System.out.println("\n------------------------------------------------\n\n");
		if(k==2){
			play=false;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		int i,j;
		String res="";
		for(i=0;i<getHauteur()+1;i++){
			for(j=0;j<getLargeur()+1;j++){
				res=res+getT()[i][j].toString()+" ";
			}
			res=res+"\n";
		}
		return res;
	}
	/*
	 * Getter
	 * @return largeur
	 */
	public int getLargeur() {
		return largeur;
	}
	/*
	 * Getter
	 * @return hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}
	/*
	 * Getter
	 * @return t
	 */
	public static Box[][] getT() {
		return t;
	}
	/*
	 * Setter
	 * @param t
	 * 			une matrice comprenant des Box
	 */
	public void setT(Box[][] t) {
		Game.t = t;
	}
}
	
