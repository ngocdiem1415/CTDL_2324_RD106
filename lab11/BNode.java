package lab11;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode() {
    }

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public BNode<E> add(BNode<E> root, E e) {
        BNode<E> node = new BNode<>(e, null, null);
        if (root == null) {
            root = node;
        } else {
            int v = root.getData().compareTo(e);
            if (v > 0) {
                if (root.getLeft() == null) {
                    root.setLeft(node);
                } else {
                    root.setLeft(add(root.getLeft(), e));
                }
            } else if (v < 0) {
                if (root.getRight() == null) {
                    root.setRight(node);
                } else {
                    root.setRight(add(root.getRight(), e));
                }
            }
        }
//        System.out.println(root);
        return root;
    }


    public int height(BNode root) {
        if (root == null)
            return 0;
        else {
            int lHeight = height(root.getLeft());
            int rHeight = height(root.getRight());

            if (lHeight > rHeight)
                return (lHeight + 1);
            else return (rHeight + 1);
        }
    }

    public int size(BNode rootNode) {
        if (rootNode == null) {
            return 0;
        } else {
            return (size(rootNode.getLeft()) + 1 + size(rootNode.getRight()));
        }
    }

    public boolean contains(BNode<E> rootNode, E e) {
        if (rootNode == null) {
            return false;
        } else {
            int v = rootNode.getData().compareTo(e);
            if (v > 0) {
                return contains(rootNode.getLeft(), e);
            } else if (v < 0) {
                return contains(rootNode.getRight(), e);
            }
            return true;
        }
    }

    public BNode<E> remove(BNode<E> rootNode, E e) {
        if (rootNode == null) {
            return null;
        } else {
            int v = rootNode.getData().compareTo(e);
            if (v > 0) {
                rootNode.setLeft(remove(rootNode.getLeft(), e));
            } else if (v < 0) {
                rootNode.setRight(remove(rootNode.getRight(), e));
            } else {
                // tim duoc phan tu can xoa
                // xoa node la
                if (rootNode.getLeft() == null && rootNode.getRight() == null) {
                    BNode<E> temp = null;
                    rootNode = temp;
                } else if (rootNode.getRight() != null && rootNode.getLeft() == null) {
                    //xoa node co 1 la phai
                    BNode<E> temp = rootNode.getRight();
                    rootNode = temp;
                } else if (rootNode.getRight() == null && rootNode.getLeft() != null) {
                    BNode<E> temp = rootNode.getLeft();
                    rootNode = temp;
                } else {
                    //xoa root
                    // tim phai cung ben trai hoac trai cung ben phai
                    remove(rootNode, e);
                }
            }
        }
        return rootNode;
    }

    public BNode<E> removeRoot(BNode<E> rootNode, E e) {
        BNode<E> temp = new BNode<>(this.findLeftMostRight(rootNode).getData());
        BNode<E> test = remove(rootNode.getRight(), temp.getData());
        temp.setLeft(rootNode.getLeft());
        temp.setRight(test);
        rootNode = temp;
        return rootNode;
    }

    //tim trai cung ben phai
    public BNode<E> findLeftMostRight(BNode<E> root) {
        BNode<E> temp;
        if (root == null) {
            return null;
        } else {
            temp = root.getRight();
            while (temp.getLeft() != null) {
                temp = temp.getLeft();
            }
        }
        return temp;
    }

    private BNode<E> findPreviousLeft(BNode<E> root, BNode<E> leftMostNode) {
        BNode<E> temp;
        if (root == null) {
            return null;
        } else {
            temp = root.getRight();
            while (temp.getLeft().getData().compareTo(leftMostNode.getData()) != 0) {
                temp = temp.getLeft();
            }
        }
        return temp;
    }


    public int depth(BNode<E> root, E node) {
        if (root == null || !contains(root, node)) return -1;
        int v = root.getData().compareTo(node);
        if (v > 0) {
            return 1 + depth(root.getLeft(), node);
        } else if (v < 0) {
            return 1 + depth(root.getRight(), node);
        }
        return 0;
    }

    public List<E> descendants(BNode<E> root, E data) {
        List<E> result = new ArrayList<>();
        while (root != null) {
            int v = root.getData().compareTo(data);
            if (v == 0) {
                break;
            } else if (v < 0) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        result.addAll(traversalChild(root));
        result.remove(0);
        return result;
    }

    public List<E> ancestors(BNode<E> root, E data) {
        List<E> result = new ArrayList<>();
        while (root != null) {
            int v = root.getData().compareTo(data);
            if (v > 0) {
                result.add(root.getData());
                root = root.getLeft();
            } else if (v < 0) {
                result.add(root.getData());
                root = root.getRight();
            } else {
                break;
            }
        }
        return result;
    }


    public List<E> traversalChild(BNode<E> root) {
        List<E> result = new ArrayList<>();
        if (root != null) {
            result.add(root.getData());
            List<E> leftList = traversalChild(root.left);
            List<E> rightList = traversalChild(root.right);
            result.addAll(leftList);
            result.addAll(rightList);
        }
        return result;
    }

    public void preorder(BNode<E> root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.getData() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public void inorder(BNode<E> root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " ");
            inorder(root.getRight());
        }
    }

    public void postOrder(BNode<E> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public E getData() {
        return data;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public BNode<E> getRight() {
        return right;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public void setRight(BNode<E> right) {
        this.right = right;
    }
}
