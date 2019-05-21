/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakeness within.
 * Single Linked List
 */
public class SLList {

    private static class IntNode {
        public int item;
        public IntNode next;
    
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Create an empty list. */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Return the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    public void deleteFirst() {
        if (sentinel.next == null) {
            return;
        }
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    /** Add x to the last of the list. */
    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        L.deleteFirst();
        System.out.println(L.getFirst());
        L.deleteFirst();
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }

}