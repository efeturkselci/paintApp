import javax.swing.JFrame;
public class Source {

	public static MultiServer multiServer;

	public static void main(String[] args) {
		PaintApp pa = new PaintApp();
		pa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pa.setVisible(true);
		pa.setSize(800, 600);
		multiServer = new MultiServer();
	}
}