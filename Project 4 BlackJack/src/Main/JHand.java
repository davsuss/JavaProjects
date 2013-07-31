package Main;


import java.util.LinkedList;
import enums.Cards;

public class JHand {

protected LinkedList<Cards> hand;

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
int value = 0;
Cards[] cardarray = (Cards[]) hand.toArray(new Cards[hand.size()]);
for(Cards card : cardarray)
{
value += card.getValue();
}
return value;

}
public int getHandSize()
{
return hand.size();
}
public Cards[] getHand()
{
Cards[] card = (Cards[]) hand.toArray(new Cards[hand.size()]);
return card;
}

}
