package labs.lab5;

import org.omg.CORBA.Object;

/**
 * Created by User on 07.05.2017.
 */
public abstract class Track {
    protected String name;
    protected int duration; // in seconds

    Track() {
    }

    public String getName() {
        return name;
    }

    Track(String name, int minutes, int seconds) {
        this.name = name;
        this.duration = minutes * 60 + seconds;
    }

    public abstract void print();

    public int getDuration() {
        return duration;
    }


    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getDuration();
        return result;
    }
}
