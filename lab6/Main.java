package labs.lab6;

import labs.lab5.Track;
import labs.lab5.Sonnet;
import labs.lab5.Song;
import labs.lab5.Symphony;

/**
 * Created by User on 09.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyCollection tracks = new MyCollection();
        tracks.add(new Symphony("symphony1", 32));
        tracks.add(new Symphony("symphony2", 32));
        tracks.add(new Symphony("symphony3", 32));
        tracks.add(new Song("song1", 32));
        tracks.add(new Song("song2", 32));
        tracks.add(new Song("song3", 32));
        tracks.add(new Sonnet("sonnet1", 32));
        tracks.add(new Sonnet("sonnet2", 32));
        tracks.remove(new Song("song1", 32));
        MyCollection.MySetIterator it = tracks.iterator();
        System.out.println(tracks.size());
        while (it.hasNext()){
            it.next().print();
        }
        while (it.hasPrevious()){
            it.previous().print();
        }



    }
}
