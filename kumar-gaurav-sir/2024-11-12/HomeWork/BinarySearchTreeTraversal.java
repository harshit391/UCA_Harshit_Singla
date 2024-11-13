package HomeWork;

public class BinarySearchTreeTraversal<Key extends Comparable<Key>, Value>
{
    /* Main Node Class*/
    class Node
    {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        Node(Key key, Value value, int count)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.count = count;
        }
    }

    /* Root Node */
    private Node root;

    /* Constructor for Data Structure*/
    BinarySearchTreeTraversal()
    {
        this.root = null;
    }

    /* Get from Key Method */
    public Value get(Key key)
    {
        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null) return null;

        if (key.compareTo(x.key) == 0) {
            return x.value;
        } else if (key.compareTo(x.key) < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    /* Put Method */
    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value, 1);

        if (key.compareTo(x.key) == 0) x.value = value;

        else if (key.compareTo(x.key) < 0) x.left = put(x.left, key, value);

        else x.right = put(x.right, key, value);

        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    /* Size of Tree Method*/
    private int size(Node x)
    {
        if (x == null) return 0;

        return x.count;
    }

    public int size()
    {
        return size(root);
    }

    /* Logic for All Traversals */
    private void printNode(Node x, Node parent)
    {
        if (parent == null)
        {
            System.out.println("Root Key :- " + x.key + " Root Value :- " + x.value + " Size :- " + x.count);
        }
        else
        {
            System.out.println("Parent Root :- " + parent.key + " Root Key :- " + x.key + " Root Value :- " + x.value + " Size :- " + x.count);
        }
    }

    private void preorder(Node x, Node parent)
    {
        if (x == null) return;

        printNode(x, parent);

        preorder(x.left, x);
        preorder(x.right, x);
    }

    private void inorder(Node x, Node parent)
    {
        if (x == null) return;

        inorder(x.left, x);

        printNode(x, parent);

        inorder(x.right, x);
    }

    private void postorder(Node x, Node parent)
    {
        if (x == null) return;

        postorder(x.left, x);
        postorder(x.right, x);

        printNode(x, parent);
    }

    /* Traversals */
    public void traverse()
    {
        preorder(root, null);
        System.out.println(" ----------------------- ");
        inorder(root, null);
        System.out.println(" ----------------------- ");
        postorder(root, null);
        System.out.println(" ----------------------- ");
    }

    public static void main(String[] args)
    {
        BinarySearchTreeTraversal<Integer, Integer> bst = new BinarySearchTreeTraversal<>();

        bst.put(5, 24);

        bst.put(3, 8);
        bst.put(1, 9);
        bst.put(4, 17);

        bst.put(7, 7);
        bst.put(6, 9);
        bst.put(9, 10);

        /*      5
        *     /   \
        *    3     7
        *   / \   / \
        * 1    4 6   9
        * */

        bst.traverse();
    }
}

