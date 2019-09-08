package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest<T> {
    LinkedList<Character> linkedList1;
    LinkedList<Integer> linkedList2;
    LinkedList<Boolean> linkedList3;
    LinkedList<String> linkedList4;

    @Before
    public void setNodes() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
        linkedList3 = new LinkedList<>();
        linkedList4 = new LinkedList<>();

        linkedList1.insert('D');
        linkedList1.insert('C');
        linkedList1.insert('B');
        linkedList1.insert('A');

        linkedList2.insert(3);
        linkedList2.insert(2);
        linkedList2.insert(1);

        linkedList3.insert(true);
        linkedList3.insert(false);
    }

    @Test
    public void testSize() {
        assertEquals(4, linkedList1.size());
        assertEquals(3, linkedList2.size());
        assertEquals(2, linkedList3.size());
        assertEquals(0, linkedList4.size());
        linkedList4.append("String");
        assertEquals(1, linkedList4.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(linkedList1.isEmpty());
        assertFalse(linkedList2.isEmpty());
        assertFalse(linkedList3.isEmpty());
        assertTrue(linkedList4.isEmpty());
        linkedList4.append("String");
        assertFalse(linkedList4.isEmpty());
    }

    @Test
    public void testIncludes_emptyLinkedList() {
        assertFalse(linkedList4.includes("String"));
        assertFalse(linkedList4.includes("Other string"));
    }

    @Test
    public void testIncludes() {
        assertTrue(linkedList1.includes('A'));
        assertTrue(linkedList1.includes('B'));
        assertTrue(linkedList1.includes('C'));
        assertTrue(linkedList1.includes('D'));
        assertFalse(linkedList1.includes('E'));
        linkedList1.insert('E');
        assertTrue(linkedList1.includes('E'));

        assertTrue(linkedList2.includes(1));
        assertTrue(linkedList2.includes(2));
        assertTrue(linkedList2.includes(3));
        assertFalse(linkedList2.includes(4));
        linkedList2.insert(5);
        assertTrue(linkedList2.includes(5));

        assertTrue(linkedList3.includes(true));
        assertTrue(linkedList3.includes(false));

        linkedList4.insert("String");
        linkedList4.insert("Other string");
        assertTrue(linkedList4.includes("String"));
        assertTrue(linkedList4.includes("Other string"));
    }

    @Test
    public void testInsert_emptyLinkedList() {
        assertEquals(null, linkedList4.getHead());
        linkedList4.insert("String");
        assertEquals("String", linkedList4.getHead().getValue());
        assertEquals(1, linkedList4.size());
    }

    @Test
    public void testInsert_manyInserts() {
        linkedList1.insert('!');
        assertEquals((Character) '!', linkedList1.getHead().getValue());
        assertEquals(5, linkedList1.size());
        linkedList1.insert('?');
        assertEquals((Character) '?', linkedList1.getHead().getValue());
        assertEquals(6, linkedList1.size());
    }

    @Test
    public void testAppend_emptyLinkedList() {
        linkedList4.append("String");
        Node<String> testNode = linkedList4.getHead();
        assertEquals("String", testNode.getValue());
        assertEquals(1, linkedList4.size());

        linkedList4.append("String2");
        testNode = linkedList4.getHead();
        while(testNode.getNext() != null) {
            testNode = testNode.getNext();
        }
        assertEquals("String2", testNode.getValue());
        assertEquals(2, linkedList4.size());
    }

    @Test
    public void testAppend_manyAppends() {
        linkedList1.append('E');
        Node<Character> testNode = linkedList1.getHead();
        while(testNode.getNext() != null) {
            testNode = testNode.getNext();
        }
        assertEquals((Character) 'E', testNode.getValue());
        assertEquals(5, linkedList1.size());

        linkedList1.append('F');
        testNode = linkedList1.getHead();
        while(testNode.getNext() != null) {
            testNode = testNode.getNext();
        }
        assertEquals((Character) 'F', testNode.getValue());
        assertEquals(6, linkedList1.size());
    }

    @Test
    public void testInsertBefore_insertBeforeFirstNode() {
        assertEquals((Character) 'A', linkedList1.getHead().getValue());
        linkedList1.insertBefore('A', '!');
        assertEquals((Character) '!', linkedList1.getHead().getValue());
        linkedList1.insertBefore('!', '?');
        assertEquals((Character) '?', linkedList1.getHead().getValue());
    }

    @Test
    public void testInsertBefore_manyInserts() {
        linkedList1.insertBefore('A', '!');
        assertEquals((Character) '!', linkedList1.getHead().getValue());

        linkedList1.insertBefore('D', 'E');
        assertEquals((Character) 'E', linkedList1.getHead()
                .getNext()
                .getNext()
                .getNext()
                .getNext()
                .getValue());

        linkedList1.insertBefore('E', 'F');
        assertEquals((Character) 'F', linkedList1.getHead()
                .getNext()
                .getNext()
                .getNext()
                .getNext()
                .getValue());
    }

    @Test
    public void testInsertBefore_valueToInsertBeforeNotPresent() {
        linkedList1.insertBefore('Z', 'E');
        assertEquals(4, linkedList1.size());
        assertFalse(linkedList1.includes('Z'));

        linkedList1.insertBefore('9', '?');
        assertEquals(4, linkedList1.size());
        assertFalse(linkedList1.includes('9'));
    }

    @Test
    public void testInsertBefore_emptyLinkedList() {
        linkedList4.insertBefore("String", "insertBefore");
        assertEquals(0, linkedList4.size());
        assertFalse(linkedList4.includes("String"));
    }
}