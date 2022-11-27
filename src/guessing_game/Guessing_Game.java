package guessing_game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Guessing_Game extends JFrame {

	private JPanel contentPane;
	private JTextField inputTF;
	int rand=(int) (Math.random()*1000);
	int count = 0;

	/**
	 * Create the frame.
	 */
	public Guessing_Game() {
		setResizable(false);
		
		setTitle("Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create label "Guess a Number from 1-1000"
		JLabel label1 = new JLabel("Guess a Number from 1-1000");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(10, 11, 414, 31);
		contentPane.add(label1);
		
		// Create a TextField for input Guess
		inputTF = new JTextField();
		inputTF.setHorizontalAlignment(SwingConstants.RIGHT);
		inputTF.setBounds(249, 57, 86, 20);
		contentPane.add(inputTF);
		inputTF.setColumns(10);
		
		// Create label "Type a Number:"
		JLabel lblNewLabel = new JLabel("Type a Number: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 53, 96, 24);
		contentPane.add(lblNewLabel);
		
		// Create a label with no text yet
		JLabel label2 = new JLabel("");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(10, 104, 414, 23);
		contentPane.add(label2);
		
		// Create label for guesses
		JLabel guessesL = new JLabel("Guesses: ");
		guessesL.setBounds(38, 60, 86, 14);
		contentPane.add(guessesL);
		
		// Create button "Give up", which reveals the answer
		JButton btnNewButton = new JButton("Give Up");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label2.setText(rand + " is the answer!");
				inputTF.setEditable(false);
			}
		});
		btnNewButton.setBounds(10, 187, 114, 23);
		contentPane.add(btnNewButton);
		
		/*Create button "Guess", which increase the value of count by 1, add text to the label guessesL, and
		 *  creates if and else statements that add text to the label label2.
		 */
		JButton btnNewButton_1 = new JButton("Guess");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(inputTF.getText());
				count = count + 1;
					guessesL.setText("Guesses: " + count);
				
				if(a < rand)
	            {
	                label2.setText(a + " is too low, try again!!");
	            }    
	            else if(a > rand)
	            {
	                label2.setText(a + " is too high, try again!!");
	            }
	            else
	            {
	                label2.setText("CORRECT, YOU WIN!!!!"); 
	            }
			}
		});
		btnNewButton_1.setBounds(159, 187, 114, 23);
		contentPane.add(btnNewButton_1);
		
		// Create button "play again", which restarts the game
		JButton btnNewButton_2 = new JButton("Play Again");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(0, 255, 128));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rand=(int) (Math.random()*1000);
				 label2.setText("");
				 count = 0;
				 inputTF.setEditable(true);
			}
		});
		btnNewButton_2.setBounds(310, 187, 114, 23);
		contentPane.add(btnNewButton_2);
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guessing_Game frame = new Guessing_Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
