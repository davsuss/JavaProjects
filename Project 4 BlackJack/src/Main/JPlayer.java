package Main;

import enums.Cards;

public class JPlayer {
	private int chipCount;
	protected JHand hand;
	public JPlayer()
	{
	chipCount = 0;
	hand = new JHand();
	}
	public void addCard(Cards card)
	{
	
	hand.addCard(card);
	
	}
	public int getChipCount()
	{
	return chipCount;
	}
	public void setChipCount(int amount)
	{
	chipCount = amount;
	}
	public void clearHand()
	{
	hand.emptyHand();
	}
	public Cards[] getCards()
	{
		Cards[] cards = hand.getHand();
		return cards;
	}
	public int getHandScore() {
	return hand.getHandValue();
		
	}
}
