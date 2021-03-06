package Main;
import javax.swing.JFrame;
import enums.Cards;

public class Application extends JFrame {
private static final long serialVersionUID = -6138210723434867253L;
private JPlayer player;
private JDealer dealer;
private JDeck deck;
public Application()
{
deck = new JDeck(3);
player = new JPlayer();
dealer = new JDealer();
}
public void dealNewHand() 
{
System.out.println("Starting new Hand");

for(int x = 0; x < 2; x++)
{
Cards card = deck.getTopCard();
player.addCard(card);
card = deck.getTopCard();
dealer.addCard(card);
}
System.out.println("Player");
Cards[] cards = player.getCards();
for(int x = 0; x < cards.length; x++)
	System.out.println(cards[x]);
System.out.println(player.getHandScore());
System.out.println("");
System.out.println("Dealer");
cards = dealer.getCards();
System.out.println(cards[0]);
Boolean exit = false;
while (!exit)
{
String input = System.console().readLine("Do you want to hit? \n");

if(input.trim().equals("Yes"))
{
player.addCard(deck.getTopCard());

if(player.getHandScore() > 21)
	exit = true;
}
else 
 exit = true;
}
cards = player.getCards();
for(int x = 0; x < cards.length; x++)
	System.out.println(cards[x]);

System.console().readLine("Do you want to hit? \n");
}
public void InitWindow()
{

}
public static void main(String[] args)
{
Application app = new Application();
Window window = new Window();
//app.dealNewHand();
}
}