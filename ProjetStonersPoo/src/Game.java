import java.util.ArrayList;
import java.util.Iterator;
class Game {
	final static int hauteur = 15;
	final static int largeur = 15;
	static int taille=hauteur*largeur;
	static Box[][]t=new Box[hauteur+1][largeur+1];
	static ArrayList<Character>character=new ArrayList<Character>();
	static ArrayList<Box>obstacle= new ArrayList<Box>();
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k;
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		//int nbVide=hauteur*largeur-nbWalker-nbStoner-nbResurrector-nbSpin-nbWall;
		for(i=0;i<Game.hauteur+1;i++) {
			for(j=0;j<Game.largeur+1;j++) {
				k=(int)(Math.random()*((hauteur+largeur)/2));
				p.setX(i);
				p.setY(j);
				d.x=(-1) + (int)(Math.random() * ((1 - (-1)) + 1));
				d.y=(-1) + (int)(Math.random() * ((1 - (-1)) + 1));
				if((i==0)||(i==hauteur)||(j==0)||(j==largeur)){
					t[i][j]=new Wall(p);
					obstacle.add(new Wall(p));
				}else{
					if(k==0 && nbWalker>0){
						t[i][j]=new Walker(p,d);
						character.add(new Walker(p,d));
						obstacle.add(new Walker(p,d));
						nbWalker--;
					}else{
						if(k==1 && nbStoner>0){
							t[i][j]=new Stoner(p,d);
							character.add(new Stoner(p,d));
							obstacle.add(new Stoner(p,d));
							nbStoner--;
						}else{
							if(k==2 && nbResurrector>0){
								t[i][j]=new Resurrector(p,d);
								character.add(new Resurrector(p,d));
								obstacle.add(new Resurrector(p,d));
								nbResurrector--;
							}else{
								if(k==3 && nbSpin>0){
									t[i][j]=new Spin(p);
									obstacle.add(new Spin(p));
									nbSpin--;
								}else{
									if(k==4 && nbWall>0){
										t[i][j]=new Wall(p);
										obstacle.add(new Wall(p));
										nbWall--;
									}else{
										t[i][j]=new Vide(p);
										obstacle.add(new Vide(p));
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
				c.Move();
				}
			}
			for(i=0;i<hauteur+1;i++){
				for(j=0;j<largeur+1;j++){
					
				}
			}
			k++;
			System.out.println("\n------------------------------------------------\n\n");
			if(k==10){
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
	