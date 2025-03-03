import module java.base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Often I read developers sharing their favorite 'Development Paradigms' in person or on the social
 * platforms - that are a fun take on the actual development paradigms. This game is inspired by those
 * interactions . It is Swing-based GUI application that presents a humorous game about different software development styles.
 * Users can click on letters A-Z to discover various funny development paradigms and their descriptions.
 * Each paradigm is presented with a title and a witty subtitle in a popup dialog.
 */
public class DevelopmentParadigmGameSwingUI {
    private static final Map<Character, String[]> devStyles = new HashMap<>();

    static {
        devStyles.put('A', new String[]{"Anxiety Driven Development", "When the deadline is near, all roads lead to it!"});
        devStyles.put('B', new String[]{"Bug Driven Development", "If it compiles, ship it! Fix it later."});
        devStyles.put('C', new String[]{"Conference Driven Development", "You only code after attending a conference!"});
        devStyles.put('D', new String[]{"Deadline Driven Development", "Productivity spikes only near deadlines."});
        devStyles.put('E', new String[]{"Experiment Driven Development", "Keep trying things until something works."});
        devStyles.put('F', new String[]{"Fear Driven Development", "You change code only when your manager isn't watching."});
        devStyles.put('G', new String[]{"Google Driven Development", "If you don't know it, Google it!"});
        devStyles.put('H', new String[]{"Hackathon Driven Development", "You work best when there's free pizza and a timer."});
        devStyles.put('I', new String[]{"Interview Driven Development", "You only study before job interviews."});
        devStyles.put('J', new String[]{"JavaDoc Driven Development", "Code first, documentation later (maybe)."});
        devStyles.put('K', new String[]{"Keyboard Driven Development", "More keystrokes mean better coding!"});
        devStyles.put('L', new String[]{"Log Driven Development", "More logs, more debugging!"});
        devStyles.put('M', new String[]{"Micromanagement Driven Development", "Every line of code must be reviewed twice!"});
        devStyles.put('N', new String[]{"Night Owl Driven Development", "Best code is written at 2 AM."});
        devStyles.put('O', new String[]{"Open Source Driven Development", "If it's open source, it must be good!"});
        devStyles.put('P', new String[]{"Patch Driven Development", "Code first, patch later."});
        devStyles.put('Q', new String[]{"Quick Fix Driven Development", "Make it work first, think later."});
        devStyles.put('R', new String[]{"Refactor Driven Development", "The first version is never good enough."});
        devStyles.put('S', new String[]{"Stack Overflow Driven Development", "90% copy-paste, 10% debugging."});
        devStyles.put('T', new String[]{"Test Driven Development", "Or at least pretending to do so."});
        devStyles.put('U', new String[]{"User Complaint Driven Development", "Fix it only when users notice!"});
        devStyles.put('V', new String[]{"Version Driven Development", "Let's just increment the version number."});
        devStyles.put('W', new String[]{"Wiki Driven Development", "If it’s not on the wiki, does it exist?"});
        devStyles.put('X', new String[]{"XML Driven Development", "Because JSON is too mainstream."});
        devStyles.put('Y', new String[]{"YOLO Driven Development", "Ship now, fix later."});
        devStyles.put('Z', new String[]{"Zero Bug Driven Development", "Close all bugs by marking them 'Won't Fix'."});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DevelopmentParadigmGameSwingUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        JFrame frame = new JFrame("Development Style Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("What kind of development do you practice?", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        frame.add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));
        buttonPanel.setBackground(new Color(230, 230, 230));

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            JButton button = new JButton(String.valueOf(ch));
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setPreferredSize(new Dimension(50, 50));
            button.setBackground(new Color(70, 130, 180)); // Adjusted color for better visibility
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] messages = devStyles.getOrDefault(button.getText().charAt(0), new String[]{"No definition found!", "Try another letter."});
                    showPopup(messages[0], messages[1]);
                }
            });
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.getContentPane().setBackground(new Color(200, 200, 200));
        frame.setVisible(true);
    }

    private static void showPopup(String title, String subtitle) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Your Development Style");
        dialog.setSize(400, 180);
        dialog.setLayout(new BorderLayout());
        dialog.setModal(true);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        textPanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel(subtitle, SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        subtitleLabel.setForeground(Color.GRAY);
        textPanel.add(subtitleLabel);

        dialog.add(textPanel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Arial", Font.BOLD, 14));
        okButton.addActionListener(e -> dialog.dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
