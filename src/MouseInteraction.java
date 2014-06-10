import java.awt.Color;
import java.awt.event.*;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.event.*;





public class MouseInteraction implements MouseInputListener
{

	private World world;
	private ArrayList<Particle> particles;
	private boolean shouldRelease;

	public MouseInteraction(World world, ArrayList<Particle> particles)
	{
		this.world = world;
		this.particles = particles;
		shouldRelease = false;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {


	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) //CHECK	
			world.addGravityBall(new GravityBall(1,5,Color.GRAY,e.getX(),e.getY(),0.06));  //HARDCODED VALUE THAT SHOULD CHANGE IF 
		// ENGINE SPEED IS CHANGED
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
	//	System.out.println("sdfsdf");
		if(SwingUtilities.isRightMouseButton(e)) //CHECK	
		{
			double velCons = .12;
			for(int i = 0;i<30;i++)
			{
				double angle = Math.random()*Math.PI*2;
				double xV = Math.cos(angle)*velCons;
				double yV = Math.sin(angle)*velCons;
				int cX = (int)(Math.random()*11)-5;
				int cY = (int)(Math.random()*11)-5;
				particles.add(new Particle(1,new Color(50,205,50),e.getX()+cX,e.getY()+cY,xV,yV)); 
			}
			//particles.add(new Particle(2,new Color(50,205,50),e.getX(),e.getY())); 
		}


	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{

	}

}
