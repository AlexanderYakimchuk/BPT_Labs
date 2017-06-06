package labs.lab7;

import labs.lab5.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Created by User on 06.06.2017.
 */
public class MyCollectionTest {
    private MyCollection tracks;

    @Before
    public void init() {
        tracks = new MyCollection();
    }

    @After
    public void setDown() {
        tracks = null;
    }

    @Test
    public void testSizeEmptySet() {
        assertEquals(tracks.size(), 0);
    }

    @Test
    public void testContains() {
        tracks.add(new Symphony("symphony1", 324));
        assertTrue(tracks.contains((new Symphony("symphony1", 324))));
        assertFalse(tracks.contains((new Symphony("symphony1", 3264))));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNull() {
        tracks.contains(null);
    }

    @Test(expected = ClassCastException.class)
    public void testContainsClassCastException() {
        tracks.contains(new Object());
    }

    @Test
    public void testAdd() {
        assertTrue(tracks.add(new Symphony("symphony1", 324)));
        assertFalse(tracks.add(new Symphony("symphony1", 324)));
    }

    @Test
    public void testAddRepeating() {
        tracks.add(new Symphony("symphony1", 324));
        assertFalse(tracks.add(new Symphony("symphony1", 324)));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        tracks.add(null);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tracks.isEmpty());
        tracks.add(new Song("song", 234));
        assertFalse(tracks.isEmpty());
    }

    @Test
    public void testRemove() {
        assertFalse(tracks.remove(new Song("song", 234)));
        tracks.add(new Song("song", 234));
        assertTrue(tracks.remove(new Song("song", 234)));
        assertFalse(tracks.contains(new Song("song", 234)));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull() {
        tracks.remove(null);
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveClassCastException() {
        tracks.remove(new Object());
    }

    @Test
    public void testAddAll() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(new Sonnet("sonnet1", 193));
        assertTrue(tracks.addAll(arr));
        assertFalse(tracks.addAll(arr));
        assertEquals(tracks.size(), 3);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNullPointerException() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(null);
        tracks.addAll(arr);
    }

    @Test(expected = ClassCastException.class)
    public void testAddAllClassCastException() {
        ArrayList<java.lang.Object> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(new java.lang.Object());
        tracks.addAll(arr);
    }

    @Test
    public void testClear() {
        tracks.add(new Symphony("symphony1", 324));
        tracks.add(new Song("song1", 122));
        tracks.clear();
        assertEquals(tracks.size(), 0);
        assertFalse(tracks.contains(new Song("song1", 122)));
        assertFalse(tracks.contains(new Symphony("symphony1", 324)));
    }

    @Test
    public void testRemoveAll() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(new Sonnet("sonnet1", 193));
        tracks.addAll(arr);
        assertTrue(tracks.removeAll(arr));
        assertFalse(tracks.removeAll(arr));
        assertEquals(tracks.size(), 0);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveAllNullPointerException() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(null);
        tracks.removeAll(arr);
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveAllClassCastException() {
        ArrayList<java.lang.Object> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(new java.lang.Object());
        tracks.removeAll(arr);
    }

    @Test
    public void testRetainAll() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        tracks.addAll(arr);
        tracks.add(new Sonnet("sonnet1", 193));
        assertTrue(tracks.retainAll(arr));
        assertFalse(tracks.retainAll(arr));
        assertEquals(tracks.size(), 2);
    }

    @Test(expected = NullPointerException.class)
    public void testRetainAllNullPointerException() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(null);
        tracks.retainAll(arr);
    }

    @Test(expected = ClassCastException.class)
    public void testRetainAllClassCastException() {
        ArrayList<java.lang.Object> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(new java.lang.Object());
        tracks.retainAll(arr);
    }

    @Test
    public void testContainsAll() {
        ArrayList<java.lang.Object> arr = new ArrayList<>();
        arr.add(new Symphony("symphony1", 123));
        arr.add(new Song("song1", 122));
        arr.add(new Sonnet("sonnet1", 193));
        tracks.addAll(arr);
        assertTrue(tracks.containsAll(arr));
        arr.add(new Sonnet("sonnet2", 234));
        assertFalse(tracks.containsAll(arr));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAllNullPointerException() {
        ArrayList<Track> arr = new ArrayList<>();
        arr.add(new Sonnet("sonnet1", 193));
        arr.add(null);
        tracks.retainAll(arr);
    }

    @Test
    public void testIteratorHasNext() {
        try {
            MyCollection.MySetIterator it = tracks.new MySetIterator(0);
            assertFalse(it.hasNext());
            tracks.add((new Sonnet("sonnet1", 193)));
            assertTrue(it.hasNext());
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIteratorNext() {
        Sonnet s = new Sonnet("sonnet1", 193);
        tracks.add(s);
        MyCollection.MySetIterator it = tracks.iterator();
        Sonnet s1 = (Sonnet) it.next();
        assertEquals(s1.hashCode(), s.hashCode());
    }

    @Test
    public void testIteratorRemove() {
        tracks.add(new Sonnet("sonnet1", 193));
        MyCollection.MySetIterator it = tracks.iterator();
        it.next();
        it.remove();
        assertTrue(tracks.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testIteratorRemoveIllegalStateException() {
        tracks.add(new Sonnet("sonnet1", 193));
        MyCollection.MySetIterator it = tracks.iterator();
        it.remove();
    }


    @Test
    public void testIteratorHasPrevious() {
        tracks.add((new Sonnet("sonnet1", 193)));
        tracks.add((new Sonnet("sonnet1", 103)));
        MyCollection.MySetIterator it = tracks.iterator();
        assertFalse(it.hasPrevious());
        it.next();
        assertTrue(it.hasPrevious());
    }

    @Test
    public void testIteratorPrevious() {
        Sonnet s = new Sonnet("sonnet1", 193);
        tracks.add(s);
        tracks.add(new Sonnet("sonnet1", 293));
        MyCollection.MySetIterator it = tracks.iterator();
        it.next();
        Sonnet s1 = (Sonnet) it.previous();
        assertEquals(s1.hashCode(), s.hashCode());
    }


}
