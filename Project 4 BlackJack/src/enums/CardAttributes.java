package enums;

public enum CardAttributes {


Spades("Spades"),
Clovers("Clovers"),
Hearts("Hearts"),
Diamonds("Diamonds");
private String m_value;
CardAttributes(String value)
{
m_value = value;
}
public String getValue()
{
	return m_value;
}
	
	
	
}
