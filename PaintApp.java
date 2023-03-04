import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PaintApp extends JFrame implements ActionListener, MouseListener {

	
	BorderLayout bl;
	protected static int x;
	protected static int y;
	protected static boolean control = false;
	protected static int temp = 0;
	
	protected static ArrayList<Points> squares = new ArrayList<Points>(); 
	protected static ArrayList<Points> circles = new ArrayList<Points>(); 
	protected static ArrayList<Points> lines = new ArrayList<Points>(); 
	
	
	public PaintApp() { //Constructor
		super("Whiteboard Application");
		bl = new BorderLayout();
		setLayout(bl);
		
		
		menu();
		center();
	}
	
	JMenuBar jmb;
	JMenu shape, exit;
	JMenuItem square_sbm, circle_sbm, line_sbm, hand_sbm, exit_sbm;
	
	public void menu() {
		jmb = new JMenuBar();
		
		shape = new JMenu("Shapes");
		exit = new JMenu("Exit");
		
		square_sbm = new JMenuItem("Square");
		square_sbm.addActionListener(this);
		
		circle_sbm = new JMenuItem("Circle");
		circle_sbm.addActionListener(this);
		
		line_sbm = new JMenuItem("Line");
		line_sbm.addActionListener(this);
		
		
		hand_sbm = new JMenuItem("Raise Hand");
		hand_sbm.addActionListener(this);
		
		exit_sbm = new JMenuItem("Exit");
		exit_sbm.addActionListener(this);
		
		shape.add(square_sbm);
		shape.add(circle_sbm);
		shape.add(line_sbm);
		exit.add(exit_sbm);
		
		jmb.add(shape);
		jmb.add(exit);
		
		add(jmb);
		setJMenuBar(jmb);
	}
	

	
	JPanel jpCenter;
	public void center() {
		jpCenter = new PaintPanel();
		jpCenter.addMouseListener(this);
		jpCenter.setBackground(Color.white);
		add(jpCenter, BorderLayout.CENTER);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (control == false) {
			x = e.getX();
			y = e.getY();
		}else if(control == true && temp == 0) {
			Points p = new Points();
			p.x = e.getX();
			p.y= e.getY();
			squares.add(p);
		}else if(control == true && temp == 1) {
			Points p = new Points();
			p.x = e.getX();
			p.y = e.getY();
			circles.add(p);
		}else if(control == true && temp == -1) {
			Points p = new Points();
			p.x = e.getX();
			p.y = e.getY();
			lines.add(p);
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == square_sbm) {
			control = true;
			temp = 0;
		}else if(e.getSource() == circle_sbm) {
			control = true;
			temp = 1;
		}else if(e.getSource() == line_sbm) {
			control = true;
			temp = -1;
		}else if(e.getSource() == exit_sbm) {
			System.exit(0);
		}
		
		
	}

}
