
void main() {
    String[] words = {"java", "programming", "computer", "algorithm", "developer"};
    String targetWord = words[(int) (Math.random() * words.length)];

    StringBuilder guessedLetters = new StringBuilder(targetWord.length());
    for (int i = 0; i < targetWord.length(); i++) {
        guessedLetters.append("_");
    }

    int attempts = 6;
    println("Welcome to Hangman!");
    println("Try to guess the word. You have " + attempts + " attempts.");

    while (attempts > 0) {
        println("Current word: " + guessedLetters);
        String input = readln("Enter a letter: ");
        char guess = input.charAt(0);

        boolean found = false;
        StringBuilder updatedWord = new StringBuilder(guessedLetters);
        for (int i = 0; i < targetWord.length(); i++) {
            if (targetWord.charAt(i) == guess) {
                updatedWord.setCharAt(i, guess);
                found = true;
            }
        }

        if (found) {
            guessedLetters = updatedWord;
            println("Correct guess! Updated word: " + guessedLetters);
        } else {
            attempts--;
            println("Incorrect guess! You have " + attempts + " attempts left.");
        }

        if (guessedLetters.toString().equals(targetWord)) {
            println("Congratulations! You guessed the word: " + targetWord);
            break;
        }
    }

    if (attempts == 0) {
        println("Game Over. The word was: " + targetWord);
    }
}