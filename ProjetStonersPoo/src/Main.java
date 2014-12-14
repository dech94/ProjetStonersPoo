class Main{
	public static void main (String[]args) throws InterruptedException{
		int w,s,r,S,W,time,hauteur,largeur;
		System.out.println("     Stoner 1.0    \n--------------------\n\n");
		System.out.println("Choisir la hauteur (en nombre de case, limite incluse):\n");
		hauteur=Clavier.saisirInt();
		System.out.println("Choisir la largeur (en nombre de case, limite incluse) :\n");
		largeur=Clavier.saisirInt();
		System.out.println("Choisir le nombre de prommeneur(s) :\n");
		w=Clavier.saisirInt();
		System.out.println("Choisir le nombre de petrifieur(s) :\n");
		s=Clavier.saisirInt();
		System.out.println("Choisir le nombre de ressusciteur(s) :\n");
		r=Clavier.saisirInt();
		System.out.println("Choisir le nombre de tourniquet(s) :\n");
		S=Clavier.saisirInt();
		System.out.println("Choisir le nombre de mur(s) :\n");
		W=Clavier.saisirInt();
		System.out.println("Choisir la duree de la pause entre 2 actions :\n");
		time=Clavier.saisirInt();
		Game g = new Game(w,s,r,S,W,hauteur,largeur,time);
		//System.out.println(g.toString());
		g.Play();
	}
}