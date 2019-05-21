package linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest<T> {
    @Test
    public void testInsert() {
        LinkedList l = new LinkedList();
        l.append(1);
        l.append(3);
        l.append(5);

        LinkedList m = new LinkedList();
        l.append(2);
        l.append(4);
        l.append(6);

        LinkedList n = LinkedList.merge(l, m);
        System.out.println(n.print());

    }
}