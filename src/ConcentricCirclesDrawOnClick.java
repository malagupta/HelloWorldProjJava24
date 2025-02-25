import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

private int radius = 10; // Initial radius
private boolean increasing = true; // Boolean to toggle growth and shrink
private JPanel panel; // Instance variable for JPanel

// A list to store clicked circles
private List<ColoredCircle> circles = new ArrayList<>();

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

            // Set the pen width (e.g., 10.0f for thicker lines)
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

            // Draw additional circles added by mouse clicks
            for (ColoredCircle circle : circles) {
                g2d.setColor(circle.color); // Set random color
                g2d.drawOval(circle.x - circle.radius, circle.y - circle.radius,
                             circle.radius * 2, circle.radius * 2);
            }
        }
    };

    // Set preferred size for the panel
    panel.setPreferredSize(new Dimension(750, 550));
    // Set the background color to a darker gray
    panel.setBackground(Color.DARK_GRAY);

    // Add mouse listener to the panel to detect mouse clicks
    panel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Generate a random color and store a new circle at the click location
            Random random = new Random();
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            circles.add(new ColoredCircle(e.getX(), e.getY(), random.nextInt(100), randomColor)); // Circle radius is set to 30

            // Repaint the panel to reflect the new circle
            panel.repaint();
        }
    });

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

// Helper class to represent a circle with color and position
private static class ColoredCircle {
    int x, y, radius;
    Color color;

    ColoredCircle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
}