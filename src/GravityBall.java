import java.awt.*;
import java.awt.geom.Point2D;


public class GravityBall 
{	
	private double radius;
	private Color color;
	private double netAccel;  //HARDCODED VALUE THAT WILL CHANGE IF THE ENGINESPEED IS CHANGED
	
	//center points
	private double xCoord;
	private double yCoord; 
	
	public GravityBall(double m,double r,Color c, double x, double y, double netAccel)
	{
		this.radius = r;
		this.color = c;
		this.xCoord = x;
		this.yCoord = y;
		this.netAccel = netAccel;
	}
	public void drawParticle(Graphics g)
	{
		Color cOld = g.getColor();
		g.setColor(color);
		g.fillOval((int)(xCoord-radius+0.5), (int)(yCoord-radius+0.5), (int)(radius*2+0.5), (int)(radius*2+0.5));
		g.setColor(cOld);
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
	
	public double getNetAcceleration()
	{
		return netAccel;
	}
	
	
}
