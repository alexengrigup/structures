package dev.alexengrig.structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListTest {
    public void doCheckListFlow(List<? super String> list) {
        assertEquals(0, list.size());

        list.add("1");
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));

        list.add(0, "2");
        assertEquals(2, list.size());
        assertEquals("2", list.get(0));
        assertEquals("1", list.get(1));

        list.remove("2");
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));

        list.addAll(Arrays.asList("2", "3"));
        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));

        list.addAll(1, Arrays.asList("1.3", "1.7"));
        assertEquals(5, list.size());
        assertEquals("1", list.get(0));
        assertEquals("1.3", list.get(1));
        assertEquals("1.7", list.get(2));
        assertEquals("2", list.get(3));
        assertEquals("3", list.get(4));

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void checkArrayList() {
        doCheckListFlow(new ArrayList<>());
    }
}