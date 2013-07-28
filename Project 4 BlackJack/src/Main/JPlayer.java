package Main;

public class JPlayer {
	private int chipCount;
	private JHand hand;
	public JPlayer()
	{
	chipCount = 500;
	hand = new JHand();
	}
	public int getChipCount()
	{
	return chipCount;
	}
	public void AddChips(int amount)
	{
	chipCount += amount;
	}
	public Boolean SubtractChips(int amount)
	{
	chipCount -= amount;
	return chipCount <= 0;
	}
	public void clearHand()
	{
	hand.emptyHand();
	}

}
