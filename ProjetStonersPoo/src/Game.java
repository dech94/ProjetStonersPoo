import java.util.ArrayList;
import java.util.Iterator;
class Game {
	private final static int hauteur = 15;
	private final static int largeur = 15;
	private int taille=hauteur*largeur;
	private Box[][]t;
	private ArrayList<Character>character;
	private ArrayList<Box> obstacle;
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k;
		obstacle = new ArrayList<Box>();
		character = new ArrayList<Character>();
		t = new Box[hauteur+1][largeur+1];
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		//int nbVide=hauteur*largeur-nbWalker-nbStoner-nbResurrector-nbSpin-nbWall;
		for(i=0;i<Game.hauteur+1;i++) {
			for(j=0;j<Game.largeur+1;j++) {
				k=(int)(Math.random()*((hauteur+largeur)/2));
				p.setX(i);
				p.setY(j);
				System.out.println(p.getX()+";"+p.getY());
				d.x=(-1) + (int)(Math.random() * ((1 - (-1)) + 1));
				d.y=(-1) + (int)(Math.random() * ((1 - (-1)) + 1));
				if((i==0)||(i==hauteur)||(j==0)||(j==largeur)){
					Wall w = new Wall(p);
					t[i][j]=w;
					obstacle.add(w);
				}else{
					if(k==0 && nbWalker>0){
						Walker w = new Walker(p,d);
						t[i][j]=w;
						character.add(w);
						obstacle.add(w);
						nbWalker--;
					}else{
						if(k==1 && nbStoner>0){
							Stoner s = new Stoner(p,d);
							t[i][j]=s;
							character.add(s);
							obstacle.add(s);
							nbStoner--;
						}else{
							if(k==2 && nbResurrector>0){
								Resurrector r = new Resurrector(p,d);
								t[i][j]=r;
								character.add(r);
								obstacle.add(r);
								nbResurrector--;
							}else{
								if(k==3 && nbSpin>0){
									Spin s = new Spin(p);
									t[i][j]=s;
									obstacle.add(s);
									nbSpin--;
								}else{
									if(k==4 && nbWall>0){
										Wall w = new Wall(p);
										t[i][j]=w;
										obstacle.add(w);
										nbWall--;
									}else{
										Vide v = new Vide(p);
										t[i][j]=v;
										obstacle.add(v);
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
				System.out.println("direction="+c.d.x+";"+c.d.y);
				System.out.println("position ="+c.p);
				//c.Move();
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
		for(i=0;i<hauteur+1;i++){
			for(j=0;j<largeur+1;j++){
				res=res+t[i][j].toString()+" ";
			}
			res=res+"\n";
		}
		return res;
	}
}
	
