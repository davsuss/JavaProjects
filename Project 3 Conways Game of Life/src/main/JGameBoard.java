package main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class JGameBoard extends JComponent implements MouseListener, MouseMotionListener{
private JCell[][] m_lifeArray;
private int m_rows; 
private int m_columns;
private int m_length;
private boolean m_mouseClick;
private boolean m_mouseState;
JGameBoard() 
{
m_rows = 40;
m_columns = 40; 
m_length = 500/m_rows;
m_mouseClick = false;
setSize(500,500);
setPreferredSize(new Dimension(481,500));
m_lifeArray = new JCell[m_rows][m_columns];
for(int x =0; x < m_rows; x++)
	for(int y = 0 ; y < m_columns; y++)
		m_lifeArray[x][y] = new JCell();
addMouseListener(this);
addMouseMotionListener(this);
}
public void paint(Graphics g)
{

//Drawing the Grid
g.drawRect(0,0,m_length*m_rows,m_length*m_columns);
for(int y = 1; y <= m_rows; y++)
	g.drawLine(0,m_length*y,m_length*m_rows,m_length*y);
for(int x = 1; x <= m_rows; x++)
	g.drawLine(m_length*x,0,m_length*x,m_length*m_columns);
g.setColor(Color.YELLOW);
//Filling the Squares
// TODO: Finish filling
for(int x =0; x < m_rows; x++)
	for(int y = 0 ; y < m_columns; y++)
	{
	if(m_lifeArray[x][y].isAlive())
	{
	g.fillRect(m_length*x,m_length*y,m_length-1,m_length-1);
	}
	else
	{
	g.clearRect(m_length*x,m_length*y,m_length-1,m_length-1);
	}
	}


}
@Override
public void mouseClicked(MouseEvent arg0) {

}
@Override
public void mouseEntered(MouseEvent arg0) {
	
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	
	
}
@Override
public void mousePressed(MouseEvent arg0) 
{
m_mouseClick = true;
if((arg0.getX()/m_length < m_rows) && (arg0.getY()/m_length < m_columns) )
{
m_mouseState = !m_lifeArray[arg0.getX()/m_length][arg0.getY()/m_length].isAlive();
m_lifeArray[arg0.getX()/m_length][arg0.getY()/m_length].SetCurrentState(m_mouseState);
repaint();
}
}
@Override
public void mouseReleased(MouseEvent arg0) {

	
}
public void mouseDragged(MouseEvent arg0)
{
if(m_mouseClick)
{
	if((arg0.getX()/m_length < m_rows) && (arg0.getY()/m_length < m_columns) )
	{
	
	if(m_lifeArray[arg0.getX()/m_length][arg0.getY()/m_length].isAlive() != m_mouseState)
	{
		m_lifeArray[arg0.getX()/m_length][arg0.getY()/m_length].SetCurrentState(m_mouseState);
	}
	}
	repaint();
}
}
public void Iterate()
{
/*
  Any live cell with fewer than two live neighbours dies, as if caused by under-population.
  Any live cell with two or three live neighbours lives on to the next generation.
  Any live cell with more than three live neighbours dies, as if by overcrowding.
  Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction 
*/
	
for(int x =0; x < m_rows; x++)
	for(int y = 0 ; y < m_columns; y++)
	{
	 int NumberofAliveNeighbors = 0;
	  if(x != m_rows-1)
	  {
	  if(m_lifeArray[x+1][y].isAlive()) NumberofAliveNeighbors++;
	  if(y != 0)
      if(m_lifeArray[x+1][y-1].isAlive()) NumberofAliveNeighbors++;
      if(y != m_columns-1)
      if(m_lifeArray[x+1][y+1].isAlive()) NumberofAliveNeighbors++;
	  }
      if(x != 0)
      {
      if(m_lifeArray[x-1][y].isAlive()) NumberofAliveNeighbors++;
      if(y != 0)
       if(m_lifeArray[x-1][y-1].isAlive()) NumberofAliveNeighbors++;
      if(y != m_columns-1)
       if(m_lifeArray[x-1][y+1].isAlive()) NumberofAliveNeighbors++;	
      }
	  
      if(y != 0)
       if(m_lifeArray[x][y-1].isAlive()) NumberofAliveNeighbors++;
      if(y != m_columns-1)
       if(m_lifeArray[x][y+1].isAlive()) NumberofAliveNeighbors++;
	  
      
      
     if(m_lifeArray[x][y].isAlive())
     {
    	if(NumberofAliveNeighbors < 2 || NumberofAliveNeighbors >3)
    		m_lifeArray[x][y].SetNextState(false);
    	else
    		m_lifeArray[x][y].SetNextState(true);
    	
     }
     else
     {
    	if(NumberofAliveNeighbors ==3)
    		m_lifeArray[x][y].SetNextState(true);
    	else
    		m_lifeArray[x][y].SetNextState(false);
     }
     
	}
	
for(int x =0; x < m_rows; x++)
	for(int y = 0 ; y < m_columns; y++)	
		m_lifeArray[x][y].Iterate();
repaint();	
	
}
@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
