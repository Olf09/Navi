import java.awt.List;

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
		for(int i=0;i<n;i++) {
			for(int e=0;i<n;i++) {
				if(adjazenzmatrix[i][e] != 0) {
					knoten[i].naechsterHinzufuegen(knoten[e],i);
				}
			}
		}
	}
	public void kanteEinfuegen(Datenelement anfangsort, Datenelement zielort) {}
	private List dijkstra(Datenelement anfangsort, Datenelement zielort) {
		List liste = new List();
		for(int i =0;i<n;i++) {
			liste.add(knoten[i].getElement().toString());
		}
		for(int i=0;)
		return null;
	}
	public void favoritEinfuegen(Datenelement favorit) {}
	public void zuHauseEinfuegen(Datenelement zuHause) {}
	public void routeEinfuegen(Datenelement anfangsort, Datenelement zielort) {}
	public Ausgabe auslesen(Datenelement anfangsort, Datenelement zielort) {
		return null;	
	}
	public Datenelement suche(Datenelement element) {
		for(int i=0;i<n;i++) {
			knoten[i].setBesucht(false);
		}
		return knoten[0].suche(element);
		
	}
}
