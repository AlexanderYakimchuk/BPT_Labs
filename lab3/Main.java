package labs.lab3;

/**
 * Created by User on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Some text. Some more text. And a little more text.");
        StringBuilder sentence;
        StringBuilder newtext = new StringBuilder("");
        StringBuilder word1;
        StringBuilder word2;
        int next = text.indexOf(".");
        int prev = -1;
        while (next != -1) {
            sentence = new StringBuilder(text.subSequence(prev + 1, next));
            if (sentence.charAt(0) == ' ') {
                sentence = new StringBuilder(sentence.substring(1));
            }
            word1 = new StringBuilder(sentence.substring(0, sentence.indexOf(" ")));
            word2 = new StringBuilder(sentence.substring(sentence.lastIndexOf(" ") + 1, sentence.length()));
            word2.replace(0, 1, word2.substring(0, 1).toUpperCase());
            sentence.replace(0, sentence.indexOf(" "), word2.toString());
            sentence.replace(sentence.lastIndexOf(" "), sentence.length(), " " + word1.toString());
            newtext.append(sentence);
            newtext.append(". ");
            prev = next;
            next = text.indexOf(".", next + 1);
        }
        System.out.println(text);
        System.out.println(newtext);

    }
}
