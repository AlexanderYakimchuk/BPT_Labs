package labs.lab4;

import java.util.ArrayList;

/**
 * Created by User on 30.04.2017.
 */
public class Text {
    ArrayList<Sentence> sequence;

    Text() {
        sequence = new ArrayList<>();
    }

    /**
     * Розбиває вхідий рядок на символи і будує ієрархію
     */
    Text(String s) {
        sequence = new ArrayList<>();
        Word word = new Word();
        Sentence sentence = new Sentence();
        char c;
        char p = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (Char.isLetterOrDigit(p)) {
                word.addLetter(new Letter(p));

                if (Char.isPunctuation(c)) {
                    sentence.addWord(word);
                    sentence.addPunctuation(c);
                    word = new Word();
                }
                if (Char.isWhitespace(c)) {
                    sentence.addWord(word);
                    word = new Word();
                }
            }

            if (Char.isPunctuation(p)) {
                if (Char.isLetterOrDigit(c) || Char.isWhitespace(c)) {
                    if (new Punctuation(p).isEndOfSentence()) {
                        this.addSentence(sentence);
                        sentence = new Sentence();
                    }
                }
                if (Char.isPunctuation(c)) {
                    sentence.addPunctuation(c);
                }
            }
            p = c;
        }
        this.addSentence(sentence);
    }

    /**
     * Додає речення в текст
     */
    public void addSentence(Sentence s) {
        sequence.add(s);
    }

    public void print() {
        for (Sentence sentence :
                sequence) {
            sentence.print();
        }
    }

    /**
     * Міняє місцями перше і останнє слово в кожному реченні тексту
     */
    public void swap() {
        for (Sentence s :
                sequence) {
            s.swap();
        }
    }
}
