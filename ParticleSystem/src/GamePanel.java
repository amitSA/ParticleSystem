
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
	
	//these variables are static since they arn't really properties of the GamePanel
	public static long startTime;
    public static int fps;
	

	/*public static int [] clearArray;
	public static int [] rasterArray;
    private BufferedImage image;*/
	//MAKE A SEPARATE MOUSEWHEELTHING CLASS, more cohesion


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
	  
		
		timer = new Timer(15,this);  //technically 1 milisecond is too fast, in reality it is actually around 5
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
		
		g.setColor(Color.WHITE);
	    g.drawString(world.getMovingParticles().size()+"",30, 10);
	    g.drawString("FPS: " + fps,30,30);
	}

	public void actionPerformed(ActionEvent e) 
	{
		long endTime = System.currentTimeMillis();
		fps = (int)(1000/(endTime - startTime) + 0.5);
		startTime = endTime;
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
