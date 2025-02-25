public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] choices = {"Rock", "Paper", "Scissors"};

    System.out.println("Welcome to Rock, Paper, Scissors!");

    while (true) {
        // Display choices
        println("\nEnter your choice (0 = Rock, 1 = Paper, 2 = Scissors, 3 = Exit): ");
        int userChoice = scanner.nextInt();

        if (userChoice == 3) {
            println("Thanks for playing!");
            break;
        } else if (userChoice < 0 || userChoice > 2) {
            println("Invalid choice. Try again.");
            continue;
        }

        // Computer's choice
        int computerChoice = random.nextInt(3);
        println("Computer chose: " + choices[computerChoice]);
        println("You chose: " + choices[userChoice]);

        // Determine the winner
        if (userChoice == computerChoice) {
            println("It's a draw!");
        } else if ((userChoice == 0 && computerChoice == 2) || (userChoice == 1 && computerChoice == 0) || (userChoice == 2 && computerChoice == 1)) {
            println("You win!");
        } else {
            println("Computer wins!");
        }
    }
    scanner.close();
}
