package labs.lab6;

import labs.lab5.Track;
import labs.lab7.MyException;

import java.util.*;

/**
 * Created by User on 08.05.2017.
 */

public class MyCollection implements Set<Track> {

    private Track[] sequence;
    private int size;

    public class MySetIterator implements ListIterator<Track> {

        private Track next;
        private Track prev;
        private Track lastReturned = null;
        private int nextIndex = 0;
        private int prevIndex = 0;

        public MySetIterator(int i) throws MyException {
            if (i < 0 || i > size) {
                throw new MyException("Incorrect index");
            }
            next = (i == size) ? null : sequence[i];
            prev = (i == 0) ? null : sequence[i - 1];
            nextIndex = i;
            prevIndex = i - 1;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Track next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            nextIndex++;
            prevIndex++;
            if (nextIndex < size) {
                next = sequence[nextIndex];
            } else {
                next = null;
            }
            prev = sequence[prevIndex];
            return lastReturned;
        }

        @Override
        public boolean hasPrevious() {
            return prevIndex >= 0;
        }

        @Override
        public Track previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = prev;
            nextIndex--;
            prevIndex--;
            next = sequence[nextIndex];
            if (prevIndex >= 0) {
                prev = sequence[prevIndex];
            } else {
                prev = null;
            }

            return lastReturned;
        }

        @Override
        public int nextIndex() {
            return nextIndex < size ? nextIndex : size;
        }

        @Override
        public int previousIndex() {
            return prevIndex > 0 ? prevIndex : -1;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            for (int i = 0; i < size; i++) {
                if (sequence[i].hashCode() == lastReturned.hashCode()) {
                    for (int j = i; j < size - 1; j++) {
                        sequence[j] = sequence[j + 1];
                    }
                    size--;
                    sequence[size] = null;
                }
            }
            lastReturned = null;
        }

        @Override
        public void set(Track track) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Track track) {
            if (track == null) {
                throw new NullPointerException();
            }
            if (lastReturned==null){
                if (size < sequence.length) {
                    sequence[size] = track;
                    size++;
                } else {
                    Track[] arr = new Track[sequence.length + sequence.length / 2];
                    for (int i = 0; i < sequence.length; i++) {
                        arr[i] = sequence[i];
                    }
                    sequence = arr;
                    size++;
                }
            } else {
                if (size < sequence.length) {
                    int k;
                    for (k = 0; k < size; k++) {
                        if (sequence[k].hashCode() == lastReturned.hashCode()) {
                            break;
                        }
                    }
                    size++;
                    for (int i = size - 1; i > k; i--) {
                        sequence[i] = sequence[i - 1];
                    }
                    sequence[k] = track;

                } else {
                    Track[] arr = new Track[sequence.length + sequence.length / 2];
                    int k;
                    for (k = 0; k < size; k++) {
                        if (sequence[k].hashCode() == lastReturned.hashCode()) {
                            break;
                        }
                        arr[k] = sequence[k];
                    }
                    arr[k] = lastReturned;
                    for (int i = k; i < size; i++) {
                        arr[i + 1] = sequence[i];
                    }
                    size++;

                }
            }
        }
    }

    MyCollection() {
        sequence = new Track[10];
        size = 0;
    }

    MyCollection(Track t) {
        sequence = new Track[10];
        size = 0;
        add(t);
    }

    MyCollection(ArrayList<Track> a) {
        sequence = new Track[10];
        size = 0;
        addAll(a);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!(o instanceof Track)) {
            throw new ClassCastException();
        }
        Track t = (Track) o;
        for (int i = 0; i < size(); i++) {
            if (sequence[i].hashCode() == t.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MySetIterator iterator() {
        try {
            return new MySetIterator(0);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Track[] toArray() {
        return sequence;
    }

    @Override
    public boolean add(Track o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (contains(o)) {
            return false;
        }
        if (size < sequence.length) {
            sequence[size] = o;
            size++;
        } else {
            Track[] arr = new Track[sequence.length + sequence.length / 2];
            for (int i = 0; i < sequence.length; i++) {
                arr[i] = sequence[i];
            }
            sequence = arr;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!(o instanceof Track)) {
            throw new ClassCastException();
        }
        for (int i = 0; i < size; i++) {
            if (sequence[i].hashCode() == o.hashCode()) {
                for (int j = i; j < size - 1; j++) {
                    sequence[j] = sequence[j + 1];
                }
                size--;
                sequence[size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean ind = false;
        for (Object o :
                c) {
            if (o == null) {
                throw new NullPointerException();
            }
            if (!(o instanceof Track)) {
                throw new ClassCastException();
            }
            if (add((Track) o) && !ind) {
                ind = true;
            }
        }
        return ind;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            sequence[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean ind = false;
        for (Object o :
                c) {
            if (o == null) {
                throw new NullPointerException();
            }
            if (!(o instanceof Track)) {
                throw new ClassCastException();
            }
            if (remove(o) && !ind) {
                ind = true;
            }
        }
        return ind;
    }

    @Override
    public boolean retainAll(Collection c) {
        ArrayList<Track> arr = new ArrayList<>();

        boolean ind = false;
        for (Object o :
                c) {
            if (o == null) {
                throw new NullPointerException();
            }
            if (!(o instanceof Track)) {
                throw new ClassCastException();
            }
            if (contains(o)) {
                arr.add((Track) o);
            }
        }
        if (size() == arr.size()) {
            return false;
        }
        clear();
        addAll(arr);
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o :
                c) {
            if (o == null) {
                throw new NullPointerException();
            }
            if (!(o instanceof Track)) {
                throw new ClassCastException();
            }
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {

        return new Track[0];
    }
}
