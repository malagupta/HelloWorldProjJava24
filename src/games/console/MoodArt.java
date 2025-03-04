/**
 * A simple, but creative console application that displays ASCII art scenes based on user's mood selection.
 * The program presents different artistic representations combining ASCII characters and emojis
 * to create scenes that reflect various emotional states (happy, sad, angry, confused, or neutral).
 * This game could be extended to include other emotions, or display other patterns.
 */
void main() {
    String mood = readln("""
        How are you feeling today?
         1 - Happy
         2 - Sad
         3 - Angry
         4 - Confused
         5 - You don't know)? \n
          """).toLowerCase();
    
    switch (mood) {
        case "1", "happy" -> printHappyScene();
        case "2", "sad" -> printSadScene();
        case "3", "angry" -> printAngryScene();
        case "4", "5", "confused", "i don't know"  -> printConfusedScene();
        default  -> printNeutralScene();
    }
}

void printHappyScene() {
    println("""
                     \\(^_^)/        🌞☁️     
                      / | \\        🌳 🌳      
                       | |      🏡   🚶‍♂️   🌷🌼 
                    _/   \\_       🚶‍♀️   🐦    
             A bright sunny day, kids are playing, birds are singing!""");
}

void printSadScene() {
    println("""
                      (T_T)         ☁️☁️🌧️   
                      / |\\         🌳  🚶‍♂️  🌲 
                       | |       🌼    💧💧   🌸 
                      /   \\      🏠   🚶‍♀️      
             It's a rainy evening, people walk quietly, lost in thought...""");
}

void printAngryScene() {
    println("""
                 (╬ಠ益ಠ)       ⚡⚡    
                  --|--      🌲🔥🌲   
                   / \\       🚗💨🚗💨  
              The streets are chaotic, cars honking, lightning strikes!""");
}

void printConfusedScene() {
    println("""
                  ¯\\_(ツ)_/¯     🛤️🔀  
                   /  |  \\     🌳🚶‍♂️🌳  
                    o   o      🏡  🌼  
               You stand at a crossroads, unsure of which path to take.""");
}

void printNeutralScene() {
    println("""
                   (•_•)      🌅🌳  
                   -| | -     🏠🚶‍♂️  
                   /   \\     🌸  🚶‍♀️ 
             Just another normal day, the world moves as usual...""");
}

