
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.math.*;
import java.util.ArrayList;


import javax.swing.*;


public class GamePanel extends JPanel implements ActionListener
{

	private Timer timer;
	private World world;
	private MouseInteraction mouseInter;
	
	private JButton refreshButton;
	/*WARNING: if this is changed while the program is running, then the speed in World will
	 also have to change as well*/

	
	/*public static int [] clearArray;
	public static int [] rasterArray;
    private BufferedImage image;*/
	//MAKE A SEPARATE MOUSEWHEELTHING CLASS, more cohesiox(i think)


	public GamePanel()
	{
		world = new World(this);
		mouseInter = new MouseInteraction(world);
		this.addMouseMotionListener(mouseInter);
		this.addMouseListener(mouseInter);

		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		refreshButton = new JButton("RefreshScreen");
		this.add(refreshButton);
		refreshButton.addActionListener(new ButtonInputHandler());
		//ADD A CHECK IN CLASS
		
	/*	image = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
		rasterArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		clearArray = new int[rasterArray.length];*/
	  
		
		timer = new Timer(1,this);  //technically 1 milisecond is too fast, in reality it is actually around 5
		timer.start();
		
	}
	
	public void act()
	{
		world.act();
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		world.draw(g);
	}

	public void actionPerformed(ActionEvent e) 
	{
		act();
		repaint();	
		
	}

	class ButtonInputHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(refreshButton))
				world.clearWorld();
		}
		
	}
	



}
