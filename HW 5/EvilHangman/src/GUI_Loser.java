import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class GUI_Loser implements ActionListener
{
    private JFrame parentFrame;
    private JFrame loserFrame;
    private JLabel secretWordLabel;
    private JLabel gameResultLabel;
    private JButton rtnBtn;

    public GUI_Loser(String Letters, JFrame frame)
    {
       
        parentFrame = frame;
        loserFrame = new JFrame("You are the loser!");
        loserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loserFrame.setSize(new Dimension(300,470));
        loserFrame.setLayout(new FlowLayout());
        
        secretWordLabel = new JLabel("The answer is "+Letters+".");
        gameResultLabel = new JLabel("You are the Loser!");
        rtnBtn = new JButton("Return to the main menu");
        
        rtnBtn.addActionListener(this); 
        
        ImageIcon icon = new ImageIcon("loser.gif"); 
        JLabel loserPic = new JLabel(icon);

        
        loserFrame.add(secretWordLabel);
        loserFrame.add(gameResultLabel);
        loserFrame.add(rtnBtn);
        loserFrame.add(loserPic);
        
        loserFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        loserFrame.dispose(); //close the window
        parentFrame.dispose(); // and the parent
    	new Start().createAndShowGUI(); // start over
    }
}