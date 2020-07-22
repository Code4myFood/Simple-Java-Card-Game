/**
 * <h1>A Simple Card Game</h1>
 * A simple card game for fun!
 * 
 * 
 * @author Code4Food
 * @version 1.0
 * @since	2019-11-15
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class Main extends JFrame implements ActionListener, MenuListener{
	
	boolean run = true;
	int money = 100;
	JButton start, result, card1, card2, card3;
	JTextField bet = new JTextField(10);
	ArrayList<Cards> desk, player, dealer;
	JLabel statement = new JLabel("Please place your bet! Amount of money you have: $" + Integer.toString(money));
	JLabel dealerCard1, dealerCard2, dealerCard3, playerCard1, playerCard2, playerCard3;
	String dealerCard1gif, dealerCard2gif, dealerCard3gif, playerCard1gif, playerCard2gif, playerCard3gif;
	ImageIcon image;
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The main method that the game start
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	/**
	 * Constructor for the main
	 * 
	 */
	private Main() {
		//making the frame for the game and the bar
		super("A Simple Card Game");
		setSize(450, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JMenuBar bar   = new JMenuBar();
		JMenu help     = new JMenu("Help");
		help.addMenuListener(this);
		JMenu control  = new JMenu("Control");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		bar.add(control);
		bar.add(help);
		control.add(exit);
		setJMenuBar(bar);
		//Making the upper part of the game which for containing the cards
		JPanel upperPart = new JPanel();
		upperPart.setBackground(Color.GREEN);
		upperPart.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		//Making the cards 
		image = new ImageIcon(getClass().getResource("Cover.gif"));
		dealerCard1 = new JLabel(image);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		upperPart.add(dealerCard1, c);
		dealerCard2 = new JLabel(image);
		c.gridx = 1;
		c.gridy = 0;
		upperPart.add(dealerCard2, c);
		dealerCard3 = new JLabel(image);
		c.gridx = 2;
		c.gridy = 0;
		upperPart.add(dealerCard3, c);
		playerCard1 = new JLabel(image);
		c.gridx = 0;
		c.gridy = 1;
		upperPart.add(playerCard1, c);
		playerCard2 = new JLabel(image);
		c.gridx = 1;
		c.gridy = 1;
		upperPart.add(playerCard2, c);
		playerCard3 = new JLabel(image);
		c.gridx = 2;
		c.gridy = 1;
		upperPart.add(playerCard3, c);
		card1 = new JButton("Replace Card 1");
		card1.setBackground(Color.GREEN);
		c.gridx = 0;
		c.gridy = 2;
		upperPart.add(card1, c);
		card2 = new JButton("Replace Card 2");
		card2.setBackground(Color.GREEN);
		c.gridx = 1;
		c.gridy = 2;
		upperPart.add(card2, c);
		card3 = new JButton("Replace Card 3");
		card3.setBackground(Color.GREEN);
		c.gridx = 2;
		c.gridy = 2;
		upperPart.add(card3, c);
		//set Button listener
		card1.addActionListener(this);
		card2.addActionListener(this);
		card3.addActionListener(this);
		
		add(upperPart, BorderLayout.CENTER);
		
		//make the bottom part of the game whihc contain the user input 
		JPanel bottomPart = new JPanel();
		bottomPart.setBackground(Color.lightGray);
		bottomPart.setLayout(new BoxLayout(bottomPart, BoxLayout.Y_AXIS));
		
		//set the bet panel
		JPanel bet_amount = new JPanel();
		start = new JButton("Start");
		result = new JButton("Result");
		start.addActionListener(this);
		result.addActionListener(this);
		bet_amount.add(new JLabel("Bet: $ "));
		bet_amount.add(bet);
		bet_amount.add(start);
		bet_amount.add(result);
		bottomPart.add(bet_amount, BorderLayout.NORTH);
		
		JPanel line = new JPanel();
		line.add(statement);
		bottomPart.add(line, BorderLayout.SOUTH);
		
		add(bottomPart, BorderLayout.SOUTH);
		card1.setEnabled(false);
		card2.setEnabled(false);
		card3.setEnabled(false);
		result.setEnabled(false);
	}
	/**
	 * To check the player input is an integer or not
	 * @param input of bet 
	 * @return true if the user input an integer, otherwise false
	 */
	public static boolean isInteger(String s) {
	      boolean isValidInteger = false;
	      try
	      {
	         Integer.parseInt(s);
	 
	         // s is a valid integer
	 
	         isValidInteger = true;
	      }
	      catch (NumberFormatException ex)
	      {
	         // s is not an integer
	      }
	 
	      return isValidInteger;
	   }
	/**
	 * the heart of the game
	 */
	private void runGame() {
			//to check the input is correct or not
			if(isInteger(bet.getText()) && Integer.parseInt(bet.getText()) < 0) {	
				//if the player has input a negative integer
				JOptionPane.showMessageDialog(this,"WARNING: The bet you place must be a positive integer!");
				start.setEnabled(true);
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
				return;
			}else if (!isInteger(bet.getText())){
				//the player has input a non-Integer value
				JOptionPane.showMessageDialog(this,"WARNING: The bet you place must be a positive integer!");
				start.setEnabled(true);
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
				return;
			}else if(Integer.parseInt(bet.getText()) > money ){
				//the player has input a bet that more than the money he has. 
				JOptionPane.showMessageDialog(this, "WARNING: You don't have enough money!");
				start.setEnabled(true);
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
				return;
			}
			//Correct input and set up the game
			int input = Integer.parseInt(bet.getText());
			statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));
			desk   = new ArrayList<Cards>();
			player = new ArrayList<Cards>();
			dealer   = new ArrayList<Cards>();
			GameTools.createDesk(desk);
			desk = GameTools.shuffle(desk);
			GameTools.giveDealerCards(desk, dealer);
			GameTools.givePlayerCards(desk, player);
			
			//change the card image
			playerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(player.get(0).getNumber()) + ".gif";
			playerCard1.setIcon(new ImageIcon(getClass().getResource(playerCard1gif)));
			playerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(player.get(1).getNumber()) + ".gif";
			playerCard2.setIcon(new ImageIcon(getClass().getResource(playerCard2gif)));
			playerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(player.get(2).getNumber()) + ".gif";
			playerCard3.setIcon(new ImageIcon(getClass().getResource(playerCard3gif)));
			
	
	}
	@Override 
	
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if(name.equals("Replace Card 1")) {
			//replace card 1 and enable the button
			GameTools.playerDrawCard(desk, player, 0);
			playerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(player.get(0).getNumber()) + ".gif";
			playerCard1.setIcon(new ImageIcon(getClass().getResource(playerCard1gif)));
			card1.setEnabled(false);
			//if more than two buttons has clicked then jump to the result
			if(!card2.isEnabled() || !card3.isEnabled()) {
				dealerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(dealer.get(0).getNumber()) + ".gif";
				dealerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(dealer.get(1).getNumber()) + ".gif";
				dealerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(dealer.get(2).getNumber()) + ".gif";
				dealerCard1.setIcon(new ImageIcon(getClass().getResource(dealerCard1gif)));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource(dealerCard2gif)));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource(dealerCard3gif)));
				//check the player win the game or not 
				if(CheckResult.playerWinTheGame(player, dealer)){
					//tell the player win the game
					JOptionPane.showMessageDialog(this,"Congrauations! You win this round!");
					int input = Integer.parseInt(bet.getText());
					money += input;
					statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));				
					start.setEnabled(true);
				}else {
					int input = Integer.parseInt(bet.getText());
					money -= input;
					if(money == 0) {
						//enable the start button to stop the player continue to play if the player lose all his money
						JOptionPane.showMessageDialog(this, "Game over!\r\n" + "You have no more money!\r\n" + "Please start a new game!\r\n" );
						statement.setText("You have no more money! Please start a new game!");
						start.setEnabled(false);
					}else {
						//tell the player lose his game
						JOptionPane.showMessageDialog(this, "Sorry! The Dealer wins this round!" );
						statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));
						start.setEnabled(true);
					}
				}
				//reset the game
				playerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				playerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				playerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
			}
		}else if(name.equals("Replace Card 2")) {
			GameTools.playerDrawCard(desk, player, 1);
			playerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(player.get(1).getNumber()) + ".gif";
			playerCard2.setIcon(new ImageIcon(getClass().getResource(playerCard2gif)));
			card2.setEnabled(false);
			// to check the player has changed two cards already or not, if yes then check the result
			if(!card1.isEnabled() || !card3.isEnabled()) {
				dealerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(dealer.get(0).getNumber()) + ".gif";
				dealerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(dealer.get(1).getNumber()) + ".gif";
				dealerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(dealer.get(2).getNumber()) + ".gif";
				dealerCard1.setIcon(new ImageIcon(getClass().getResource(dealerCard1gif)));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource(dealerCard2gif)));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource(dealerCard3gif)));
				//check the player win the game or not
				if(CheckResult.playerWinTheGame(player, dealer)){
					//tell the player win the game
					JOptionPane.showMessageDialog(this,"Congrauations! You win this round!");
					int input = Integer.parseInt(bet.getText());
					money += input;
					statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));				
					start.setEnabled(true);
				}else {
					int input = Integer.parseInt(bet.getText());
					money -= input;
					if(money == 0) {
						//stop the player continue to play the game if he lose all his money and tell him he has already lost all his money
						JOptionPane.showMessageDialog(this, "Game over!\r\n" + "You have no more money!\r\n" + "Please start a new game!\r\n" );
						statement.setText("You have no more money! Please start a new game!");
						start.setEnabled(false);
					}else {
						//tell the player lose his game
						JOptionPane.showMessageDialog(this, "Sorry! The Dealer wins this round!" );
						statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));
						start.setEnabled(true);
					}
				}
				//reset the game
				playerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				playerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				playerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
			}
		}else if(name.equals("Replace Card 3")) {
			GameTools.playerDrawCard(desk, player, 2);
			playerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(player.get(2).getNumber()) + ".gif";
			playerCard3.setIcon(new ImageIcon(getClass().getResource(playerCard3gif)));
			card3.setEnabled(false);
			//see the player has changed two cards or not
			if(!card1.isEnabled() || !card2.isEnabled()) {
				dealerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(dealer.get(0).getNumber()) + ".gif";
				dealerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(dealer.get(1).getNumber()) + ".gif";
				dealerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(dealer.get(2).getNumber()) + ".gif";
				dealerCard1.setIcon(new ImageIcon(getClass().getResource(dealerCard1gif)));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource(dealerCard2gif)));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource(dealerCard3gif)));
				//check the player wins the game or not
				if(CheckResult.playerWinTheGame(player, dealer)){
					JOptionPane.showMessageDialog(this,"Congrauations! You win this round!");
					int input = Integer.parseInt(bet.getText());
					money += input;
					statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));				
					start.setEnabled(true);
				}else {
					int input = Integer.parseInt(bet.getText());
					money -= input;
					if(money == 0) {
						//tell the player has already lose all his money and not allow the player continue the game
						JOptionPane.showMessageDialog(this, "Game over!\r\n" + "You have no more money!\r\n" + "Please start a new game!\r\n" );
						statement.setText("You have no more money! Please start a new game!");
						start.setEnabled(false);
					}else {
						//tell the player has lose his game
						JOptionPane.showMessageDialog(this, "Sorry! The Dealer wins this round!" );
						statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));
						start.setEnabled(true);
					}
				}
				//reset the game
				playerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				playerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				playerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				dealerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
				dealerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
				card1.setEnabled(false);
				card2.setEnabled(false);
				card3.setEnabled(false);
				result.setEnabled(false);
			}
		}else if(name.equals("Start")) {
			start.setEnabled(false);
			card1.setEnabled(true);
			card2.setEnabled(true);
			card3.setEnabled(true);
			result.setEnabled(true);
			runGame();
		}else if(name.equals("Result")) {
			//show the dealer hand
			dealerCard1gif = player.get(0).getSuit() + "_" + Integer.toString(dealer.get(0).getNumber()) + ".gif";
			dealerCard2gif = player.get(1).getSuit() + "_" + Integer.toString(dealer.get(1).getNumber()) + ".gif";
			dealerCard3gif = player.get(2).getSuit() + "_" + Integer.toString(dealer.get(2).getNumber()) + ".gif";
			dealerCard1.setIcon(new ImageIcon(getClass().getResource(dealerCard1gif)));
			dealerCard2.setIcon(new ImageIcon(getClass().getResource(dealerCard2gif)));		
			dealerCard3.setIcon(new ImageIcon(getClass().getResource(dealerCard3gif)));
			//check the game
			if(CheckResult.playerWinTheGame(player, dealer)){
				JOptionPane.showMessageDialog(this,"Congrauations! You win this round!");
				int input = Integer.parseInt(bet.getText());
				money += input;
				statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));				
				start.setEnabled(true);
			}else {
				int input = Integer.parseInt(bet.getText());
				money -= input;
				if(money == 0) {
					JOptionPane.showMessageDialog(this, "Game over!\r\n" + "You have no more money!\r\n" + "Please start a new game!\r\n" );
					statement.setText("You have no more money! Please start a new game!");
					start.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(this, "Sorry! The Dealer wins this round!" );
					statement.setText("Your current bet is: $" + Integer.toString(input) + " Amount of money you have: $" + Integer.toString(money));
					start.setEnabled(true);
				}
			}
			//reset the game
			playerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
			playerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
			playerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
			dealerCard1.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
			dealerCard2.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));		
			dealerCard3.setIcon(new ImageIcon(getClass().getResource("Cover.gif")));
			card1.setEnabled(false);
			card2.setEnabled(false);
			card3.setEnabled(false);
			result.setEnabled(false);
		}else if(name.equals("Exit")) {
			//exit the game
			System.exit(0);
	}
	}


	@Override
	public void menuSelected(MenuEvent e) {
		JOptionPane.showMessageDialog(this, "Rules to determine who has better cards:\r\n" + 
				"J, Q, K are regarded as special cards.\r\n" + 
				"Rule 1: The one with more special cards wins.\r\n" + 
				"Rule 2: If both have the same number of special cards, add the face values of the other\r\n" + 
				"card(s) and take the remainder after dividing the sum by 10. The one with a bigger\r\n" + 
				"remainder wins. (Note: Ace = 1).\r\n" + 
				"Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
	}
	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub	
	}
}