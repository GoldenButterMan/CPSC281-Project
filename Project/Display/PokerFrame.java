package Display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import Player.Player;
/**
 * Class for making a frame for the poker game
 * 
 * @author Spencer Peterson
 * Student number: 230157543
 *
 */
public class PokerFrame extends JFrame{
	//member variables needed for GUI
	private JScrollPane scroll;
	private JTextField pot;
	private JTextArea display;
	private JButton button = new JButton("Enter");
	private Register myRegister = new Register();
	private BetRegister betRegister = new BetRegister();
	private JPanel input = new JPanel();
	private JLabel label = new JLabel("Input:");
	private JLabel betLabel = new JLabel("Enter your bet here:");
	private JTextField betInput = new JTextField(5);
	private JButton betButton = new JButton("bet");
	private JTextField textInput = new JTextField(10);
	private JPanel display2 = new JPanel();
	private JTextField cardDisplay = new JTextField(15);
	CardDisplayRegister cardRegister = new CardDisplayRegister();
	
	
	public PokerFrame() {
		super("5 Card Poker");
		mainDisplay();
		pot = new JTextField();
		pot.setText("Current money in the pot: ");
		betRegister.setRegisterListener((str) -> pot.setText(str));
		add(pot, BorderLayout.CENTER);
		setSize(800, 800);
		pot.setHorizontalAlignment(JTextField.CENTER);
		pot.setEditable(false);
		createInput();
		createCardDisplay();
		add(input, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//method to create the primary display.
	private void mainDisplay() {
		display = new JTextArea();
		scroll = new JScrollPane(display);
		display.setText("Enter Your Initial bet");
		display.setEditable(false);
		display.setSize(800, 300);
		display.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		myRegister.setRegisterListener((str) -> display.setText(str));
		button.addActionListener((in) -> cardRegister.increment());
		button.addActionListener((str) -> myRegister.setInput("You Discarded " + cardRegister.getDiscarded().toString() + "\n"));
		button.addActionListener((str) -> cardRegister.popper());
		textInput.setEditable(true);
		button.addActionListener((str) -> cardRegister.discardedCard(Integer.parseInt(textInput.getText()) - 1));
		add(display);
	}
	//Creates inputs for program
	private void createInput() {
		JPanel display1 = new JPanel();
		display1.setLayout(new FlowLayout());
		betButton.addActionListener((in) -> betRegister.setBet(Integer.parseInt(betInput.getText())));
		betButton.addActionListener((str) -> myRegister.betAnnounce(Integer.parseInt(betInput.getText())));
		display1.add(betLabel);
		display1.add(betInput);
		display1.add(betButton);
		display1.add(label);
		display1.add(textInput);
		display1.add(button);
		input.add(display1);
	}
	//Creates the display for the player's hand
	private void createCardDisplay() {
		display2.setLayout(new BoxLayout(display2, BoxLayout.Y_AXIS));
		cardDisplay.setEditable(false);
		cardDisplay.setText(cardRegister.getDisplayText());
		cardRegister.setRegisterListener((str) -> cardDisplay.setText(str));
		cardDisplay.setText(cardRegister.getDisplayText());
		cardDisplay.addActionListener((in) -> cardRegister.discardedCard(Integer.parseInt(textInput.getText())));
		display2.add(cardDisplay);
		input.add(display2);
		
	}
}
