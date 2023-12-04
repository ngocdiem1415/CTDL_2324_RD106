package lab11;

import java.util.ArrayList;

public class TestBST {

    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        ArrayList<Integer> array = new ArrayList<>();
//        test.add(25);
//        test.add(235);
        array.add(25);
        array.add(15);
        array.add(50);
        array.add(10);
        array.add(22);
        array.add(35);
        array.add(70);
        array.add(4);
        array.add(12);
        array.add(18);
        array.add(24);
        array.add(31);
        array.add(44);
        array.add(66);
        array.add(90);
        array.add(33);
        test.add(array);
//        System.out.println(test.depth(25));
//        System.out.println(test.depth(4));
//        System.out.println(test.height());
//        System.out.println(test.size());
//        System.out.println(test.contains(4));
//        System.out.println(test.findMin());
//        System.out.println(test.findMax());
//        System.out.println(test.remove(4));
//        System.out.println(test.remove(31));
        BNode<Integer> BN = new BNode<>();
//        System.out.println(test.remove(25));
//        System.out.println(BN.removeRoot(test.getRoot(test),25));
//        System.out.println(BN.findLeftMostRight(test.getRoot(test)));
        System.out.println(test.descendants(50).toString());
//        System.out.println(test.ancestors(50).toString());
//        System.out.println(BN.traversalChild(test.getRoot(test)));
//        test.inorder();
//        System.out.println();
//        test.preorder();
//        System.out.println();
//        test.postorder();

    }
}
