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
	private Datenelement vorgaenger;
	private int id;
	
	public Datenelement(String ort,int id) {
		this.ort=ort;
		this.id=id;
		entfernung = 0;
		vorgaenger=null;
	}
	public String toString() {
		return ort;
	}
	public int getEntfernung(){
		return entfernung;
	}
	public void setEntfernung(int i) {
		entfernung = i;
	}
	public void setVorgaenger(Datenelement v) {
		vorgaenger = v;
	}
	public Datenelement getVorgaenger() {
		return vorgaenger;
	}
	public int getId() {
		return id;
	}
}
