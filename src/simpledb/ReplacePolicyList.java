package simpledb;

import java.util.Collection;
import java.util.LinkedList;

public class ReplacePolicyList<T> extends LinkedList<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 3903049474365686216L;

    int nLimitSize = 0;

    public ReplacePolicyList(int nLimitSize) {
        super();
        this.nLimitSize = nLimitSize;
    }

    @Override
    public void addFirst(T e) {
        if (this.size() < nLimitSize) {
            super.addFirst(e);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public void addLast(T e) {
        if (this.size() < nLimitSize) {
            super.addLast(e);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * do not allow to call following function. Because, we need more specific
     * calling when inserting.
     */
    @Override
    @Deprecated
    public boolean add(T e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        if (this.size() < nLimitSize) {
            super.add(index, element);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public T getLast() {
        T e = super.getLast();
        accessByIndex(this.size() - 1);
        return e;
    }

    /**
     * the following two function is used to modify the order of elements. When
     * accessing the element, and then remove this element, and add it in head
     * 
     * @param index
     */
    public void accessByIndex(int index) {
        T e = get(index);
        remove(index);
        addFirst(e);
    }

    public void access(T e) {
        remove(e);
        addFirst(e);
    }

    public static void main(String[] args) {
        ReplacePolicyList<Integer> list = new ReplacePolicyList<>(10);
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        System.out.println(list);
        list.accessByIndex(5);
        System.out.println(list);
        list.getLast();
        System.out.println(list);
        list.getFirst();
        System.out.println(list);
        list.access(4);
        System.out.println(list);
    }
}
