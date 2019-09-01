package linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test
    public void testNode() {
        Node l = new Node
                .Builder()
                .value(10)
                .build();

        assertEquals(10, l.getValue());
        assertEquals(null, l.getNext());

        Node m = new Node
                .Builder()
                .value('m')
                .next(l)
                .build();

        assertEquals('m', m.getValue());
        assertEquals(l, m.getNext());

        Node n = new Node
                .Builder()
                .value(false)
                .next(m)
                .build();

        assertEquals(false, n.getValue());
        assertEquals(m, n.getNext());

        l.setValue(5.5);
        l.setNext(n);
        assertEquals(5.5, l.getValue());
        assertEquals(n, l.getNext());

        Node o = new Node("String", new Node("otherString", null));

        assertEquals("String", o.getValue());
        assertEquals("otherString", o.getNext().getValue());
        assertEquals(null, o.getNext().getNext());
    }

}