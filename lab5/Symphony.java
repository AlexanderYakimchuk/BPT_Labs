package labs.lab5;

/**
 * Created by User on 14.05.2017.
 */
public class Symphony extends Track {

    public Symphony(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    public void print(){
        System.out.println("Type: symphony; "+name + " " + duration / 60 + ":" + (duration % 60>9?duration % 60:"0"+duration % 60) );
    }
}
