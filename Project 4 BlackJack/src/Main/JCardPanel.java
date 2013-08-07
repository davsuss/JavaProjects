package Main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import enums.Cards;
/**/
public class JCardPanel extends JPanel {
private LinkedList<Cards> m_cards;
public JCardPanel(int x, int y, int width, int height)
{
setBounds(x,y,width,height);
m_cards = new LinkedList<Cards>();
}
public void SetCards(Cards[] card)
{
if(card == null || card.length == 0)
{
	m_cards.clear();
	return;
}



}
@Override
protected void paintComponent(Graphics g)
{
super.paintComponent(g);
if(m_cards.size() == 0)
	return;

for(int i = 0; i < m_cards.size(); i++)
{
	Cards card =(Cards) m_cards.get(i);
	
	try {
		BufferedImage img = ImageIO.read(new File(card.getPath()));
		g.drawImage(img,100 + i*15,50,null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}





}
public void DrawCards(Cards[] cards,Boolean reveal)
{
m_cards.clear();
if(!reveal){
	System.out.println(cards[0]);
	m_cards.add(cards[0]);
	
}
else{
for(Cards card :cards)
{
	m_cards.add(card);
}
}
repaint();
}


}
