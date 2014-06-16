import java.awt.geom.Point2D;
import java.math.*;
import java.util.*;


public class World 
{
	private double gravity;
	private ArrayList<GravityBall> gBalls;

	private ArrayList<Particle> particles;
	private BigDecimal worldSpeed;  // speed in miliseconds
    

	public World(BigDecimal speed)
	{
		this.worldSpeed = speed;
		gravity = 0.0; //  6 m/s
		gravity = gravity/1000 * worldSpeed.doubleValue();

		gBalls = new ArrayList<GravityBall>();
	}


	//GETS THE ALL FORCES ACTING ON A POINT
	public ArrayList<Force> getForces(Particle p)
	{

		//	Double G_CONS = 6.67384 * 10E11;
		//	Double G_CONS = 6.67384 ;

		Point2D.Double c1 = p.getCenterPoint();
		ArrayList<Force> forces = new ArrayList<Force>();
		forces.add(new Force(0,gravity,p.getMass()));   //default gravity force	
		
																											
		for(GravityBall gBall:gBalls)
		{
			Point2D.Double c2 = gBall.getCenterPoint();
			
			double r = c1.distance(c2);
			double cY = c2.getY()-c1.getY();
			double cX = c2.getX()-c1.getX();
			double theta = Math.asin(cY/r);

			double accel = gBall.getNetAcceleration();

			if((cY<0 && cX<0))
			{	
				theta = Math.PI-theta;
			}
			if(cY>0 && cX<0)
			{
				theta = Math.PI-theta;
			}

			double aX = accel*Math.cos(theta);
			double aY = accel*Math.sin(theta);

			forces.add(new Force(aX,aY,p.getMass()));
		}


		return forces;
	}
	public void addGravityBall(GravityBall gBall)
	{
		gBalls.add(gBall);
	}
	
	public ArrayList<GravityBall> getGravityBalls()
	{
		return gBalls;
	}


}
