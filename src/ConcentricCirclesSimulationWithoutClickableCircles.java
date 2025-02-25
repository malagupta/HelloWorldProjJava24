import javax.swing.*;
import java.awt.*;

private int radius = 10; // Initial radius
private boolean increasing = true; // Boolean to toggle growth and shrink
private JPanel panel; // Instance variable for JPanel

void main() {
    // Create a JFrame to display the simulation
    JFrame frame = new JFrame("Concentric Circles Simulation");
    init();

    // Add the panel to the frame
    frame.add(panel);

    // Set up the frame
    frame.pack(); // Pack adjusts the frame to fit the preferred size of contents
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame on the screen
    frame.setVisible(true); // Display the frame
}

public void init() {
    // Create the panel where the circles will be drawn
    panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Clear previous drawings
            Graphics2D g2d = (Graphics2D) g;

            // Enable anti-aliasing for smooth rendering
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set the pen width (e.g., 5.0f for thicker lines)
            float penWidth = 10.0f;
            g2d.setStroke(new BasicStroke(penWidth));

            // Calculate the center of the panel
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Draw concentric circles
            for (int r = radius; r > 0; r -= 20) {
                float hue = (float) r / 200; // Generate color based on radius
                g2d.setBackground(Color.darkGray);
                g2d.setColor(Color.getHSBColor(hue, 0.8f, 0.8f));
                g2d.drawOval(centerX - r, centerY - r, 2 * r, 2 * r);
            }
        }
    };

    // Set preferred size for the panel
    panel.setPreferredSize(new Dimension(750, 550));
    // Set the background color to a darker gray
    panel.setBackground(Color.DARK_GRAY);

    // Timer to periodically repaint the panel for animation
    Timer timer = new Timer(50, e -> {
        if (radius >= 270) {
            increasing = false; // Reverse the direction when reaching max radius
        } else if (radius <= 10) {
            increasing = true; // Reverse the direction when reaching min radius
        }
        radius += (increasing ? 2 : -2); // Increment or decrement the radius
        panel.repaint(); // Repaint the panel to reflect the changes
    });
    timer.start();
}