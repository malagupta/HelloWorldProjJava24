/**
 * The main method animates the display of lines of text by printing each word with a pause in between.
 * It splits the given text into individual lines, then splits each line into words.
 * It prints each word followed by a space, and pauses for a specified amount of time between each word.
 */
void main() {
    // Text to animate
    String text = """
                  Why did the Java programmer bring a shovel to work? To 'dig' into the data structures!
                  Why was the Java developer always so calm? Because they never lost their stack trace!
                  Why did the Java developer go broke? Because he used up all his cache!
                  Why did the Java developer always carry a pen? To 'interface' with their notes!
                  """;

    // Split into individual lines
    String[] lines = text.split("\n");

    // Loop through lines
    for (String line : lines) {
        String[] words = line.split(" ");

        // Loop through words
        for (int i = 0; i < words.length; i++) {

            // Print the word
            print(words[i] + " ");
            // Pause to create the animation effect
            try {
                Thread.sleep(200); // Change this number to modify word display speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Start printing on the next line
        println();
    }
}