import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel
{
	private JLabel status;
	
	public StatusPanel()
	{
		status.setText("Welcome to Tic Tac Toe!");
	}
	
	public void update(String newText)
	{
		status.setText(newText);
	}
}