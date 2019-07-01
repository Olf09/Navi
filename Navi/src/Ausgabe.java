import java.util.List;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author deimlf
 *
 */
public class Ausgabe {
	private ArrayList<Datenelement> zwischenziel;
	private int strecke;
	
	public Ausgabe(List<Datenelement> zwischenziel, int strecke) {
		zwischenziel = new ArrayList<Datenelement>();
		this.strecke=strecke;
	}
	public int getStrecke() {
		return strecke;
	}
}
