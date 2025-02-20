import static java.io.IO.print;
import static java.io.IO.println;

public class Patterns {
    void main() {
        int size = 10;
        char charToPrint = 'X';
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == 0 || (i == 0 || i == size / 2) && j < size - 1 || (j == size - 1 && i <= size / 2)) {
                    print(charToPrint + " ");
                } else {
                    print("  ");
                }
            }
            println();
        }
    }
}