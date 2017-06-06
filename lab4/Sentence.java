package labs.lab4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by User on 30.04.2017.
 */
public class Sentence {
    private ArrayList<Word> words;
    private ArrayList<Punctuation> punctuations;

    Sentence() {
        words = new ArrayList<>();
        punctuations = new ArrayList<>();
    }

    /**
     * Додає слово в речення
     */
    public void addWord(Word w) {
        words.add(w);
    }

    /**
     * Додає знак пунктуації в речення
     */
    public void addPunctuation(char ch) {
        punctuations.add(new Punctuation(ch, words.size() - 1));

    }

    public void print() {
        int j = 0;
        for (int i = 0; i < words.size(); i++) {
            words.get(i).print();
            while (j < punctuations.size() && punctuations.get(j).getSeqNumber() == i) {
                punctuations.get(j).print();
                j++;
            }
            System.out.print(' ');
        }
    }

    /**
     * Міняє місцями перше і останнє слово в реченні
     */
    public void swap() {
        Collections.swap(words, 0, words.size() - 1);
    }
}
