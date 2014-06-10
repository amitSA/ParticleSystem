import java.awt.geom.*;


public class Force 
{
	private double accelX;
	private double accelY;
	private double mass;

	public Force(double aX,double aY, double m)
	{
		this.accelX = aX;
		this.accelY = aY;
		this.mass = m;
	}

	public double getAccelX()
	{
		return accelX;
	}
	public double getAccelY()
	{
		return accelY;
	}
	
	/*public Point2D.Double getAcceleration()
	{
		return new Point2D.Double(accelX,accelY);
	}*/
	
	public double getMass()
	{
		return mass;
	}

}
