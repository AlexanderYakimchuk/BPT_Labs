package labs.lab5;

import java.util.ArrayList;

/**
 * Created by User on 07.05.2017.
 */

/**
 * Альбом містить інформацію про автора, його композиції та їх жанр
 */
public class Album {
    private String name;
    private String artist;
    private Genre genre;
    private ArrayList<Track> tracks;

    Album(String name, String artist, Genre genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        tracks = new ArrayList<>();
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    /**
     * Обраховує загальну тривалість треків в альбомі
     */
    public int getDuration() {
        int duration = 0;
        for (Track t :
                tracks) {
            duration += t.getDuration();
        }
        return duration;
    }

    /**
     * Виводить на екран вміст альбому
     */
    public void print() {
        System.out.println("Name: " + name + "\nArtist: " + artist + "\nGenre: " + genre.toString().toLowerCase());
        for (Track t :
                tracks) {
            System.out.printf("     ");
            t.print();
        }
    }

    public Genre getGenre() {
        return genre;
    }

    /**
     * Пошук композицій в альбомі, що відповідають заданому діапазону тривалості(в секундах)
     */
    public ArrayList<Track> searchByDuration(int from, int to) {
        ArrayList<Track> list = new ArrayList<>();
        for (Track a :
                tracks) {
            if (a.getDuration() <= to && a.getDuration() >= from) {
                list.add(a);
            }
        }
        return list;
    }

}
