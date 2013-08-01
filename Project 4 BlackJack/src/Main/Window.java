package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import enums.Cards;

public class Window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1582244068693279479L;
	private JPanel contentPane;
	private JLabel lblChipCount;
	private JButton btnNewHandgiveUp;
	private JButton btnHit;
	private JButton btnStay;
	private JPlayer player;
	private JDealer dealer;
	private JDeck deck;
	
	
	
	private void initWindow()
	{
		setTitle("BlackJack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBounds(10, 11, 188, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stats");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 168, 14);
		panel.add(lblNewLabel);
		
		lblChipCount = new JLabel("Chip Count");
		lblChipCount.setBounds(10, 36, 68, 14);
		panel.add(lblChipCount);
		
		JLabel lblBet = new JLabel("Bet");
		lblBet.setBounds(10, 61, 68, 14);
		panel.add(lblBet);
		
		JLabel ChipTotal = new JLabel("0");
		ChipTotal.setBounds(72, 36, 68, 14);
		panel.add(ChipTotal);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(72, 58, 78, 20);
		panel.add(spinner);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(10, 152, 154, 38);
		contentPane.add(btnNewGame);
		btnNewGame.addActionListener(this);
		
		btnHit = new JButton("Hit");
		btnHit.setEnabled(false);
		btnHit.setBounds(10, 251, 154, 36);
		contentPane.add(btnHit);
		btnHit.addActionListener(this);
		
		btnStay = new JButton("Stay");
		btnStay.setEnabled(false);
		btnStay.setBounds(10, 298, 154, 38);
		contentPane.add(btnStay);
		btnStay.addActionListener(this);
		
		btnNewHandgiveUp = new JButton("New Hand/Give Up");
		btnNewHandgiveUp.setEnabled(false);
		btnNewHandgiveUp.setBounds(10, 201, 154, 38);
		contentPane.add(btnNewHandgiveUp);
		btnNewHandgiveUp.addActionListener(this);
		
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(10, 347, 154, 38);
		contentPane.add(btnStatistics);
		btnStatistics.addActionListener(this);
		
	}
	private void newGame()
	{
	lblChipCount.setText("500");
	btnNewHandgiveUp.setEnabled(true);
	player.setChipCount(500);
	}
	private void newHand()
	{
	btnHit.setEnabled(true);
	btnStay.setEnabled(true);
	player.clearHand();
	player.addCard(deck.getTopCard());
	player.addCard(deck.getTopCard());
	dealer.addCard(deck.getTopCard());
	dealer.addCard(deck.getTopCard());
	updateplayerhand();
	updatedealerhand(false);
	}
	private void updateplayerhand()
	{
		//Clearing text
		//playerHand.setText(null);
		Cards[] cards = player.getCards();
		//for(Cards card: cards)
		//	playerHand.append(card.toString() + '\n');
		if(player.getHandScore() > 21)
		{
		btnHit.setEnabled(false);
		btnStay.setEnabled(false);
		}
	}
    private void stay()
    {
    btnHit.setEnabled(false);
    btnStay.setEnabled(false);
    updatedealerhand(true);
    BufferedImage image;
    try {
	 image = ImageIO.read(new File("C:/Users/David/Documents/GitHub/Development/Java/JavaProjects/Project 4 BlackJack/classic-cards/1.png"));
	 getGraphics().drawImage(image,100,100,null);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    }
	private void updatedealerhand(Boolean reveal)
    {
    	if(!reveal)
    	{
    		//dealerHand.setText(null);
    		Cards[] cards = dealer.getCards();
    		//dealerHand.append(cards[0].toString() + '\n');
    	}
    	else
    	{
    		//playerHand.setText(null);
    		Cards[] cards = dealer.getCards();
    		//for(Cards card: cards)
    		//	playerHand.append(card.toString() + '\n');
    	}
    }
    public Window() {
	player= new JPlayer();
	dealer = new JDealer();
	deck = new JDeck(5);
	initWindow();
	setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		
		switch (arg0.getActionCommand()){
		
		case "New Game":
		newGame();
		break;
		case "New Hand/Give Up":
		newHand();
		break;
		case "Hit":
			player.addCard(deck.getTopCard());
			updateplayerhand();
		break;
		case "Stay":
			stay();
		break;
		}
		
	}
}
