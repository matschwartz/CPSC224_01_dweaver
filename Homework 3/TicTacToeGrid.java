import javax.swing.*;
import java.awt.*;

public class TicTacToeGrid extends JPanel
{
	private JButton[] gridButton;
	
	public TicTacToeGrid()
	{
		setLayout(new GridLayout(3, 3));
		
		gridButton = new JButton[9];
		
		add(gridButton[0]);
		add(gridButton[1]);
		add(gridButton[2]);
		add(gridButton[3]);
		add(gridButton[4]);
		add(gridButton[5]);
		add(gridButton[6]);
		add(gridButton[7]);
		add(gridButton[8]);
	}
}