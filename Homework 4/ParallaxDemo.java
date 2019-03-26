package assignment.pkg4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @authors: Matthew Schwartz and Daneil Weaver
 * due date: March 25, 2019
 * assignment #4
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ParallaxDemo
{
	//This function create an object of type
	//parallax motion and adds it to a JFrame
	//to be displayed in a window
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Parallax Demo");
                JPanel square = new JPanel();
                JPanel circle = new JPanel();
                JPanel time = new JPanel();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		ParallaxMotion demo = new ParallaxMotion();
                
        frame.add(demo);
		
		frame.setSize(300, 300); // set frame size
		frame.setVisible(true); // display frame
	} 
        
}



class ParallaxMotion extends JPanel implements ActionListener
{
	//variables for the moving image
   private int delay = 75;
   protected Timer timer;
   private int Motionx = 300;	
   private int Motionradius = 15;
   private int Motiondx = 2;
   
   // variables for the outline of a red square
   private int SquareDefaultX = 120; //SquarePanel's X position when initialized
   private int SquareDefaultY = 120; //SquarePanel's Y position when initialized
   private int SquareX = SquareDefaultX;
   private int SquareY = SquareDefaultY;
   private int SquareWidth = 60; // width of rectangle
   private int SquareHeight = 60; // height of rectangle
   
   //variables for the yellow circle in the background
   private int CircledefaultX = 120; //SquarePanel's X position when initialized
   private int CircledefaultY = 35; //SquarePanel's Y position when initialized
   private int CircleX = CircledefaultX;
   private int CircleY = CircledefaultY;
   private int Circlewidth = 60; // width of rectangle
   private int Circleheight = 60; // height of rectangle

   //variables for the three grey rectangles
   private int rectanglesDefaultX = 110;
   private int rectanglesDefaultY = 100;
   private int rectanglesX = rectanglesDefaultX;
   private int rectanglesY = rectanglesDefaultY;
   private int rectanglesWidth = 80;
   private int rectanglesHeight = 40;
   
   // variables for the grass in the forground
   private int linesDefaultX = -150;
   private int linesDefaultYBegin = 210;
   private int linesDefaultYEnd = 220;
   private int linesX = linesDefaultX;
   private int linesYBegin = linesDefaultYBegin;
   private int linesYEnd = linesDefaultYEnd;
   
   // constructor for the class
   // initalizes timer and mouse listeners
   public ParallaxMotion()
   {
        timer = new Timer(delay, this);
	timer.start();	
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
   }

   // draws all of the shapes
   public void paintComponent( Graphics g )
   {
        super.paintComponent( g );
        
        //draws the yellow circle
        g.setColor (Color.YELLOW);
        g.fillOval(CircleX, CircleY, Circlewidth, Circleheight);
        
        // draws the three gery rectangles
        g.setColor(Color.GRAY);
        g.fillRect(rectanglesX, rectanglesY, rectanglesWidth, rectanglesHeight);
        g.fillRect(rectanglesX - 100, rectanglesY, rectanglesWidth, rectanglesHeight);
        g.fillRect(rectanglesX + 100, rectanglesY, rectanglesWidth, rectanglesHeight);
        
        // draws the red outline of a square
        g.setColor (Color.RED);
        g.drawRect(SquareX, SquareY, SquareWidth, SquareHeight);
        
        //draws all the lines for the grass
        g.setColor(Color.GREEN);
        for(int i = 0; i < 300; i++)
        {
        	g.drawLine(linesX + 2 * i, linesYBegin, linesX + 2 * i, linesYEnd);
        }
        
        // draws the moving blue ball 
        // also resets the ball when it reaches 
        // the other side of the panel
        g.setColor(Color.blue);
        if (Motionx == 0){
            Motionx=300;}
        Motionx -= Motiondx;
        g.fillOval(Motionx - (2*Motionradius), 100 , Motionradius*2, Motionradius*2);
   }
   
   public void actionPerformed(ActionEvent e)
   // will run when the timer fires
   // and repaints the images in their 
   // new positions based on the mouse
   {
	repaint();
   }

   // mouse listener class the takes the input from the mouse buttons
   // and determines what to do with the input
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
            // resets the image to the original postion
            // when the mouse leave the frame
            public void mouseExited(MouseEvent e) {
                    SquareX = SquareDefaultX;
                    SquareY = SquareDefaultY;
                    
                    CircleX = CircledefaultX;
                    CircleY = CircledefaultY;

                    rectanglesX = rectanglesDefaultX;
                    rectanglesY = rectanglesDefaultY;
                    
                    linesX = linesDefaultX;
                    linesYBegin = linesDefaultYBegin;
                    linesYEnd = linesDefaultYEnd;
                    
                    repaint();
            }
	}
	
        // takes input from the mouse movement and 
        // determines what to do with it
	private class MyMouseMotionListener implements MouseMotionListener
	{
            public void mouseDragged(MouseEvent e) {

            }
            // changes where the images are displayed
            // based on the x axis of the mouse
            public void mouseMoved(MouseEvent e) {
                    SquareX = e.getX() - 30;
                    CircleX = (e.getX() + 150) / 2 - 30;
                    rectanglesX = (int) ((e.getX() + 75) / 1.5 - 40);
                    linesX = (int) ((e.getX() - 30) / 0.8) - 300;
                    repaint();
                    //can be scaled
                    //formula: (e.getX() + 150 * (divisor - 1)) / divisor - width/2
            }
	}
   
}



