package lab6;

import java.util.Arrays;

public class MyArrayList<E> {
    public static final int DEFAULT_CAPACITY = 10;
    private E[] element;
    private int size;

    public MyArrayList() {
        this.element = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        this.element = (E[]) new Object[capacity];
    }

    public void growSize() {
        if (size + 1 >= element.length * 0.75f) {
            E[] result = Arrays.copyOf(element, size * 2);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(" out of bound!");
        } else {
            return element[i];
        }
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(" out of bound!");
        } else {
            return element[i] = e;
        }
    }

    public boolean add(E e) {
        growSize();
        element[size()] = e;
        size++;
        return true;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("out of bound");
        } else {
            growSize();
//            E[] result = new E[];
//            System.arraycopy(result, i , e, i +1, size() -i);
//            result[i] = e;
            E temp = element[i];
            element[i] = e;
            int i1 = i;
            for (int j = i + 2; j < size() + 1; j++) {
                element[j] = element[++i1];
            }
            element[i + 1] = temp;
            size++;
        }
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int j = 0; j < size(); j++) {

            }
        }
        return element[i];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            result = result + this.element[i] + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(1);
        test.add(6);
        test.add(2);
        test.add(1, 7);
        test.add(2, 7);
        test.add(4, 7);
        System.out.println(test.toString());
    }
}
