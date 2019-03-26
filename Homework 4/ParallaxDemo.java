import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParallaxDemo
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Parallax Demo");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		SquarePanel square1 = new SquarePanel();
		CirclePanel circle1 = new CirclePanel();
		frame.add(square1);
		frame.add(circle1, 1);
		
		frame.setSize(300, 300); // set frame size
		frame.setVisible(true); // display frame
		//test edit
	}
}
