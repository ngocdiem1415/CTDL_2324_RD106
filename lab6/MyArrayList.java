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

    public boolean contain(E o) {
        for (int i = 0; i < element.length; i++)
            if (element[i] == o) {
                return true;
            }
        return false;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("out of bound");
        } else {
            growSize();
            E temp = element[i];
            for (int j = size() + 1; j > i; j--) {
                element[j] = element[j - 1];
            }
            element[i] = e;
            size++;
        }
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        E temp = element[i];
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (contain(temp)) {
                for (int j = i; j < size() - 1; j++) {
                    element[j] = element[j + 1];
                }
                size--;
            }
        }
        return temp;
    }

    public void clear() {
        element = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public E[] toArray() {
        return Arrays.copyOf(element, size());
    }

    public MyArrayList<E> clone() {
        MyArrayList<E> result = new MyArrayList<>();
        result.element = element.clone();
        return result;
    }

    public int lastIndexOf(Object o) {
        int index = -1;
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < element.length; i++) {
                if (element[i] == o) {
                    index = i;
                }
            }
        }
        return index;
    }

    public int indexOf(E o) {
        int index = -1;
        if (this.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < element.length; i++) {
                if (element[i] == o) {
                    index =i;
                    break;
                }
            }
        }
        return index;
    }

    public boolean remove(E e) {
        if ( !contain(e)){
            return false;
        }else {
            int index = indexOf(e);
            remove(index);
            size--;
            return true;
        }
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
        test.add(2, 9);
        test.add(2, 7);
//        System.out.println(test.indexOf(7));
        System.out.println(test.remove(7));
    }
}
