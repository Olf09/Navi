import java.awt.List;

/**
 * 
 */

/**
 * @author deimlf
 *
 */
public class Ausgabe {
	private String[] zwischenziel;
	private int strecke;
	
	public Ausgabe(List zwischenziel, int strecke) {
		this.zwischenziel = new String[zwischenziel.getItemCount()];
		for(int i=0;i<zwischenziel.getItemCount();i++) {
			this.zwischenziel[i]=zwischenziel.getItem(i);
		}
		this.strecke=strecke;
	}
}
