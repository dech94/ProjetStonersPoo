import java.util.ArrayList;
import java.util.Iterator;
class Game {
	private final static int hauteur = 15;
	private final static int largeur = 15;
	private static Box[][]t;
	private ArrayList<Character>listeCharacter;
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k;
		listeCharacter = new ArrayList<Character>();
		setT(new Box[getHauteur()+1][getLargeur()+1]);
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		//int nbVide=hauteur*largeur-nbWalker-nbStoner-nbResurrector-nbSpin-nbWall;
		for(i=0;i<Game.getHauteur()+1;i++) {
			for(j=0;j<Game.getLargeur()+1;j++) {
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
	private void Lap() throws InterruptedException{
		Thread.sleep(2000);
	}
	void Play() throws InterruptedException {
		int k=0;
		boolean play=true;
		while(play){
			System.out.println(this.toString());
			Lap();
			Iterator<Character> it = listeCharacter.iterator();
			while (it.hasNext()){
				Character c=it.next();
				System.out.println(c.toString());
				System.out.println("direction="+c.dirChar.getX()+";"+c.dirChar.getY());
				System.out.println("position ="+c.posChar.getX()+";"+c.posChar.getY());
				c.Move();
				}
			}
			k++;
			System.out.println("\n------------------------------------------------\n\n");
			if(k==2){
				play=false;
			}
		}
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
	public static int getLargeur() {
		return largeur;
	}
	public static int getHauteur() {
		return hauteur;
	}
	public static Box[][] getT() {
		return t;
	}
	public void setT(Box[][] t) {
		Game.t = t;
	}
}
	
