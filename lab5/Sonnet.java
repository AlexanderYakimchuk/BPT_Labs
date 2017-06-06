package labs.lab5;

/**
 * Created by User on 14.05.2017.
 */
public class Sonnet extends Track {
    public Sonnet(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void print() {
        System.out.println("Type: sonnet; " + name + " " + duration / 60 + ":" + (duration % 60 > 9 ? duration % 60 : "0" + duration % 60));
    }
}
