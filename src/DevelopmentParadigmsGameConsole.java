/**
 * Often I read developers sharing their favorite 'Development Paradigms' in person or on the social
 * platforms - that are a fun take on the actual development paradigms. This game is inspired by those
 * interactions .
 * This is a console-based game that assigns humorous development paradigm styles based on user input.
 * Users enter letters A-Z to discover different development styles and their descriptions.
 * The game continues until the user enters '0' to quit.
 */
void main() {
    Map<Character, String[]> devStyles = new HashMap<>();
    populateDevelopmentStylesMap(devStyles);

    char input = readln("Enter a letter (A-Z) to find out your Development Style (or 0 to quit game): ").toUpperCase().charAt(0);

    while (input != '0') {
        if (devStyles.containsKey(input)) {
            String[] messages = devStyles.get(input);
            println("** " + messages[0] + " **");
            println(messages[1]);
        } else {
            println("Invalid input! Please enter a letter from A-Z.");
        }
        input = readln("\n\nEnter a letter (A-Z) to find out your Development Style (or 0 to quit game): ").toUpperCase().charAt(0);
    }

}

private void populateDevelopmentStylesMap(Map<Character, String[]> devStyles) {
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
