package main;
import javax.swing.*;

import java.awt.*;
public class Frame{
static JFrame frame;

public Frame()
{ 
frame = new JFrame("Testing Frame"); 
frame.add(new GameBoard());
frame.pack();
frame.setSize(505,525);
frame.setResizable(false);
frame.setVisible(true);
}


}
