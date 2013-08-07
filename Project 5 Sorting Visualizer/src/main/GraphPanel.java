package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
private LinkedList<Integer> m_marked;
private ArrayList<Integer> m_array;
public GraphPanel(ArrayList<Integer> array)
{
m_array = array;
m_marked = new LinkedList<Integer>();
setSize(500,1000);
setBackground(Color.BLACK);

}
@Override
public void paint(Graphics g)
{
	int NumofElements = m_array.size();
	int width = 1000/NumofElements;
	g.setColor(Color.BLACK);
	g.fillRect(0,0,1000,500);
	for(int x = 0; x < NumofElements; x++){
	boolean marked = m_marked.contains(x);
	double ratio = m_array.get(x);ratio /= 100;
	if(!marked) g.setColor(Color.WHITE); else g.setColor(Color.RED);
	g.fillRect(0+10*x,500 -((int) (500*ratio)) ,width,(int) (500*ratio));
	g.setColor(Color.BLACK);
	g.drawRect(0+10*x,500 -((int) (500*ratio)) ,width,(int) (500*ratio));
	}
	
}
public void mark(int index)
{
if(index == -1)
	m_marked.clear();
else
	m_marked.add(index);

repaint();
}
}
