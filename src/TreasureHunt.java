private final int GRID_SIZE = 5;
private int treasureX;
private int treasureY;
private int playerX;
private int playerY;
private int moves;
private final String PLAYER_EMOJI = "\uD83D\uDC4B";

public void init() {
    Random rand = new Random();
    treasureX = rand.nextInt(GRID_SIZE);
    treasureY = rand.nextInt(GRID_SIZE);
    playerX = GRID_SIZE / 2;
    playerY = GRID_SIZE / 2;
    moves = 0;

    println("\n\n🏝️ Welcome to Treasure Hunt!");
    println("Find the hidden treasure on a " + GRID_SIZE + "x" + GRID_SIZE + " grid.");
    println("Use commands: N, E, W, S, or north, south, east, west to move.");

    displayGrid();
    playGame();
}

private void playGame() {
    while (true) {
        String move = readln("Enter your move: ");
        move = move.trim().toLowerCase();
        if (makeMove(move)) {
            moves++;
            displayGrid();
            if (playerX == treasureX && playerY == treasureY) {
                println("🎉 You found the treasure in " + moves + " moves! Congratulations!");
                break;
            } else {
                giveHint();
            }
        } else {
            println("❌ Invalid move. Try other moves.");
        }
    }
}

private boolean makeMove(String direction) {
    switch (direction) {
        case "north", "n":
            if (playerY > 0) {
                playerY--;
                return true;
            }
            break;
        case "south", "s":
            if (playerY < GRID_SIZE - 1) {
                playerY++;
                return true;
            }
            break;
        case "east", "e":
            if (playerX < GRID_SIZE - 1) {
                playerX++;
                return true;
            }
            break;
        case "west", "w":
            if (playerX > 0) {
                playerX--;
                return true;
            }
            break;
    }
    return false;
}

private void displayGrid() {
    println("\nCurrent Grid:");
    for (int y = 0; y < GRID_SIZE; y++) {
        for (int x = 0; x < GRID_SIZE; x++) {
            if (x == playerX && y == playerY) {
                print("[" + PLAYER_EMOJI + "] ");
            } else {
                print("[⬛] ");
            }
        }
        println();
    }
    println();
}

private void giveHint() {
    int distance = Math.abs(playerX - treasureX) + Math.abs(playerY - treasureY);
    switch (distance) {
        case 1, 2 -> println("🔥 Great! You're getting closer!");
        case 3, 4 -> println("🌤️ Watch out! You're moving farther.");
        default -> println("❄️ Damn.. You're farther.");
    }
}

void main() {
    init();
}
