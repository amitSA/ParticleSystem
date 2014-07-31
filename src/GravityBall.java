import java.awt.*;
import java.awt.geom.Point2D;


public class GravityBall extends Particle
{	
	private float radius;
	private float netAccel;  //HARDCODED VALUE THAT WILL CHANGE IF THE ENGINESPEED IS CHANGED
	
	
	public GravityBall(World w, float xC, float yC,Color c,float netAccel, float r)
	{
		super(w,xC,yC,c);
		this.radius = r;
		this.netAccel = netAccel;
	}
	public void draw(Graphics g)
	{
		Color cOld = g.getColor();
		g.setColor(getColor());
		g.fillRect((int)(xCoord-radius+0.5), (int)(yCoord-radius+0.5), (int)(radius*2+0.5), (int)(radius*2+0.5));
		g.setColor(cOld);
	}
	
	public boolean act()
	{
		return true;
	}
	
	public double getNetAcceleration()
	{
		return netAccel;
	}
}
