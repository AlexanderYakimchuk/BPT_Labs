package labs.lab4;

/**
 * Created by User on 30.04.2017.
 */
public abstract class Char {
    protected char ch;

    abstract void print();

    /**
     * Перевіряє, чи є символ кінцем речення
     */
    boolean isEndOfSentence() {
        return false;
    }

    /**
     * Перевіряє, чи є символ пробілом
     */
    static boolean isWhitespace(char ch) {
        return Character.isWhitespace(ch);
    }

    /**
     * Перевіряє, чи є символ частиною слова
     */
    static boolean isLetterOrDigit(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    /**
     * Перевіряє, чи є символ знаком пунктуації
     */
    static boolean isPunctuation(char ch) {
        if (".,?!;:".indexOf(ch) != -1) {
            return true;
        }
        return false;
    }
}
