import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGaming extends JFrame {
	private JTextField txtGuess; //text field for user guess
	private JLabel lblOutput;   //label for output
	private JLabel lblAttempts;
	private int theNumber;
	private int counter = 0;
	private int limit = 10; //set this to limits the tries
	
	
	
	public void checkGuess(){ //Method to check if the number is too high or too low
		
		lblAttempts.setText("");
		//get the user guess
		String guessText = txtGuess.getText();
		String message = "";

		
		//check the guess for too high or too low
		
		try {
			int guess = Integer.parseInt(guessText);
            this.counter++;

			lblAttempts.setText("Keep guessing! you have " + (limit - counter) + " tries left.");


			
			//too high
			
			if (guess > theNumber){
				message = guess + " was too high."; //assign this message to the variable
				lblOutput.setText(message); //Output the message to the label
				}
			//too low
			else if (guess < theNumber){
				message = guess + " was too low."; //assign this message to the variable
				lblOutput.setText(message); //Output the message to the label
	            }
			else{ //guessed correctly
				message = guess + " was right! You win! Let's play again!";
				lblOutput.setText(message);
				if(counter == 1){
				       lblAttempts.setText("You did it in just one try! Did you hack the game?!");}
				else if(counter>1 && counter<6){
					   lblAttempts.setText("You did it in " + counter + " tries! Awesome work.");}
				else{				lblAttempts.setText("You did it in " + counter + " tries! Keep playing to improve.");}
                
				
				newGame();
			}
			if(counter == 10){
				lblAttempts.setText("Sorry! you reached the limit of tries! The number was " + theNumber+ ". Play again!");
				newGame();
				
			}
	
		}
		catch(Exception e){
			lblOutput.setText("Enter a whole number between 1 and 100");
		}
		finally{
			
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
		
	
		
		
		
	}
	
	public void newGame(){ //create a new random number
		
		this.theNumber= (int) (Math.random()*100 + 1);
		this.limit = 10;
		this.counter = 0;
		txtGuess.setText("");
    }
	
	
	public GuessingGaming() {
		setTitle("The Guessing Game by AJ");
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(0, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblTheGuessingGame = new JLabel("The Guessing Game by AJ");
		lblTheGuessingGame.setForeground(Color.WHITE);
		lblTheGuessingGame.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblTheGuessingGame.setBounds(3, 51, 905, 52);
		lblTheGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTheGuessingGame);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(null);
		panel.setBounds(128, 147, 655, 59);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setForeground(Color.WHITE);
		lblGuessANumber.setFont(new Font("Modern No. 20", Font.PLAIN, 34));
		lblGuessANumber.setBounds(0, 3, 490, 33);
		panel.add(lblGuessANumber);
		lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtGuess = new JTextField();
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtGuess.setForeground(Color.WHITE);
		txtGuess.setBackground(Color.GRAY);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(494, 3, 92, 39);
		panel.add(txtGuess);
		txtGuess.setColumns(10);
		
		lblOutput = new JLabel("Enter a number above. You have 10 tries.");
		lblOutput.setForeground(Color.WHITE);
		lblOutput.setFont(new Font("Modern No. 20", Font.PLAIN, 29));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(3, 349, 905, 33);
		getContentPane().add(lblOutput);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.setBackground(Color.WHITE);
		btnGuess.setForeground(Color.BLACK);
		btnGuess.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 31));
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		btnGuess.setBounds(346, 257, 219, 41);
		getContentPane().add(btnGuess);
		
		lblAttempts = new JLabel("");
		lblAttempts.setForeground(Color.WHITE);
		lblAttempts.setBackground(Color.WHITE);
		lblAttempts.setFont(new Font("Modern No. 20", Font.PLAIN, 29));
		lblAttempts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttempts.setBounds(3, 384, 902, 33);
		getContentPane().add(lblAttempts);
		
		
	}

	public static void main(String[] args) {
		
		GuessingGaming theGame = new GuessingGaming();
		
		theGame.newGame();
		theGame.setSize(new Dimension(930,660));
		theGame.setVisible(true);
		
		
		
		
		

		
	}
}
