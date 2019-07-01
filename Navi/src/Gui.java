import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Canvas;
import java.sql.*;

public class Gui {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Ausgabe ausgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:postgresql://unterricht01.gym-friedberg.de/q11","q11info3", "q11info3");
		
			Statement myStmt = myConn.createStatement();
		
			ResultSet myRs = myStmt.executeQuery("select * from stadt;");
			
			int n = 5;
			Graph g = new Graph(n);
			for(int i=0;i<n;i++) {
				myRs.next();
				g.knotenHinzufuegen(i, new Knoten(new Datenelement(myRs.getString("ort"),0),n));
			}
			
			
			myRs = myStmt.executeQuery("select * from routen;");

			int m = 6;
			for(int i =0;i<m;i++) {
				myRs.next();
				Datenelement f = new Datenelement(null,0);
				for(int e =0;e<n;e++) {
					if(g.getKnoten(e).getElement().getId()==myRs.getInt("start"))
						f=g.getKnoten(e).getElement();
				}
				Datenelement k = new Datenelement(null,0);
				for(int e =0;e<n;e++) {
					if(g.getKnoten(e).getElement().getId()==myRs.getInt("ziel"))
						k=g.getKnoten(e).getElement();
				}
				g.kanteEinfuegen(f, k, myRs.getInt("strecke"));
				g.kanteEinfuegen(k, f, myRs.getInt("strecke"));
			}

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		}
	

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Navi");
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSuchen = new JButton("Route berechnen");
		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Graph(5).auslesen(textField.getText() ,textField_1.getText());
				JLabel[] f = new JLabel[10];
				for(int i=0; i<10; i++) {
				f[i]=new JLabel("Für"+Ausgabe.getZwischenziel(i).getEntfernung()+"in Richtung"+Ausgabe.getZwischenziel(i).toString());
				f[i].setBounds(300, 50+150*i, 300, 100);
				frame.getContentPane().add(f[i]);
				}
				frame.getContentPane().repaint();
			}
		});
		btnSuchen.setBounds(42, 224, 150, 23);
		frame.getContentPane().add(btnSuchen);
		
		textField = new JTextField();
		textField.setBounds(42, 74, 150, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(42, 156, 150, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setBounds(42, 49, 46, 14);
		frame.getContentPane().add(lblStart);
		
		JLabel lblZiel = new JLabel("Ziel");
		lblZiel.setBounds(42, 131, 46, 14);
		frame.getContentPane().add(lblZiel);
	}
	
}
