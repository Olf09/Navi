/**
 * 
 */

/**
 * @author deimlf
 *
 */
public class Datenelement {
	private String ort;
	private int entfernung;
	
	public Datenelement(String ort) {
		this.ort=ort;
		entfernung = 0;
	}
	public String toString() {
		return ort;
	}
	public int getEntfernung(){
		return entfernung;
	}
}
