import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel
{
	private JLabel status;
	
	public StatusPanel()
	{
		status = new JLabel("Welcome to Tic Tac Toe!");
		setBorder(BorderFactory.createEtchedBorder());
		add(status);
	}
	
	public void update(String newText)
	{
		status.setText(newText);
	}
}