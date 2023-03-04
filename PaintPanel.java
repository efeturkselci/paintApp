import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
		int squareCounter= 0;
		int circleCounter= 0;
		int lineCounter = 0;
		
		if(PaintApp.control == true) {
		if (PaintApp.temp == 1) {
			for (int j = 0; j<PaintApp.circles.size();j++)
			{
				g.drawOval(PaintApp.circles.get(j).x, PaintApp.circles.get(j).y, 70, 70);
				circleCounter +=1;
			}
			System.out.println("Circle count = " + circleCounter);
		}
		
		else if (PaintApp.temp == 0){
			for(int i = 0; i < PaintApp.squares.size(); i++) {
				g.drawRect(PaintApp.squares.get(i).x, PaintApp.squares.get(i).y, 120, 120);
				squareCounter++;
			}
			System.out.println("Square count = " + squareCounter);
		}
		else if(PaintApp.temp == -1) {
			for(int k = 0; k < PaintApp.lines.size(); k++) {
				g.drawLine(PaintApp.lines.get(k).x,PaintApp.lines.get(k).y , 200, 200);
				lineCounter = lineCounter + 1;
			}
			System.out.println("Line count = " + lineCounter);
		}
	}
		
}
	

}