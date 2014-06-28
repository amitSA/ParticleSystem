import java.awt.Color;
import java.awt.event.*;
import java.util.*;

import javax.swing.SwingUtilities;
import javax.swing.event.*;





public class MouseInteraction implements MouseInputListener
{

	private World world;

	public MouseInteraction(World world)
	{
		this.world = world;
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
			world.addParticle(new GravityBall(world,(float)e.getX(),(float)e.getY(),new Color(-1),0.06f,5f));  //radius doesnt really matter
	}//world.addGravityBall(new GravityBall(1,5,Color.GRAY,e.getX(),e.getY(),0.06));  //HARDCODED VALUE THAT SHOULD CHANGE IF  																		

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
	//	System.out.println("sdfsdf");
		if(SwingUtilities.isRightMouseButton(e)) //CHECK	
		{
			double velCons = .5;  //.12
			for(int i = 0;i<30;i++)
			{
				float angle = (float)(Math.random()*Math.PI*2);
				float xV = (float)(Math.cos(angle)*velCons);
				float yV = (float)(Math.sin(angle)*velCons);
				int cX = (int)(Math.random()*11)-5;
				int cY = (int)(Math.random()*11)-5; 
				world.addParticle(new MovingParticle(world,(float)(e.getX()+cX),(float)(e.getY()+cY),new Color(-6351356),xV,yV,angle));
			}
			//particles.add(new MovingParticle(1,new Color(50,205,50),e.getX()+cX,e.getY()+cY,xV,yV));
		}
	}
	@Override
	public void mouseMoved(MouseEvent arg0) 
	{

	}

}
