
public class ArbreBinaire {
	
	// Attributs
	String nomSommet;
	ArbreBinaire filsG,filsD;
	
	
	// Constructeur Sommet
	public ArbreBinaire(String nomSommet) {
		this.nomSommet = nomSommet;
	}
	
	// Constructeur Sommet + fils
	public ArbreBinaire(String nomSommet, ArbreBinaire filsG, ArbreBinaire filsD) {
		this.nomSommet = nomSommet;
		this.filsG = filsG;
		this.filsD = filsD;
	}
	
	// Méthodes
	public static void affichagePrefixe(ArbreBinaire sommet) {
		System.out.print(sommet.nomSommet + " ");
		if (sommet.filsG != null){
			affichagePrefixe(sommet.filsG);
		}
		if (sommet.filsD != null){
			affichagePrefixe(sommet.filsD);
		}
	}
	
	
	public static int profondeur(ArbreBinaire sommet) {
		if (sommet == null){
			return 0;
		} else {
			return 1 + Math.max(profondeur(sommet.filsD), profondeur(sommet.filsG));
		}
	}
	
	public static String niveau(ArbreBinaire a, int prof) {
	    String G, D;
	    if (a == null) {
	    	return "";
	    }
	    if (prof > 0) {
	    	G = niveau(a.filsG, prof-1);
	    	D = niveau(a.filsD, prof-1);
	    	return G+D;
	    } else {
	    	return a.nomSommet;
	    }
	}
	
	public static void afficheEnLargeur(ArbreBinaire racine) {
	    int i = 0;
	    String s;
	    do {
	    	s = niveau(racine, i);
	    	System.out.print("("+s+") ");
	    	i++;
	    } while (niveau(racine, i).length() > 0);
	}
	
	// Main
	public static void main(String[] args) {
		
		ArbreBinaire D = new ArbreBinaire("D");
		ArbreBinaire F = new ArbreBinaire("F");
		ArbreBinaire G = new ArbreBinaire("G");
		ArbreBinaire H = new ArbreBinaire("H");
		ArbreBinaire C = new ArbreBinaire("C", F, null);
		ArbreBinaire E = new ArbreBinaire("E", G, H);
		ArbreBinaire B = new ArbreBinaire("B", D, E);
		ArbreBinaire A = new ArbreBinaire("A",B,C);
		
		System.out.println("Affichage préfixé:");
		affichagePrefixe(A);
		
		System.out.println("\nProfondeur:");
		System.out.println(profondeur(A));
		
		System.out.println("Affichage en largeur:");
		afficheEnLargeur(A);
		
	}
}
