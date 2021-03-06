package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Application implements ActionListener,Runnable{
private JGameBoard board;
private JButtonPanel buttons;
private Boolean ThreadRunning;
private Thread updateThread;
int iterationRate;
public Application() 
{ 
JFrame window = new JFrame(); 
board = new JGameBoard();
buttons = new JButtonPanel();
ThreadRunning = false;
iterationRate = 1000;
updateThread = new Thread(this);
window.setLayout(new BoxLayout(window.getContentPane(),BoxLayout.Y_AXIS));
window.setSize(550,550);
window.add(board,BorderLayout.PAGE_START);
window.add(buttons,BorderLayout.PAGE_END);
window.pack();
window.setVisible(true);
buttons.SetActionListener(this);

}

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Application application = new Application();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Next")
			board.Iterate();
		else if(arg0.getActionCommand() == "Start")
		{
		if(!ThreadRunning)	
		{
			System.out.println(updateThread.getState());
			if((updateThread.getState() == Thread.State.NEW))
					updateThread.start();
			else
			{
				try {
					updateThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				updateThread = new Thread(this);
				updateThread.start();
			}
			ThreadRunning = true;
		}
		else 
		{
			System.out.println("Exiting");
			ThreadRunning = false;
		}
		
		}
		else if(arg0.getActionCommand() == "comboBoxChanged")
		{
			@SuppressWarnings("unchecked")
			JComboBox<String[]> box = (JComboBox<String[]>) arg0.getSource();
			String s = (String) box.getSelectedItem();
			switch(s)
			{
			case "Slow":
				iterationRate = 1000;
				
			
			case "Fast":
				iterationRate = 750;
			    
			case "Fastest":
				iterationRate = 500;
				
			}
		}
		System.out.println(arg0.getActionCommand());

		
	}

	@Override
	public void run() {
		while(ThreadRunning)
		{
		board.Iterate();
		try {
			Thread.sleep(iterationRate);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		
		}
		
	}



}
