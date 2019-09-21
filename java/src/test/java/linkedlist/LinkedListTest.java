package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest<T> {
    LinkedList<Integer> testLinkedList;
    LinkedList<Integer> testLinkedList2;
    LinkedList<Integer> testLinkedList3;
    LinkedList<Integer> testLinkedList4;

    @Before
    public void setNodes() {
        testLinkedList = new LinkedList<>();
        testLinkedList2 = new LinkedList<>();

        testLinkedList3 = new LinkedList<>();
        testLinkedList3.append(1);
        testLinkedList3.append(3);
        testLinkedList3.append(5);

        testLinkedList4 = new LinkedList<>();
        testLinkedList4.append(2);
        testLinkedList4.append(4);
        testLinkedList4.append(6);
    }

    @Test
    public void testSize_emptyLinkedList() {
        assertEquals(0, testLinkedList.size());
    }

    @Test
    public void testSize_linkedListWithOneValue() {
        testLinkedList.insert(1);
        assertEquals(1, testLinkedList.size());
    }

    @Test
    public void testSize_linkedListWithManyValues() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertEquals(3, testLinkedList.size());
    }

    @Test
    public void testIsEmpty_emptyLinkedList() {
        assertTrue(testLinkedList.isEmpty());
    }

    @Test
    public void testIsEmpty_linkedListWithValues() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        assertFalse(testLinkedList.isEmpty());
    }

    @Test
    public void testIncludes_emptyLinkedList() {
        assertFalse(testLinkedList.includes(1));
    }

    @Test
    public void testIncludes_targetValueIsFirst() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertTrue(testLinkedList.includes(1));
    }

    @Test
    public void testIncludes_targetValueIsInTheMiddle() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertTrue(testLinkedList.includes(1));
    }

    @Test
    public void testIncludes_targetValueIsTheLast() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertTrue(testLinkedList.includes(3));
    }

    @Test
    public void testIncludes_valueIsNotPresent() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertFalse(testLinkedList.includes(4));
    }

    @Test
    public void testInsert_insertToEmptyLinkedList() {
        testLinkedList.insert(1);
        assertEquals((Integer) 1, testLinkedList.getHead().getValue());
    }

    @Test
    public void testInsert_manyInserts() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        assertEquals((Integer) 3, testLinkedList.getHead().getValue());
    }

    @Test
    public void testAppend_appendToLinkedList() {
        testLinkedList.append(1);
        assertEquals((Integer) 1, testLinkedList.getHead().getValue());
    }

    @Test
    public void testInsert_manyAppends() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        Node<Integer> current = testLinkedList.getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        assertEquals((Integer) 3, current.getValue());
    }

    @Test
    public void testInsertBefore_emptyLinkedList() {
        testLinkedList.insertBefore(1,5);
        assertFalse(testLinkedList.includes(5));
    }

    @Test
    public void testInsertBefore_insertBeforeHead() {
        testLinkedList.insert(1);
        testLinkedList.insertBefore(1,2);
        assertEquals((Integer) 2, testLinkedList.getHead().getValue());
    }

    @Test
    public void testInsertBefore_insertBeforeNodeInMiddle() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        testLinkedList.insertBefore(2,4);
        assertEquals((Integer) 4, testLinkedList.getHead().getNext().getValue());
    }

    @Test
    public void testInsertBefore_insertBeforeLastNode() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        testLinkedList.insertBefore(1,4);
        assertEquals((Integer) 4, testLinkedList.getHead().getNext().getNext().getValue());
    }

    @Test
    public void testInsertBefore_multipleInsertsBefore() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        testLinkedList.insertBefore(1,4);
        testLinkedList.insertBefore(4,5);
        assertEquals((Integer) 5, testLinkedList.getHead().getNext().getNext().getValue());
    }

    @Test
    public void testInsertBefore_valueToInsertBeforeNotPresent() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        testLinkedList.insertBefore(4,4);
        assertFalse(testLinkedList.includes(4));
    }

    @Test
    public void testInsertAfter_emptyLinkedList() {
        testLinkedList.insertAfter(1,5);
        assertFalse(testLinkedList.includes(5));
    }

    @Test
    public void testInsertAfter_insertAfterHead() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.insertAfter(1,3);
        assertEquals((Integer) 3, testLinkedList.getHead().getNext().getValue());
    }

    @Test
    public void testInsertAfter_insertAfterHeadWithoutLosingRestOfValues() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.insertAfter(1,3);
        assertEquals((Integer) 2, testLinkedList.getHead().getNext().getNext().getValue());
    }


    @Test
    public void testInsertAfter_insertAfterNodeInMiddle() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        testLinkedList.insertAfter(2,4);
        assertEquals((Integer) 4, testLinkedList.getHead().getNext().getNext().getValue());
    }

    @Test
    public void testInsertAfter_insertAfterLastNode() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        testLinkedList.insertAfter(3,4);
        Node<Integer> current = testLinkedList.getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        assertEquals((Integer) 4, current.getValue());
    }

    @Test
    public void testInsertAfter_multipleInsertsAfter() {
        testLinkedList.append(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        testLinkedList.insertAfter(1,4);
        testLinkedList.insertAfter(4,5);
        assertEquals((Integer) 5, testLinkedList.getHead().getNext().getNext().getValue());
    }

    @Test
    public void testInsertAfter_valueToInsertAfterNotPresent() {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        testLinkedList.insert(3);
        testLinkedList.insertAfter(4,4);
        assertFalse(testLinkedList.includes(4));
    }

    @Test(expected=NullPointerException.class)
    public void testGetKthNodeFromEnd_emptyLinkedList() throws Exception {
        assertEquals(null, testLinkedList.getKthNodeFromEnd(0));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetKthNodeFromEnd_kIsLessThanZero() throws Exception {
        testLinkedList.insert(1);
        assertEquals(1, testLinkedList.getKthNodeFromEnd(-1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetKthNodeFromEnd_kIsEqualToSizeOfLinkedList() throws Exception {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        assertEquals(1, testLinkedList.getKthNodeFromEnd(2));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetKthNodeFromEnd_kIsGreaterThanSizeOfLinkedListMinusOne() throws Exception {
        testLinkedList.insert(1);
        testLinkedList.insert(2);
        assertEquals(1, testLinkedList.getKthNodeFromEnd(2));
    }

    @Test
    public void testGetKthNodeFromEnd_getLastItemInLinkedList() {
        testLinkedList.insert(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        assertEquals((Integer) 3, testLinkedList.getKthNodeFromEnd(0).getValue());
    }

    @Test
    public void testGetKthNodeFromEnd_getMiddleItemInLinkedList() {
        testLinkedList.insert(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        assertEquals((Integer) 2, testLinkedList.getKthNodeFromEnd(1).getValue());
    }

    @Test
    public void testGetKthNodeFromEnd_getFirstItemInLinkedList() {
        testLinkedList.insert(1);
        testLinkedList.append(2);
        testLinkedList.append(3);
        assertEquals((Integer) 1, testLinkedList.getKthNodeFromEnd(2).getValue());
    }

    @Test
    public void testMerge_emptyLists() {
        assertEquals(testLinkedList, LinkedList.merge(testLinkedList, testLinkedList2));
    }

    @Test
    public void testMerge_emptyFirstList() {
        assertEquals(testLinkedList3, LinkedList.merge(testLinkedList, testLinkedList3));
    }

    @Test
    public void testMerge_emptySecondList() {
        assertEquals(testLinkedList4, LinkedList.merge(testLinkedList2, testLinkedList4));
    }

    @Test
    public void testMerge_sameSizedLists() {
        Integer[] expectedValues = {1, 2, 3, 4, 5, 6};
        testLinkedList = LinkedList.merge(testLinkedList3, testLinkedList4);
        Node<Integer> current = testLinkedList.getHead();
        int i = 0;
        while (current != null) {
            assertEquals(expectedValues[i], current.getValue());
            i++;
            current = current.getNext();
        }
    }
}