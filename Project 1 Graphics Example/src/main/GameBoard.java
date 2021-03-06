package main;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GameBoard extends JComponent implements MouseListener{
private static final long serialVersionUID = 22020202;
private int m_rows; 
private int m_columns; 
private Color m_color1;
private Color m_color2;
private Boolean [][] m_colorarray;
public GameBoard() 
{ 

m_rows = 10;
m_columns = 10; 
m_color1 = Color.BLACK;
m_color2 = Color.WHITE;
addMouseListener(this);
initializearray();
}
private void initializearray() 
{
m_colorarray = new Boolean[m_rows][m_columns];
Boolean iscolor1 = true;

	for(int y = 0; y < m_columns;y++)
	{ 
	for(int x = 0; x < m_rows;x++ )
	{
	
	m_colorarray[x][y] = iscolor1;
	iscolor1 = !iscolor1;
	}
	//Resets the first color in the row so it alternates
	iscolor1 = !iscolor1;
	}
}
public GameBoard(int rows, int columns , Color color1, Color color2)
{
	m_rows = rows;
	m_columns = columns; 
	m_color1 = color1;
	m_color2 = color2;	
	addMouseListener(this);
	initializearray();

}
public void paint(Graphics g)
{ 
Boolean colorblack = true;
for(int y = 0; y < m_columns;y++)
{ 
for(int x = 0; x < m_rows;x++ )
{
if(m_colorarray[x][y])
{
g.setColor(m_color1);
}
else 
{ 
g.setColor(m_color2);
}	
g.fillRect(50*(x),50*(y),50,50);
}

}



}

@Override
public void mouseClicked(MouseEvent e) {
	m_colorarray[e.getX()/ 50][e.getY() / 50] = !m_colorarray[e.getX()/ 50][e.getY() / 50];
	repaint();
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}
