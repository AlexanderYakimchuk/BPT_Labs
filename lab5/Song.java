package labs.lab5;

/**
 * Created by User on 13.05.2017.
 */
public class Song extends Track {
    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public void print(){
        System.out.println("Type: song; "+name + " " + duration / 60 + ":" + (duration % 60>9?duration % 60:"0"+duration % 60) );
    }

}
