/**
 * 
 */

/**
 * @author deimlf
 *
 */
public class Knoten {
	private Datenelement element;
	private Knoten[] naechster;
	private boolean besucht;
	private int n;
	
	public Knoten(Datenelement element,int n) {
		this.element=element;
		this.n =n;
		naechster=new Knoten[n];
		
	}
	public Datenelement getElement() {
		return element;
	}
	public void naechsterHinzufuegen(Knoten knoten, int index) {
		naechster[index]=knoten;
	}
	public Datenelement suche(Datenelement element) {
		Datenelement data = new Datenelement(null);
		if(element.equals(getElement())) {
			data=getElement();
		}
		else {
			besucht = true;
			for(int i=0;i<n;i++) {
				if(naechster[i].getBesucht()==false)
					naechster[i].suche(element);
		}
		}
		return null;
	}
	public void setBesucht(boolean i) {
		besucht=i;
	}
	public boolean getBesucht() {
		return besucht;
	}
}
