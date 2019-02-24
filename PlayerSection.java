import javax.swing.*;
import java.awt.*;

public class PlayerSection extends JPanel
{
	private JLabel nameLabel;
	private JLabel winsLabel;
	private JLabel lossesLabel;
	private JTextField name;
	private JTextField wins;
	private JTextField losses;
	
	public PlayerSection(String playerName, String panelName)
	{
		setLayout(new GridLayout(3, 2));
		nameLabel = new JLabel("Name: ");
		winsLabel = new JLabel("Wins: ");
		lossesLabel = new JLabel("Losses: ");
		
		name = new JTextField(playerName, 8);
		name.setEditable(true);
		wins = new JTextField("0", 8);
		wins.setEditable(false);
		losses = new JTextField("0", 8);
		losses.setEditable(false);
		
		setBorder(BorderFactory.createTitledBorder(panelName));
		
		add(nameLabel);
		add(name);
		add(winsLabel);
		add(wins);
		add(lossesLabel);
		add(losses);
	}
	
	public void setWins(int score)
	{
		wins.setText(Integer.toString(score));
	}
	
	public void setLosses(int score)
	{
		losses.setText(Integer.toString(score));
	}
	
	public void nameLock()
	{
		name.setEditable(false);
	}
	
	public void nameUnlock()
	{
		name.setEditable(true);
	}
}