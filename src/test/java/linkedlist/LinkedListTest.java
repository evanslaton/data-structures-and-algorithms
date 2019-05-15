package linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest<T> {
    @Test
    public void testInsert() {
        LinkedList l = new LinkedList();

        assertEquals(null, l.getHead());

        l.insert(100);
        assertEquals(100, l.getHead().getValue());
        assertEquals(null, l.getHead().getNext());

        l.insert("String");
        assertEquals("String", l.getHead().getValue());
        assertEquals(100, l.getHead().getNext().getValue());

        l.insert(true);
        assertEquals(true, l.getHead().getValue());
        assertEquals("String", l.getHead().getNext().getValue());
        assertEquals(100, l.getHead().getNext().getNext().getValue());

        assertTrue(l.includes(true));
        assertTrue(l.includes("String"));
        assertTrue(l.includes(100));

        assertFalse(l.includes(false));
        assertFalse(l.includes('a'));
        assertFalse(l.includes(1.346));

        List<Object> lValues = new ArrayList<>();
        lValues.add(true);
        lValues.add("String");
        lValues.add(100);

        assertEquals(true, l.print().get(0));
        assertEquals("String", l.print().get(1));
        assertEquals(100, l.print().get(2));

        l.append('a');
        System.out.println(l.print());

        l.insertBefore(100, "insertBefore");
        System.out.println(l.print());
    }
}