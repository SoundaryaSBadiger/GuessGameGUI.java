package assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessGameGUI extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton guessButton, restartButton;
    private JLabel messageLabel, attemptsLabel;
    private int targetNumber, attempts;

    // ✅ Constructor
    public GuessGameGUI() {
        setTitle("Number Guessing Game");
        setSize(400, 250);
        setLayout(new GridLayout(6, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        targetNumber = new Random().nextInt(100) + 1;
        attempts = 0;

        JLabel promptLabel = new JLabel("Guess a number between 1 and 100:");
        inputField = new JTextField();
        guessButton = new JButton("Guess");
        restartButton = new JButton("Restart");

        messageLabel = new JLabel("");
        attemptsLabel = new JLabel("Attempts: 0");

        guessButton.addActionListener(this); // ✅ this class implements ActionListener
        restartButton.addActionListener(e -> resetGame());

        add(promptLabel);
        add(inputField);
        add(guessButton);
        add(messageLabel);
        add(attemptsLabel);
        add(restartButton);

        setVisible(true);
    }

    // ✅ This method handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(inputField.getText());
            attempts++;
            if (guess < targetNumber) {
                messageLabel.setText("Too Low!");
            } else if (guess > targetNumber) {
                messageLabel.setText("Too High!");
            } else {
                messageLabel.setText("Correct! You guessed it.");
                guessButton.setEnabled(false);
            }
            attemptsLabel.setText("Attempts: " + attempts);
        } catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
        }
        inputField.setText("");
    }

    // ✅ Reset the game
    private void resetGame() {
        targetNumber = new Random().nextInt(100) + 1;
        attempts = 0;
        messageLabel.setText("");
        attemptsLabel.setText("Attempts: 0");
        guessButton.setEnabled(true);
        inputField.setText("");
    }

    // ✅ Main method to start the application
    public static void main(String[] args) {
        new GuessGameGUI();
    }
}

