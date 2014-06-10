import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Particle System");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setResizable(true);
		
		GamePanel gamePanel = new GamePanel();
		frame.add(gamePanel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
