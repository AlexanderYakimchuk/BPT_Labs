package labs.lab4;

/**
 * Created by User on 30.04.2017.
 */
public class Letter extends Char {

    Letter(){
        ch=0;
    }

    Letter(char ch){
        this.ch=ch;
    }

    @Override
    public void print() {
        System.out.print(ch);
    }
}
