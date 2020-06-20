package dev.alexengrig.structures;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyListTest {
    @Test
    public void should_create_emptyList() {
        //noinspection MismatchedQueryAndUpdateOfCollection
        List<Integer> list = new MyList<>();
        assertEquals(0, list.size());
    }

    @Test
    public void should_create_emptyList_and_add_oneElement() {
        List<Integer> list = new MyList<>();
        assertEquals(0, list.size());
        assertTrue(list.add(1));
        assertEquals(1, list.size());
    }

    @Test
    public void should_create_emptyList_and_add_twoElements() {
        List<Integer> list = new MyList<>();
        assertEquals(0, list.size());
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertTrue(list.add(2));
        assertEquals(2, list.size());
    }

    @Test
    public void should_create_emptyList_and_add_threeElements() {
        List<Integer> list = new MyList<>();
        assertEquals(0, list.size());
        assertTrue(list.add(1));
        assertEquals(1, list.size());
        assertTrue(list.add(2));
        assertEquals(2, list.size());
        assertTrue(list.add(3));
        assertEquals(3, list.size());
    }

    @Test
    public void should_approve_containElement() {
        List<Integer> list = new MyList<>();
        Integer element = 1;
        assertTrue(list.add(element));
        assertTrue(list.contains(element));
    }

    @Test
    public void should_approve_removeElement() {
        List<Integer> list = new MyList<>();
        Integer element = 1;
        assertTrue(list.add(element));
        assertTrue(list.remove(element));
    }
}