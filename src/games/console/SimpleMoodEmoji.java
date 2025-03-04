/*
 * A very simple game to demo:
 * a) Instance main method
 * b) Implicit classes
 * c) Switch expressions
 * d) println/ readln methods
 */
void main() {
    String mood = readln("How are you feeling today? ").toLowerCase();

    String emoji = switch (mood) {
        case "happy", "joyful", "excited"   -> "(✿◕‿◕)";
        case "sad", "unhappy", "depressed"  -> "(╥_╥)";
        case "angry", "mad"                 -> "(╬ಠ益ಠ)";
        case "confused", "i don't know"     -> "¯\\_(ツ)_/¯";
        case "tired", "sleepy"              -> "(－_－) zzZ";
        default                             ->  "(^_^)";
    };

    println("\n" + emoji);
}
