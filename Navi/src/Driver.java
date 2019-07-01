/**
 * 
 */

/**
 * @author Florian
 *
 */
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection myConn = DriverManager.getConnection("jdbc:postgresql://unerricht01.gym-friedberg.de/q11","q11info3", "q11info3");
		
			Statement myStmt = myConn.createStatement();
		
			ResultSet myRs = myStmt.executeQuery("select * from stadt;");
		
			Graph g = new Graph(80);
			for(int i=0;i<80;i++) {
				myRs.next();
				g.knotenHinzufuegen(i, new Knoten(new Datenelement(myRs.getString("ort"),0),80));
			}
			
			System.out.println(g.getKnoten(1).getElement());
			/**
			ResultSet myRs = myStmt.executeQuery("select * from routen;");
			
			
			Graph g = new Graph(3);
			for(int i=0;i<3;i++) {
				myRs.next();
				g.knotenHinzufuegen(i, new Knoten(new Datenelement(null,myRs.getInt("start")),3));
			}
			myRs = myStmt.executeQuery("select * from routen;");
			for(int i =0;i<3;i++) {
				myRs.next();
				Datenelement f = new Datenelement(null,0);
				for(int e =0;e<3;e++) {
					if(g.getKnoten(e).getElement().getId()==myRs.getInt("start"))
						f=g.getKnoten(e).getElement();
				}
				Datenelement k = new Datenelement(null,0);
				for(int e =0;e<3;e++) {
					if(g.getKnoten(e).getElement().getId()==myRs.getInt("ziel"))
						k=g.getKnoten(e).getElement();
				}
				g.kanteEinfuegen(f, k, myRs.getInt("strecke"));
				g.kanteEinfuegen(k, f, myRs.getInt("strecke"));
			}
			Datenelement f = new Datenelement(null,0);
			for(int e =0;e<3;e++) {
				if(g.getKnoten(e).getElement().getId()==1)
					f=g.getKnoten(e).getElement();
			}
			Datenelement k = new Datenelement(null,0);
			for(int e =0;e<3;e++) {
				if(g.getKnoten(e).getElement().getId()==2)
					k=g.getKnoten(e).getElement();
			}
			g.dijkstra(f,k);
			System.out.println("hi");
			*/
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
