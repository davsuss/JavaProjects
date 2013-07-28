import java.awt.*;

import javax.swing.*;


public class CheckerBoard extends JFrame {


CheckerBoard() 
{ 
JLabel[][] mylabel = new JLabel[8][8];
for(int x = 0; x < 8; x++) 
{
for(int y = 0; y < 8; y++)
{
	mylabel[x][y] = new JLabel();
	mylabel[x][y].setOpaque(true);
}
}
JPanel panel = new JPanel(new GridLayout(8,8));
mylabel[0][0].setBackground(Color.BLACK);
mylabel[1][0].setBackground(Color.BLUE);
for(int x = 0; x < 8; x++) 
{
for(int y = 0; y < 8; y++)
{
	panel.add(mylabel[x][y]);
}
}

add(panel);
setVisible(true);


}
public static void main(String[] args)
{
CheckerBoard board = new CheckerBoard();
}


}
