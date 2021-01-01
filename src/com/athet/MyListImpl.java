package com.athet;

import java.util.Iterator;

public class MyListImpl implements MyList {

    public static class Node {
        public Aria element = new Aria();
        public Node next_elem;
        public Node previous_elem;

        Node() {
            this.next_elem = null;
            this.previous_elem = null;
        }

        Node(Aria obj) {
            this.element = obj;
            this.next_elem = null;
            this.previous_elem = null;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public void add(Aria obj) {
        Node tmp = new Node(obj);
        if (size() == 0)
            head = tmp;
        else
            tail.next_elem = tmp;
        tmp.previous_elem = tail;
        tail = tmp;
    }

    @Override
    public void clear() {
        head.next_elem = tail;
        tail.previous_elem = head;
        head = null;
        tail = null;
    }

    @Override
    public boolean remove (Aria obj) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.element.equals(obj)) {
                if (tmp.previous_elem != null) {
                    tmp.previous_elem.next_elem = tmp.next_elem;
                    if (tmp.next_elem == null)
                        tail = tmp.previous_elem;
                } else {
                    head = head.next_elem;
                    if (head == null)
                        tail = null;
                }
                return true;
            }
            tmp.previous_elem = tmp;
            tmp = tmp.next_elem;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Node tmp = head;
        Aria[] array = new Aria[size()];
        int counter = 0;
        while (tmp != null) {
            array[counter] = tmp.element;
            counter++;
            tmp = tmp.next_elem;
        }
        return array;
    }

    @Override
    public int size() {
        int n = 0;
        Node tmp = head;
        while (tmp !=null) {
            tmp = tmp.next_elem;
            n++;
        }
        return n;
    }

    @Override
    public boolean contains(Aria obj) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.element.equals(obj))
                return true;
            tmp = tmp.next_elem;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        Node tmp = head;
        while (tmp != null) {
            str += " [ " + tmp.element.toString() + " ] ";
            if (tmp.next_elem != null) str += ",\n";
            tmp = tmp.next_elem;
        }
        return "{\n" + str + "\n}";
    }

    @Override
    public Iterator<Aria> iterator() {
        return new IteratorImpl();
    }

    @Override
    public boolean add(Aria obj, int index) {
        Node tmp = head;
        Node o = new Node(obj);

        if (index < 0 || index > size() - 1) {
            return false;
        }

        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next_elem;
        }

        Node next = tmp.next_elem;

        tmp.next_elem = o;

        o.previous_elem = tmp;
        o.next_elem = next;
        next.previous_elem = o;

        return true;
    }

    @Override
    public void remove_first() {
        Node tmp = head;
        Node next = head.next_elem;

        next.previous_elem = null;
        tmp.element = null;
        tmp.next_elem = null;
        head = next;
    }

    private class IteratorImpl implements Iterator<Aria> {
        private Node cur = head;
        private boolean r1 = false;
        private boolean r2 = false;
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Aria next() {
            r1 = true;
            r2 = false;
            Aria a = cur.element;
            cur = cur.next_elem;
            return a;
        }

        @Override
        public void remove() {
            if(!r1 || r2)
                throw new IllegalStateException();
            r1 = false;
            r2 = true;
        }
    }


}
