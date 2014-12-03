import java.util.ArrayList;
import java.util.Iterator;
class Game {
	final static int taille = 10;
	ArrayList<Box> matrix = new ArrayList<Box>();
	Game(int nbWalker, int nbStoner, int nbResurrector, int nbSpin,int nbWall){
		int i,j,t;
		Position p=new Position(0,0);
		Direction d = new Direction(0,0);
		for(i=0;i<((Game.taille+2)*(Game.taille+2));i++) {
			j=(int)Math.random()*7;
			for(t=0;t<Game.taille;t++){
				if(t==0){
					p = new Position(i,0);
				}else{
					p =new Position(i/t,t);
				}
			}
			if(j==0 && nbWalker>0){
				matrix.add(i,new Walker(p,d));
				nbWalker--;
			}else{
				if(j==1 && nbStoner>0){
					matrix.add(i,new Stoner(p,d));
					nbStoner--;
				}else{
					if(j==2 && nbResurrector>0){
						matrix.add(i,new Resurrector(p,d));
						nbResurrector--;
					}else{
						if(j==3 && nbSpin>0){
							matrix.add(i,new Spin(p));
							nbSpin--;
						}else{
							if(j==4 && nbWall>0){
								matrix.add(i,new Wall(p));
								nbWall--;
							}else{
								matrix.add(i,new Vide(p));
							}
						}
					}
				}
			}
		}
	}
}