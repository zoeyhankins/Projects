/*
 * Develop a GUI Java application for decision making - 
 * The Coin Flipper.
 * An image will be displayed (heads.jpg or tails.jpg)
 * The user needs a way to tell the application to 
 * "flip" the coin. 
 * Then the program will randomly generate a value 
 * and display the appropriate heads or tails image.
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CoinFlipper extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton flipButton;
    private JLabel resultLabel;
    private JLabel textLabel; // new label to display "Heads" or "Tails"
    private ImageIcon headsImage;
    private ImageIcon tailsImage;

    public CoinFlipper() {
        super("The Coin Flipper");

        // Load the coin images
        headsImage = new ImageIcon("coin_heads.jpg");
        tailsImage = new ImageIcon("coin_tails.jpg");

        // Create the flip button
        flipButton = new JButton("Flip the Coin");
        flipButton.addActionListener(this);

        // Create the result label
        resultLabel = new JLabel(headsImage);

        // Create the text label
        textLabel = new JLabel("Heads");

        // Create the panel to hold the button and labels
        JPanel panel = new JPanel();
        panel.add(flipButton);
        panel.add(resultLabel);
        panel.add(textLabel);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Set the frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Flip the coin and update the result and text labels
        Random rand = new Random();
        boolean isHeads = rand.nextBoolean();
        resultLabel.setIcon(isHeads ? headsImage : tailsImage);
        textLabel.setText(isHeads ? "Heads" : "Tails");
    }

    public static void main(String[] args) {
        new CoinFlipper();
    }
}