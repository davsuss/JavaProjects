package Main;
import javax.swing.JFrame;

public class Application extends JFrame {
private static final long serialVersionUID = -6138210723434867253L;
private JPlayer player;
private JDealer dealer;
private JDeck deck;
public Application()
{
deck = new JDeck(3);
System.out.println(deck.getTopCard());
}
public void dealNewHand() 
{

}

public static void main(String[] args)
{
Application app = new Application();
}
}