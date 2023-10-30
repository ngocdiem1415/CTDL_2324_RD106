package lab6;

public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public E first() {
        return this.head.getData();
    }

    public E last() {
        return this.tail.getData();
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    // Adds a new element to the end of the list.
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Removes and returns the first element of the list.
    public E removeFirst() throws Exception {
        E nodeRemove ;
        if (isEmpty()) {
            throw new Exception("is Empty!");
        } else if (head.getNext() == null) {
            nodeRemove = head.getData();
            head.setData(null);
            tail.setData(null);
        } else {
            nodeRemove = head.getData();
            head = head.getNext();
        }
        size--;
        return nodeRemove;
    }

    // Removes and returns the last element of the list.
    public E removeLast() throws Exception {
        E nodeRemove;
        if (isEmpty()) {
            throw new Exception("is Empty!");
        } else if ( head.getNext() == null) {
            nodeRemove = tail.getData();
            head.setData(null);
            tail.setData(null);
        }else{
            Node<E> headNode = head;
            nodeRemove = tail.getData();
            while (headNode.getNext() !=  tail){
                headNode = headNode.getNext();
            }
            headNode.setNext(null);
            tail = headNode;
        }
        size--;
        return nodeRemove;
    }

    @Override
    public String toString() {
        return "head=" + head;
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<>();
//        System.out.println(test.isEmpty());
        test.addFirst(8);
        test.addFirst(7);
        test.addFirst(10);
        test.addLast(1);
        test.addLast(3);
//        System.out.println(test.removeFirst());
        System.out.println(test.removeLast());
        System.out.println(test.removeLast());
        System.out.println(test.removeLast());
        System.out.println(test.toString());
//        System.out.println(test.size());
//        System.out.println(test.tail.toString());
    }

}
