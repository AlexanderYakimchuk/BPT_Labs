package labs.lab5;

/**
 * Created by User on 07.05.2017.
 */
public class Main {
    public static void main(String[] args) {

        Disk disk = new Disk();
        Album a1 = new Album("album1","Skillet", Genre.ROCK);
        Album a2 = new Album("album2","Eminem", Genre.HIPHOP);
        Album a3 = new Album("album3","Vivaldi", Genre.EASY);
        Album a4 = new Album("album4","WILLIAM SHAKESPEARE", Genre.EASY);
        a1.addTrack(new Song("Comatose", 123));
        a1.addTrack(new Song("Hero", 213));
        a1.addTrack(new Song("Rise", 140));

        a2.addTrack(new Song("Kill you", 300));
        a2.addTrack(new Song("Devil's night", 219));

        a3.addTrack(new Symphony("Spring", 413));
        a3.addTrack(new Symphony("Winter", 453));
        a3.addTrack(new Symphony("Summer", 395));

        a4.addTrack(new Sonnet("Sonnet 106", 273));
        a4.addTrack(new Sonnet("Sonnet 138", 245));

        disk.addAlbum(a1);
        disk.addAlbum(a2);
        disk.addAlbum(a3);
        disk.addAlbum(a4);

        disk.sortByGenre();
        disk.print();

        disk.showTotalDuration();

        disk.print(disk.searchByDuration(100, 200));
    }
}
