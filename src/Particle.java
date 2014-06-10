import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class Particle 
{
	private double radius;

	private Color color;

	private double xCoord;
	private double yCoord;

	private double xAcc;
	private double yAcc;
	private double xVel;
	private double yVel;

	private double mass;

	//MAKE AN ACCELERATION AND VELOCITY CLASS
	public Particle(double rad,Color c,double xCoord, double yCoord,double xV,double yV)
	{
		this.radius = rad;
		this.color = c;
		this.xCoord = xCoord;
		this.yCoord = yCoord;

		this.xAcc = 0;
		this.yAcc = 0;
		this.xVel = xV;
		this.yVel = yV;

		this.mass = 10; //DEFAULT VALUE
	}

	public void drawParticle(Graphics g)
	{
		Color cOld = g.getColor();
		g.setColor(color);
		g.fillOval((int)(xCoord-radius+0.5), (int)(yCoord-radius+0.5), (int)(radius*2+0.5), (int)(radius*2+0.5));
		g.setColor(cOld);
	}

	public void act(ArrayList<Force> forces)
	{
		xAcc = 0;
		yAcc = 0;
		for(Force f:forces)
		{
			//Point2D.Double accel = f.getAcceleration();
			xAcc+=f.getAccelX();
			yAcc+=f.getAccelY();
		}
		xVel+=xAcc;
		yVel+=yAcc;
		xCoord+=xVel;
		yCoord+=yVel;
	}

	public Point2D.Double getCenterPoint()
	{
		return new Point2D.Double(xCoord,yCoord);
	}

	public double getCenterX()
	{
		return xCoord;
	}
	public double getCenterY()
	{
		return yCoord;
	}

	public double getMass()
	{
		return mass;
	}



}
