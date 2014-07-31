import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.*;


public class MovingParticle extends Particle
{
	private float radius;
	private float xAcc;
	private float yAcc;
	private float xVel;
	private float yVel;


	//MAKE AN ACCELERATION AND VELOCITY CLASS
	public MovingParticle(World w,float xC, float yC,Color c,float xV,float yV,float rad)
	{
		super(w,xC,yC,c);
		this.radius = rad;
		this.xAcc = 0;
		this.yAcc = 0;
		this.xVel = xV;
		this.yVel = yV;
		
		
	}

	public void drawParticle(Graphics g)
	{
		Color cOld = g.getColor();
		g.setColor(getColor());
		g.fillRect((int)(xCoord-radius+0.5), (int)(yCoord-radius+0.5), (int)(radius*2+0.5), (int)(radius*2+0.5));
		g.setColor(cOld);
	}
	
	public void draw(Graphics g)
	{
		//NOTHING IN HERE YET
	}

	public boolean act()
	{ 
		 ArrayList<GravityBall> gBalls = this.getWorld().getGravityBalls();
		 xAcc = 0;yAcc = 0;
		 for(GravityBall gBall:gBalls)
			{
				Point2D.Float c2 = gBall.getCenterPoint();
				
				Point2D.Float c1 = this.getCenterPoint();
				double r = c1.distance(c2);
				double cY = c2.getY()-c1.getY();
				double cX = c2.getX()-c1.getX();
				double theta = Math.asin(cY/r);

				double accel = gBall.getNetAcceleration();

				if((cY<0 && cX<0) | (cY>0 && cX<0))
					theta = Math.PI-theta;
		
				xAcc += accel*Math.cos(theta);
				yAcc += accel*Math.sin(theta);
			}
		 xVel+=xAcc;
	     yVel+=yAcc;
		 xCoord+=xVel;
		 yCoord+=yVel;
		// image.getRaster().getDataBuffer()).getData();
		 BufferedImage image = this.getWorld().getWorldImage();
		 if(xCoord >=image.getWidth() || yCoord >=image.getHeight() || xCoord < 0 || yCoord < 0)
			 return false;
		 int [] particleRaster = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		 particleRaster[(int)(yCoord)*image.getWidth() + (int)xCoord]= -6351356;
		 return true;
	}
}
