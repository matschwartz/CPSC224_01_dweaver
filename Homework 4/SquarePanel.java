import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

class SquarePanel extends JPanel
{
	private int defaultX = 120; //SquarePanel's X position when initialized
	private int defaultY = 120; //SquarePanel's Y position when initialized
	private int X = defaultX;
	private int Y = defaultY;
	private int width = 60; // width of rectangle
	private int height = 60; // height of rectangle
	
	public SquarePanel()
	{
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor (Color.black);
		g.drawRect(X, Y, width, height);
	}
	
	private class MyMouseListener implements MouseListener
	{
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		X = defaultX;
		Y = defaultY;
		
		repaint();
	}
	}
	
	private class MyMouseMotionListener implements MouseMotionListener
	{
	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		X = e.getX() - 30;
		
		repaint();
		//can be scaled
	}
	}
}