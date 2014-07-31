import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;


public abstract class Particle 
{
	private World world;
	private Color color;
	
	/*these are the only protected fields in for all Particles
	 * I made them protected since 20,000+ MovingParticles will be alive at a time, and calling the accessor and get methods
	 * for every MovingParticle would hurt efficiency
	 */
	protected float xCoord;
	protected float yCoord;
	
	//
	
	public Particle(World w,float xC,float yC,Color c)
	{
		this.world = w;
		this.xCoord = xC;
		this.yCoord = yC;
		this.color = c;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract boolean act();     // if this method returns false, then this particle is dead
	
	public World getWorld() { return world; }	
	
	public Color getColor() {return color; }
	
	public Point2D.Float getCenterPoint() {return new Point2D.Float(xCoord,yCoord);}
}