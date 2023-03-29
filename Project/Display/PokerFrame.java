package Display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import Player.Player;

public class PokerFrame extends JFrame{
	private Player player = new Player();
	private JTextField pot;
	private JTextField display;
	private JButton button;
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
		display = new JTextField();
		display.setText("Enter Your Initial bet:");
		display.setEditable(false);
		display.setSize(800, 300);
		myRegister.setRegisterListener((str) -> display.setText(str));
		add(display, BorderLayout.NORTH);
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
	
	private void createInput() {
		JPanel display1 = new JPanel();
		display1.setLayout(new FlowLayout());
		betButton.addActionListener((in) -> betRegister.setBet(Integer.parseInt(betInput.getText())));
		button = new JButton("Enter");
		textInput.setEditable(true);
		button.addActionListener((str) -> myRegister.setInput(textInput.getText()));
		button.addActionListener((str) -> cardRegister.discardedCard(Integer.parseInt(textInput.getText()) - 1));
		display1.add(betLabel);
		display1.add(betInput);
		display1.add(betButton);
		display1.add(label);
		display1.add(textInput);
		display1.add(button);
		input.add(display1);
	}
	
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
