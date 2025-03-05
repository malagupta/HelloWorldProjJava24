package games.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * A Tetris game implementation using Java Swing.
 * This class manages:
 *  a) game board,
 *  b) piece movement,
 *  c) rotation, and
 *  d) rendering.
 *  e) It handles user input for moving pieces left/right, rotating pieces, and dropping them quickly.
 *
 *  To_FIX: To remove a horizontal line when it doen't has any missing block
 */
public class Tetris extends JPanel implements ActionListener {
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 20;
    private final int BLOCK_SIZE = 30;
    private Timer timer;
    private int[][] board;
    private int currentX, currentY;
    private int[][] currentPiece;
    private int currentRotation;
    private Random random;
    private Color currentColor;
    private Color[][] colorBoard;
    private final int[][][] PIECES = {
        {{1, 1, 1, 1}}, // I-shape
        {{1, 1}, {1, 1}}, // O-shape
        {{1, 1, 1}, {0, 1, 0}}, // T-shape
        {{1, 1, 0}, {0, 1, 1}}, // S-shape
        {{0, 1, 1}, {1, 1, 0}}, // Z-shape
        {{1, 1, 1}, {1, 0, 0}}, // L-shape
        {{1, 1, 1}, {0, 0, 1}} // J-shape
    };
    private final Color[] COLORS = {Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GREEN, Color.RED, Color.ORANGE, Color.BLUE};

    public Tetris() {
        setPreferredSize(new Dimension(BOARD_WIDTH * BLOCK_SIZE, BOARD_HEIGHT * BLOCK_SIZE));
        setBackground(Color.BLACK);
        board = new int[BOARD_HEIGHT][BOARD_WIDTH];
        colorBoard = new Color[BOARD_HEIGHT][BOARD_WIDTH];
        random = new Random();
        spawnPiece();
        timer = new Timer(500, this);
        timer.start();
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    movePiece(-1);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    movePiece(1);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    rotatePiece();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    dropPiece();
                }
            }
        });
    }

    private void spawnPiece() {
        int pieceIndex = random.nextInt(PIECES.length);
        currentPiece = PIECES[pieceIndex];
        currentColor = COLORS[pieceIndex];
        currentX = BOARD_WIDTH / 2 - currentPiece[0].length / 2;
        currentY = 0;
        currentRotation = 0;
    }

    private void movePiece(int dx) {
        if (isValidMove(currentX + dx, currentY, currentPiece)) {
            currentX += dx;
            repaint();
        }
    }

    private void rotatePiece() {
        int[][] rotatedPiece = rotateMatrix(currentPiece);
        if (isValidMove(currentX, currentY, rotatedPiece)) {
            currentPiece = rotatedPiece;
            repaint();
        }
    }

    private int[][] rotateMatrix(int[][] piece) {
        int rows = piece.length;
        int cols = piece[0].length;
        int[][] rotated = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rotated[col][rows - 1 - row] = piece[row][col];
            }
        }
        return rotated;
    }

    private boolean isValidMove(int x, int y, int[][] piece) {
        for (int row = 0; row < piece.length; row++) {
            for (int col = 0; col < piece[row].length; col++) {
                if (piece[row][col] != 0) {
                    int newX = x + col;
                    int newY = y + row;
                    if (newX < 0 || newX >= BOARD_WIDTH || newY >= BOARD_HEIGHT || board[newY][newX] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void dropPiece() {
        while (isValidMove(currentX, currentY + 1, currentPiece)) {
            currentY++;
        }
        placePiece();
        spawnPiece();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isValidMove(currentX, currentY + 1, currentPiece)) {
            currentY++;
        } else {
            placePiece();
            spawnPiece();
        }
        repaint();
    }

    private void placePiece() {
        for (int row = 0; row < currentPiece.length; row++) {
            for (int col = 0; col < currentPiece[row].length; col++) {
                if (currentPiece[row][col] != 0) {
                    board[currentY + row][currentX + col] = 1;
                    colorBoard[currentY + row][currentX + col] = currentColor;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                if (board[row][col] != 0) {
                    g.setColor(colorBoard[row][col]);
                    g.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
        g.setColor(currentColor);
        for (int row = 0; row < currentPiece.length; row++) {
            for (int col = 0; col < currentPiece[row].length; col++) {
                if (currentPiece[row][col] != 0) {
                    g.fillRect((currentX + col) * BLOCK_SIZE, (currentY + row) * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Clone");
        Tetris game = new Tetris();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
