package lab11;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    public void add(E e) {
        if (root == null) {
            this.root = new BNode<>(e);
        }
        this.root = root.add(this.root, e);
    }

    // Add a collection of elements col into BST
    public void add(Collection<E> col) {
        for (E value : col) {
            if (root == null) {
                this.root = new BNode<>(value);
            }
            this.add(value);
        }
    }

    // compute the depth of a node in BST
    public int depth(E node) {
        return root.depth(root, node);
    }

    // compute the height of BST
    public int height() {
        return root.height(root);
    }

    // Compute total nodes in BST
    public int size() {
        return root.size(root);
    }

    // Check whether element e is in BST
    public boolean contains(E e) {
        return root.contains(root, e);
    }

    // Find the minimum element in BST
    public E findMin() {
        BNode<E> temp = root;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getData();
    }

    // Find the maximum element in BST
    public E findMax() {
        BNode<E> temp = root;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getData();
    }

    // Remove element e from BST
    public boolean remove(E e) {
        if (!this.contains(e)) return false;
        root.remove(root, e);
        return true;
    }

    //     get the descendants of a node
//    descendants: con chau
    public List<E> descendants(E data) {
        if (!contains(data)) return null;
        return root.descendants(root, data);
    }

    // get the ancestors of a node
    // ancestors: to tien
    public List<E> ancestors(E data) {
        if (!contains(data)) return null;
        return root.ancestors(root, data);
    }

    public void printTree(BNode<E> root) {
        if (root == null) return;
        System.out.print(root.getData() + " - ");
        printTree(root.getLeft());
        printTree(root.getRight());
    }


    public BNode<E> getRoot(BST rootNode) {
        return rootNode.root;
    }

    // display BST using inorder approach
    // L -N -R
    public void inorder() {
        root.inorder(root);
    }

    // display BST using preorder approach
    // N - L - R
    public void preorder() {
        root.preorder(root);
    }

    // display BST using postorder approach
    public void postorder() {
        root.postOrder(root);
    }

    @Override
    public String toString() {
        return "root=" + root;
    }


}
