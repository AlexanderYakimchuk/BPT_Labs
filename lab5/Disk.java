package labs.lab5;

import java.util.ArrayList;

/**
 * Created by User on 07.05.2017.
 */

/**
 * Диск містить інформацію про записані на ньому альбоми
 */
public class Disk {

    private ArrayList<Album> albums;

    Disk() {
        albums = new ArrayList<>();
    }

    /**
     * Записати альбом на диск
     */
    public void addAlbum(Album album) {
        albums.add(album);
    }

    /**
     * Підраховує загальну тривалість всіх альбомів диску
     */
    public int getTotalDuration() {
        int duration = 0;
        for (Album a :
                albums) {
            duration += a.getDuration();
        }
        return duration;
    }

    public void showTotalDuration() {
        int duration = getTotalDuration();
        System.out.println("Total duration: " + duration / 3600 + ':' + duration % 3600 / 60 + ':' + duration % 60);
    }


    private void sort(Album[] a) {
        Album t;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].getGenre().compareTo(a[j].getGenre()) > 0) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

    }

    /**
     * Сортує альбоми за жанрами
     */
    public void sortByGenre() {
        Album[] arr = new Album[albums.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = albums.get(i);
        }
        albums.clear();

        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            albums.add(arr[i]);
        }
    }

    /**
     * Повертає всі треки, що підходять під заданий діапазон тривалості(в секундах)
     */
    public ArrayList<Track> searchByDuration(int from, int to) {
        ArrayList<Track> list = new ArrayList<>();
        for (Album a :
                albums) {
            for (Track t :
                    a.searchByDuration(from, to)) {
                list.add(t);
            }
        }
        return list;
    }

    public void print() {
        for (Album a :
                albums) {
            a.print();
        }
    }

    public void print(ArrayList<Track> tracks) {
        for (Track t :
                tracks) {
            t.print();
        }
    }
}
