import java.util.List;
import java.util.ArrayList;


/**
 * 
 */

/**
 * @author deimlf
 *
 */
public class Graph{
	private Knoten[] knoten;
	private int[][] adjazenzmatrix;
	private int n;
	
	public Graph(int n) {
		this.n =n;
		knoten=new Knoten[n];
		adjazenzmatrix=new int[n][n];
		
	}
	public void kanteEinfuegen(Datenelement anfangsort, Datenelement zielort,int entfernung) {
		for(int i=0;i<n;i++) {
			if(knoten[i].getElement().equals(anfangsort)) {
				for(int e =0;e<n;e++) {
					if(knoten[e].getElement().equals(zielort))
						adjazenzmatrix[i][e]=entfernung;
				}
			}
		}
	}
	public List<Datenelement> dijkstra(Datenelement anfangsort, Datenelement zielort) {
		List<Datenelement> liste1 = new ArrayList<Datenelement>();
		List<Datenelement> liste2 = new ArrayList<Datenelement>();
		for(int i =0;i<n;i++) {
			liste1.add(knoten[i].getElement());
		}
		for(int i=0;i<n;i++) {
			knoten[i].getElement().setEntfernung(999999);
			knoten[i].getElement().setVorgaenger(null);
		}
		suche(anfangsort).setEntfernung(0);
		while(liste1.contains(zielort)) {
			Datenelement ent = new Datenelement(null,0);
			ent.setEntfernung(999999);
			for(int i=0;i<liste1.size();i++) {
				if(liste1.get(i).getEntfernung()<ent.getEntfernung()) {
					ent=liste1.get(i);
				}
			}
			liste2.add(ent);
			liste1.remove(ent);
			for(int i =0;i<n;i++) {
				if(knoten[i].getElement().equals(ent)) {
					for(int e = 0;e<n;e++) {
						if(liste1.contains(knoten[i].getElement())) {
							if(knoten[i].getNaechster(e).getElement().getEntfernung()>knoten[i].getElement().getEntfernung()+adjazenzmatrix[i][e]) {
								knoten[i].getNaechster(e).getElement().setEntfernung(knoten[i].getElement().getEntfernung()+adjazenzmatrix[i][e]);
								knoten[i].getNaechster(e).getElement().setVorgaenger(ent);
							}
						}
					}
				}
			}
		}
		return liste2;
	}
	public void favoritEinfuegen(Datenelement favorit) {}
	public void zuHauseEinfuegen(Datenelement zuHause) {}
	public void routeEinfuegen(Datenelement anfangsort, Datenelement zielort) {}
	public Ausgabe auslesen(String anfangsort, String zielort) {	
		Datenelement start = new Datenelement(null,0);
		Datenelement ziel = new Datenelement(null,0);
		for(int i=0;i<n;i++) {
			if(knoten[i].getElement().toString()==anfangsort) {
				start=knoten[i].getElement();
			}
		}
		for(int i=0;i<n;i++) {
			if(knoten[i].getElement().toString()==zielort) {
				ziel=knoten[i].getElement();
			}
		}
		dijkstra(start,ziel);
		List<Datenelement> liste = new ArrayList<Datenelement>();
		liste.add(ziel);
		Datenelement e = ziel;
		while(!liste.contains(start)) {
			e=e.getVorgaenger();
			liste.add(e);
		}
		return new Ausgabe(liste,ziel.getEntfernung());	
	}
	public Datenelement suche(Datenelement element) {
		for(int i=0;i<n;i++) {
			knoten[i].setBesucht(false);
		}
		return knoten[0].suche(element);
		
	}
	public void knotenHinzufuegen(int index, Knoten k) {
		knoten[index]= k;
	}
	public Knoten getKnoten(int index) {
		return knoten[index];
	}
	public void knotenFuellen() {
		for(int i=0;i<n;i++) {
			for(int e=0;i<n;i++) {
				if(adjazenzmatrix[i][e] != 0) {
					knoten[i].naechsterHinzufuegen(knoten[e],i);
				}
			}
		}
	}

}
