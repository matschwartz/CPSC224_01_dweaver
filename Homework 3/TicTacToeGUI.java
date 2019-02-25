//package assignment3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
	private PlayerSection player1;		   // Player 1 statistics
	private PlayerSection player2;		   // Player 2 statistics
	private StatusPanel status;			   // Turn status
	private JPanel buttonPanel;                 // To hold the buttons
        private JPanel gridPanel;
	private JButton newGameButton;		   // New game button
	private JButton resetButton;		   // Reset button
	private JButton exitButton;			   // Exit button
	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	private int p1Wins = 0;
	private int p1Losses = 0;
	private int p2Wins = 0;
	private int p2Losses = 0;
	
        private JButton c0r0;
        private JButton c1r0;
        private JButton c2r0;
        private JButton c0r1;
        private JButton c1r1;
        private JButton c2r1;
        private JButton c0r2;
        private JButton c1r2;
        private JButton c2r2;
        private ButtonGroup bg;
        private String [][] gridArray = new String [3][3];
        private boolean gridEnabled = true;
        int turns = 0;
	// build bg panel and move over stuff and maek action listener
	public TicTacToeGUI()
	{
		// Display a title.
		setTitle("Tic Tac Toe");
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a BorderLayout manager.
		setLayout(new BorderLayout());
		
		// Create the custom panels
		player1 = new PlayerSection("Player 1", "Player 1 (X):");
		player2 = new PlayerSection("Player 2", "Player 2 (O):");
		status = new StatusPanel();
		
		// Create the button panel
		buildButtonPanel();
                buildGridPanel();
		
		// Add the components to the content pane
		add(player1);
		add(player2);
		add(gridPanel);
		add(buttonPanel);
		add(status);
		
		// Pack the contents of the window and display it.
		pack();
		setVisible(true);
	}
	
	private void buildButtonPanel()
	{
		buttonPanel = new JPanel();
		
		newGameButton = new JButton("New Game");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");
		
		newGameButton.addActionListener(new NewGameButtonListener());
		resetButton.addActionListener(new ResetButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(resetButton);
		buttonPanel.add(exitButton);
	}
        
        private void buildGridPanel()
        {
            gridPanel = new JPanel();
            setLayout(new GridLayout(6,6));
        
            c0r0 = new JButton();
            c1r0 = new JButton();
            c2r0 = new JButton();
            c0r1 = new JButton();
            c1r1 = new JButton();
            c2r1 = new JButton();
            c0r2 = new JButton();
            c1r2 = new JButton();
            c2r2 = new JButton();

            bg = new ButtonGroup();
            bg.add(c0r0);
            bg.add(c1r0);
            bg.add(c2r0);
            bg.add(c0r1);
            bg.add(c1r1);
            bg.add(c2r1);
            bg.add(c0r2);
            bg.add(c1r2);
            bg.add(c2r2);

            c0r0.addActionListener(new GridButtonListener());
            c0r1.addActionListener(new GridButtonListener());
            c0r2.addActionListener(new GridButtonListener());
            c1r0.addActionListener(new GridButtonListener());
            c1r1.addActionListener(new GridButtonListener());
            c1r2.addActionListener(new GridButtonListener());
            c2r0.addActionListener(new GridButtonListener());
            c2r1.addActionListener(new GridButtonListener());
            c2r2.addActionListener(new GridButtonListener());

            add(c0r0);
            add(c1r0);
            add(c2r0);
            add(c0r1);
            add(c1r1);
            add(c2r1);
            add(c0r2);
            add(c1r2);
            add(c2r2);
        }
        
        private class GridButtonListener implements ActionListener
        {
           public void actionPerformed(ActionEvent e)
           {
               JButton button = (JButton) e.getSource();
               if (gridEnabled == true)
        	   {
        		   int winResult;
                           if(turns%2 == 0)
                           {
                              button.setText("X");// figure out how to change for each player
                              fillArray(button,"X");
                              status.update(player2.getName() + "'s turn");
                           }
                           else
                           {
                              button.setText("O");// figure out how to change for each player
                              fillArray(button, "O");
                              status.update(player1.getName() + "'s turn");
                           }
        		   winResult = winConditions(gridArray , turns);
        		   if(winResult == 1)
        		   {
        			   status.update(player1.getName() + " wins!");
        			   gridEnabled = false;
                                   p1Wins++;
                                   player1.setWins(p1Wins);
                                   p2Losses++;
                                   player2.setLosses(p2Losses);
        			   turns = 0;
        		   }
        		   else if (winResult == 2)
        		   {
        			   status.update(player2.getName() + " wins!");
        			   gridEnabled = false;
                                   p2Wins++;
                                   player2.setWins(p2Wins);
                                   p1Losses++;
                                   player1.setLosses(p1Losses);
        			   turns = 0;
        		   }
        		   else if (winResult == 3)
        		   {
        			   status.update("Draw!");
        			   gridEnabled = false;
        			   turns = 0;
        		   }
        		   else
        			   turns++;
        	   }
           }
       }
        
	private class NewGameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.nameLock();
			player2.nameLock();
                        clearGrid();
                        gridArray = new String[3][3];
                        gridEnabled = true;
                        turns = 0;
            status.update(player1.getName() + "'s turn");
		}
	}
	
	private class ResetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int choice = JOptionPane.showOptionDialog(null,
			"This will end the game and set the win/loss stats to 0. Are you sure?",
			"Are you sure?",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null, null, null);
			if (choice == JOptionPane.YES_OPTION)
			{
				player1.setName("Player 1");
				player1.nameUnlock();
				player2.setName("Player 2");
				player2.nameUnlock();
				status.update("Welcome to Tic Tac Toe!");
				
				p1Wins = 0;
				player1.setWins(p1Wins);
				p1Losses = 0;
				player1.setLosses(p1Losses);
				p2Wins = 0;
				player2.setWins(p2Wins);
				p2Losses = 0;
				player2.setLosses(p2Losses);
                                clearGrid();
                                turns = 0;
			}
		}
	}
	
	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
        
        public void displayWin(String winner)
        {
            winner = winner + " is the Winner!";
           status.update(winner);
        }
        
        public void clearGrid()
        {
           c0r0.setText(null);
           c0r1.setText(null);
           c0r2.setText(null);
           c1r0.setText(null);
           c1r1.setText(null);
           c1r2.setText(null);
           c2r0.setText(null);
           c2r1.setText(null);
           c2r2.setText(null);
        }
        public String[][] fillArray(JButton button1, String mark)
        {
            String[][] markedGrid = gridArray;
            if(c0r0 == button1)
                gridArray[0][0] = mark;
            else if(c0r1== button1)
                gridArray[0][1] = mark;
            else if(c0r2== button1)
                gridArray[0][2] = mark;
            else if(c1r0== button1)
                gridArray[1][0] = mark;
            else if(c1r1== button1)
                gridArray[1][1] = mark;
            else if(c1r2== button1)
                gridArray[1][2] = mark;
            else if(c2r0== button1)
                gridArray[2][0] = mark;
            else if(c2r1== button1)
                gridArray[2][1] = mark;
            else if(c2r2== button1)
                gridArray[2][2] = mark;
            else
                gridArray[0][0] = "";
            return markedGrid;
        }
        
        // Usage: int i = winConditions(r1c1.getText(), r1c2.getText(), r1c3.getText(), r2c1.getText(), 
        //r2c2.getText(), r2c3.getText(), r3c1.getText(), r3c2.getText(), r3c3.getText(), turns)
        public int winConditions(String[][]array, int turn)
        {
                // X win conditions
                if (
                // Horizontal
                (array[0][0] == "X" && array[0][1] == "X" && array[0][2] == "X")
                ||
                (array[1][0] == "X" && array[1][1] == "X" && array[1][2] == "X")
                ||
                (array[2][0] == "X" && array[2][1] == "X" && array[2][2] == "X")
                ||
                // Vertical
                (array[0][0] == "X" && array[1][0] == "X" && array[2][0] == "X")
                ||
                (array[0][1] == "X" && array[1][1] == "X" && array[2][1] == "X")
                ||
                (array[0][2] == "X" && array[1][2] == "X" && array[2][2] == "X")
                ||
                // Diagonal
                (array[0][0] == "X" && array[1][1] == "X" && array[2][2] == "X")
                ||
                (array[0][2] == "X" && array[1][1] == "X" && array[2][0] == "X")
                )
                        return 1;

                // O win conditions
                else if (
                // Horizontal
                (array[0][0] == "O" && array[0][1] == "O" && array[0][2] == "O")
                ||
                (array[1][0] == "O" && array[1][1] == "O" && array[1][2] == "O")
                ||
                (array[2][0] == "O" && array[2][1] == "O" && array[2][2] == "O")
                ||
                // Vertical
                (array[0][0] == "O" && array[1][0] == "O" && array[2][0] == "O")
                ||
                (array[0][1] == "O" && array[1][1] == "O" && array[2][1] == "O")
                ||
                (array[0][2] == "O" && array[1][2] == "O" && array[2][2] == "O")
                ||
                // Diagonal
                (array[0][0] == "O" && array[1][1] == "O" && array[2][2] == "O")
                ||
                (array[0][2] == "O" && array[1][1] == "O" && array[2][0] == "O")
                )
                        return 2;
                // Draw
                else if (turns == 8)
                        return 3;
                else 
                       return 0;
        }
    	
    	public static void main(String[] args)
    	{
    		new TicTacToeGUI();
    	}
}