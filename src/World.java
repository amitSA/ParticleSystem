import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.math.*;
import java.util.*;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class World extends Rectangle2D.Float
{
	private double gravity;
	private ArrayList<GravityBall> gBalls;
	private ArrayList<MovingParticle> movParticles;
	
	public  int [] clearArray;
	public  int [] rasterArray;
    private BufferedImage image;
    
    
 
	
    
	public World(JPanel p) 
	{
		super(0,0,1000,1000);  //default values
		gravity = 0.0; //  6 m/s
		gravity = gravity/1000.0;
		gBalls = new ArrayList<GravityBall>();
		movParticles = new ArrayList<MovingParticle>();
		
		image = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
		rasterArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		clearArray = new int[rasterArray.length];
		
		
		ComponentAdapter adapt = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				
				JComponent comp = (JComponent)e.getSource();
				int width = Math.max(comp.getWidth(),1), height = Math.max(comp.getHeight(),1);
				
				System.out.println("width: " + width + "     height: " + height);
				
				World.this.setRect(0, 0, width, height);
				image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
				rasterArray = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
				clearArray = new int[rasterArray.length];
				
				System.out.println("image width: " + image.getWidth() + "     image height: " + image.getHeight());
			}
		};
		p.addComponentListener(adapt);
	}
	
	public void addParticle(Particle p)
	{
		if(p instanceof MovingParticle)
			movParticles.add((MovingParticle)p);
		else if(p instanceof GravityBall)
			gBalls.add((GravityBall)p);
	}
	
	public void clearWorld()
	{
		movParticles.clear();
		gBalls.clear();
	}
	
	public void act()
	{
		
		for(int i = 0; i<movParticles.size();i++)
		{
			Particle p = movParticles.get(i);
			if(!p.act()){
				movParticles.remove(i);
				i--;
			}
		}
		for(int i = 0; i<gBalls.size();i++)
		{
			Particle p = gBalls.get(i);
			if(!p.act()){
				gBalls.remove(i);
				i--;
			}
		}
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(image, (int)this.x, (int)this.y,null);  // technically x and y are both equal to 0
	    System.arraycopy(clearArray,0, rasterArray, 0, clearArray.length);
	}
	
	public BufferedImage getWorldImage(){ return image; }
	
	public ArrayList<GravityBall> getGravityBalls(){ return gBalls; }
	
	public ArrayList<MovingParticle> getMovingParticles() { return movParticles; }


}
