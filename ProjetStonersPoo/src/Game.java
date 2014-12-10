import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
class Game {
	final static int hauteur = 15;
	final static int largeur = 15;
	Box[][]t=new Box[hauteur+1][largeur+1];
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k,l,m;
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		//int nbVide=hauteur*largeur-nbWalker-nbStoner-nbResurrector-nbSpin-nbWall;
		for(i=0;i<Game.hauteur+1;i++) {
			for(j=0;j<Game.largeur+1;j++) {
				k=(int)(Math.random()*((hauteur+largeur)/2));
				l=(int)(Math.random()*(2));
				m=(int)(Math.random()*(2));
				p.x=i;
				p.y=j;
				d.x=k-1;
				d.y=l-1;
				if((i==0)||(i==hauteur)||(j==0)||(j==largeur)){
					t[i][j]=new Wall(p);
				}else{
					if(k==0 && nbWalker>0){
						t[i][j]=new Walker(p,d);
						nbWalker--;
					}else{
						if(k==1 && nbStoner>0){
							t[i][j]=new Stoner(p,d);
							nbStoner--;
						}else{
							if(k==2 && nbResurrector>0){
								t[i][j]=new Resurrector(p,d);
								nbResurrector--;
							}else{
								if(k==3 && nbSpin>0){
									t[i][j]=new Spin(p);
									nbSpin--;
								}else{
									if(k==4 && nbWall>0){
										t[i][j]=new Wall(p);
										nbWall--;
									}else{
										t[i][j]=new Vide(p);
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
		Thread.sleep(500);
	}
	void Play() throws InterruptedException {
		int i,j,k=0;
		boolean play=true;
		while(play){
			System.out.println(this.toString());
			Lap();
			for(i=0;i<hauteur+1;i++){
				for(j=0;j<largeur+1;j++){
					if(t[i][j] instanceof Character) {
						((Character) t[i][j]).Move();
					}
				}
			}
			k++;
			System.out.println("\n------------------------------------------------\n\n");
			if(k==10){
				play=false;
			}
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
	