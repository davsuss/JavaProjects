package Main;

import java.util.Collections;
import java.util.LinkedList;

public class JDeck {
public JDeck(int numberofDecks)
{
m_deck = new LinkedList<Cards>();
for(int x = 0; x < numberofDecks;x++)
   add52();
shuffle();
}
private LinkedList<Cards> m_deck;	
private void add52()
{
for(Cards card: Cards.values())
m_deck.add(card);

}
public void shuffle() 
{
Collections.shuffle(m_deck);
}
public Cards getTopCard()
{
return m_deck.pop();
}

}
