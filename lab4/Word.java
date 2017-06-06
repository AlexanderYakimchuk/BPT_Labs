package labs.lab4;

import java.util.ArrayList;

/**
 * Created by User on 30.04.2017.
 */
public class Word {
    private ArrayList<Letter> sequence;

    Word() {
        sequence = new ArrayList<>();
    }

    /**
     * Додає літеру в слово
     */
    public void addLetter(Letter a) {
        sequence.add(a);
    }

    public void print() {
        for (Letter l :
                sequence) {
            l.print();
        }
    }
}
