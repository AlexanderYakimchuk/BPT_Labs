package labs.lab4;

/**
 * Created by User on 29.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        String s = new String("Some, text. Some more; text? And a little: more text!..");
        /**
         * Створюєм ієрархію
         */
        Text text = new Text(s);
        /**
         * Завдання по варіанту
         */
        text.swap();
        text.print();
    }
}
