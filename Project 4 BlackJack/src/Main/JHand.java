package Main;


import java.util.LinkedList;

public class JHand {

private LinkedList<Cards> hand;

public JHand()
{
hand = new LinkedList<Cards>();
}
public void addCard(Cards card)
{
	hand.add(card);
}
public void emptyHand()
{
hand.clear();
}
public int getHandValue()
{
return 0;
}





}
