
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
	private BigDecimal engineSpeed; // in miliseconds
	private MouseInteraction mouseInter;
	
	private JButton refreshButton;
	/*WARNING: if this is changed while the program is running, then the speed in World will
	 also have to change as well*/

	private ArrayList<Particle> particles;
	
//	private static int [] rasterArray;
//    private BufferedImage image;
	//MAKE A SEPARATE MOUSEWHEELTHING CLASS, more cohesiox(i think)


	public GamePanel()
	{
		particles = new ArrayList<Particle>();
		engineSpeed = new BigDecimal(1.0);
		world = new World(engineSpeed);
		mouseInter = new MouseInteraction(world,particles);
		this.addMouseMotionListener(mouseInter);
		this.addMouseListener(mouseInter);

		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		refreshButton = new JButton("RefreshScreen");
		this.add(refreshButton);
		refreshButton.addActionListener(new ButtonInputHandler());
		//ADD A CHECK IN CLASS
		
	//	image = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
	//	rasterArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
	  
		
		timer = new Timer(engineSpeed.intValue(),this);
		timer.start();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.BLACK);
		
		//g.drawImage(image,0,0,1000,1000,null);
		//g.drawImage(image, 0, 0, null);
		//System.out.println(image);
		g.setColor(Color.WHITE);
	    g.drawString(particles.size()+"",30, 10);
		for(Particle p:particles)
			p.drawParticle(g);
	}

	public void actionPerformed(ActionEvent e) 
	{
		//System.out.println(particles.size());
		for(int i = 0;i<particles.size();i++)
		{
			Particle p = particles.get(i);
			p.act(world.getForces(p));
			double x = p.getCenterX();double y = p.getCenterY();
			if(x<0 || x>this.getWidth() || y<0 || y>this.getHeight())
			{
				particles.remove(p);
				i--;
			}
		}
		repaint();
	}

	class ButtonInputHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(refreshButton))
			{
				particles.clear();
				world.getGravityBalls().clear();
			}
		}
		
	}
	



}
