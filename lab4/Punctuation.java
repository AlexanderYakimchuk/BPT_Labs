package labs.lab4;

/**
 * Created by User on 03.05.2017.
 */
public class Punctuation extends Char {
    /**
     * Номер слова, після якого в реченні ставиться даний знак
     */
    int seqNumber;

    Punctuation(char ch, int n) {
        this.ch = ch;
        seqNumber = n;
    }

    Punctuation(char ch) {
        this.ch = ch;
    }

    public boolean isEndOfSentence() {
        if (this != null && (ch == '.' || ch == '!' || ch == '?')) {
            return true;
        }
        return false;
    }

    /**
     * Повертає номер слова, після якого в реченні ставиться даний знак
     */
    public int getSeqNumber() {
        return seqNumber;
    }

    public void print() {
        System.out.print(ch);
    }
}
