import java.util.ArrayList;
import java.util.Iterator;
class Game {
	final static int hauteur = 15;
	final static int largeur = 15;
	Box[][]t=new Box[hauteur+1][largeur+1];
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,k;
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		//int nbVide=hauteur*largeur-nbWalker-nbStoner-nbResurrector-nbSpin-nbWall;
		for(i=0;i<Game.hauteur+1;i++) {
			for(j=0;j<Game.largeur+1;j++) {
				k=(int)(Math.random()*((hauteur+largeur)/2));
				p.x=i;
				p.y=j;
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
	