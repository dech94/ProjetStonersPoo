import java.util.ArrayList;
import java.util.Iterator;
class Game {
	private final static int hauteur = 15;
	private final static int largeur = 15;
	private int taille=getHauteur()*getLargeur();
	private static Box[][]t;
	private ArrayList<Character>character;
	private static ArrayList<Box> obstacle;
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k;
		setObstacle(new ArrayList<Box>());
		character = new ArrayList<Character>();
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
					getObstacle().add(w);
				}else{
					if(k==0 && nbWalker>0){
						Walker w = new Walker(p,d);
						getT()[i][j]=w;
						character.add(w);
						getObstacle().add(w);
						nbWalker--;
					}else{
						if(k==1 && nbStoner>0){
							Stoner s = new Stoner(p,d);
							getT()[i][j]=s;
							character.add(s);
							getObstacle().add(s);
							nbStoner--;
						}else{
							if(k==2 && nbResurrector>0){
								Resurrector r = new Resurrector(p,d);
								getT()[i][j]=r;
								character.add(r);
								getObstacle().add(r);
								nbResurrector--;
							}else{
								if(k==3 && nbSpin>0){
									Spin s = new Spin(p);
									getT()[i][j]=s;
									getObstacle().add(s);
									nbSpin--;
								}else{
									if(k==4 && nbWall>0){
										Wall w = new Wall(p);
										getT()[i][j]=w;
										getObstacle().add(w);
										nbWall--;
									}else{
										Vide v = new Vide(p);
										getT()[i][j]=v;
										getObstacle().add(v);
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
		Thread.sleep(50);
	}
	void Play() throws InterruptedException {
		int i,j,k=0;
		boolean play=true;
		while(play){
			System.out.println(this.toString());
			Lap();
			Iterator<Character> it = character.iterator();
			while (it.hasNext()){
				Character c=it.next();
				System.out.println(c.toString());
				System.out.println("Caractere="+c.test);
				System.out.println("direction="+c.d.getX()+";"+c.d.getY());
				System.out.println("position ="+c.p.getX()+";"+c.p.getY());
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
	public static ArrayList<Box> getObstacle() {
		return obstacle;
	}
	public void setObstacle(ArrayList<Box> obstacle) {
		this.obstacle = obstacle;
	}
	public static Box[][] getT() {
		return t;
	}
	public void setT(Box[][] t) {
		this.t = t;
	}
}
	
