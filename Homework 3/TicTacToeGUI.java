import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JFrame
{
	private PlayerSection player1;		   // Player 1 statistics
	private PlayerSection player2;		   // Player 2 statistics
	private TicTacToeGrid grid;			   // 3x3 game grid
	private StatusPanel status;			   // Turn status
	private JPanel buttonPanel;			   // To hold the buttons
	private JButton newGameButton;		   // New game button
	private JButton resetButton;		   // Reset button
	private JButton exitButton;			   // Exit button
	private final int WINDOW_WIDTH = 500;  // Window width
	private final int WINDOW_HEIGHT = 500; // Window height
	private int p1Wins = 0;
	private int p1Losses = 0;
	private int p2Wins = 0;
	private int p2Losses = 0;
	
	public TicTacToeGUI()
	{
		// Display a title.
		setTitle("Tic Tac Toe");
		
		// Set the size of the window.
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a BorderLayout manager.
		setLayout(new BorderLayout());
		
		// Create the custom panels
		player1 = new PlayerSection("Player 1", "Player 1 (X):");
		player2 = new PlayerSection("Player 2", "Player 2 (O):");
		grid = new TicTacToeGrid();
		status = new StatusPanel();
		
		// Create the button panel
		buildButtonPanel();
		
		// Add the components to the content pane
		add(player1);
		add(player2);
		add(grid);
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
	
	private class NewGameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			player1.nameLock();
			player2.nameLock();
			
			// Enable TicTacToeGrid
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
				player1 = new PlayerSection("Player 1", "Player 1 (X):");
				player2 = new PlayerSection("Player 2", "Player 2 (O):");
				grid = new TicTacToeGrid();
				status = new StatusPanel();
				
				p1Wins = 0;
				p1Losses = 0;
				p2Wins = 0;
				p2Losses = 0;
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
	
	public static void main(String[] args)
	{
		new TicTacToeGUI();
	}
}