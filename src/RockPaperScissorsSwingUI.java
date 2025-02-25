import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissorsSwingUI extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton, playAgainButton;
    private JLabel userChoiceLabel, computerChoiceLabel, resultLabel, titleLabel;
    private JPanel mainPanel, resultPanel;
    private String[] choices = {"Rock", "Paper", "Scissors"};
    private String[] emojis = {"✊", "✋", "✌️"}; // Rock, Paper, Scissors
    private Random random = new Random();

    public RockPaperScissorsSwingUI() {
        // Setup the main window
        setTitle("Rock Paper Scissors");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title label
        titleLabel = new JLabel("🎲 Rock Paper Scissors Game 🎲", SwingConstants.CENTER);
        titleLabel.setFont(getEmojiFont(24, Font.BOLD));
        titleLabel.setForeground(new Color(0x1E88E5));
        add(titleLabel, BorderLayout.NORTH);

        // Main panel for buttons
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Buttons for user choice with emojis
        rockButton = createButton("Rock ✊");
        paperButton = createButton("Paper ✋");
        scissorsButton = createButton("Scissors ✌️");

        mainPanel.add(rockButton);
        mainPanel.add(paperButton);
        mainPanel.add(scissorsButton);

        // Result panel
        resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(4, 1, 10, 10));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        userChoiceLabel = new JLabel("", SwingConstants.CENTER);
        userChoiceLabel.setFont(getEmojiFont(18, Font.PLAIN));
        computerChoiceLabel = new JLabel("", SwingConstants.CENTER);
        computerChoiceLabel.setFont(getEmojiFont(18, Font.PLAIN));
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setFont(getEmojiFont(20, Font.BOLD));
        resultLabel.setForeground(new Color(0x43A047));

        playAgainButton = new JButton("🔄 Play Again");
        playAgainButton.setFont(getEmojiFont(16, Font.BOLD));
        playAgainButton.setBackground(new Color(0xFF7043));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.addActionListener(e -> resetGame());
        playAgainButton.setVisible(false);

        resultPanel.add(userChoiceLabel);
        resultPanel.add(computerChoiceLabel);
        resultPanel.add(resultLabel);
        resultPanel.add(playAgainButton);

        add(mainPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(0xF1F8E9));
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(getEmojiFont(18, Font.BOLD));
        button.setBackground(new Color(0x90CAF9));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.addActionListener(this);
        return button;
    }

    private Font getEmojiFont(int size, int style) {
        String[] emojiFonts = {"Segoe UI Emoji", "Apple Color Emoji", "Noto Color Emoji"};
        for (String fontName : emojiFonts) {
            Font font = new Font(fontName, style, size);
            if (font.getFamily().equals(fontName)) {
                return font;
            }
        }
        return new Font("Arial", style, size); // Fallback font
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = e.getActionCommand().split(" ")[0];
        int userChoiceIndex = getChoiceIndex(userChoice);
        int computerChoiceIndex = random.nextInt(3);

        displayChoices(userChoiceIndex, computerChoiceIndex);
        determineWinner(userChoiceIndex, computerChoiceIndex);
    }

    private int getChoiceIndex(String choice) {
        for (int i = 0; i < choices.length; i++) {
            if (choices[i].equalsIgnoreCase(choice)) {
                return i;
            }
        }
        return -1;
    }

    private void displayChoices(int userChoiceIndex, int computerChoiceIndex) {
        userChoiceLabel.setText("You chose: " + choices[userChoiceIndex] + " " + emojis[userChoiceIndex]);
        computerChoiceLabel.setText("Computer chose: " + choices[computerChoiceIndex] + " " + emojis[computerChoiceIndex]);
        playAgainButton.setVisible(true);
    }

    private void determineWinner(int userChoiceIndex, int computerChoiceIndex) {
        if (userChoiceIndex == computerChoiceIndex) {
            resultLabel.setText("🏆 It's a Draw!");
        } else if ((userChoiceIndex == 0 && computerChoiceIndex == 2) ||
                   (userChoiceIndex == 1 && computerChoiceIndex == 0) ||
                   (userChoiceIndex == 2 && computerChoiceIndex == 1)) {
            resultLabel.setText("✨ You Win!");
        } else {
            resultLabel.setText("👎 Computer Wins!");
        }
        disableButtons();
    }

    private void disableButtons() {
        rockButton.setEnabled(false);
        paperButton.setEnabled(false);
        scissorsButton.setEnabled(false);
    }

    private void resetGame() {
        userChoiceLabel.setText("");
        computerChoiceLabel.setText("");
        resultLabel.setText("");
        rockButton.setEnabled(true);
        paperButton.setEnabled(true);
        scissorsButton.setEnabled(true);
        playAgainButton.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissorsSwingUI::new);
    }
}
