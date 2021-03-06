package main;

import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JButtonPanel extends JPanel 
{
JComboBox<String> m_speedBox;
private String[] m_speedStrings = {"Slow","Fast","Fastest"};
private JButton m_startandStop;
private JButton m_next;

public JButtonPanel()
{
m_speedBox = new JComboBox<String>(m_speedStrings);
m_startandStop = new JButton();
m_next = new JButton();
m_next.setSize(200,200);
m_next.setText("Next");
m_startandStop.setText("Start");
add(m_next);
add(m_startandStop);
add(m_speedBox);

}
public int GetUpdateTime()
{
	String s = (String) m_speedBox.getSelectedItem();
	switch(s)
	{
	case "Slow":
		return 1000;
		
	
	case "Fast":
	    return 750;
	    
	case "Fastest":
		return 500;
		
	}
	return 1000;
}
public void SetActionListener(ActionListener listener)
{
m_next.addActionListener(listener);
m_startandStop.addActionListener(listener);
m_speedBox.addActionListener(listener);
}



}
