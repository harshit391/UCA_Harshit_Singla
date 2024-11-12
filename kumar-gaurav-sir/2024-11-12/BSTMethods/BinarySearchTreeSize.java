package BSTMethods;

public class BinarySearchTreeSize<Key extends Comparable<Key>, Value>
{
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

    private Node root;

    BinarySearchTreeSize()
    {
        this.root = null;
    }

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

    private Key giveMax(Key key1, Key key2)
    {
        if (key1 == null) return key2;

        if (key2 == null) return key1;

        if (key1.compareTo(key2) < 0) return key1;

        return key2;
    }

    private Node floor(Key key, Node x)
    {
        if (x == null) return null;

        int c = key.compareTo(x.key);

        if (c == 0) return x;

        if (c < 0) return floor(key, x.left);

        Node right =  floor(key, x.right);

        if (right == null) return x;

        return right;
    }

    public Key floor(Key key)
    {
        Node ans = floor(key, root);
        if (ans == null) return null;

        return ans.key;
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    private int size(Node x)
    {
        if (x == null) return 0;

        return x.count;
    }

    public int size()
    {
        return size(root);
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value, 1);

        if (key.compareTo(x.key) == 0) x.value = value;

        else if (key.compareTo(x.key) < 0) x.left = put(x.left, key, value);

        else x.right = put(x.right, key, value);

        x.count = 1 + size(x.left) + size(x.right);

        return x;
    }

    public static void main(String[] args)
    {
        BinarySearchTreeSize<Integer, Integer> bst = new BinarySearchTreeSize<>();

        bst.put(5, 3);
        bst.put(3, 5);

        bst.put(1, 6);

        bst.put(7, 3);
        bst.put(9, 1);

        assert (bst.get(7) == 3);
        assert (bst.get(11) == null);

        assert (bst.get(1) == 6);

        assert (bst.floor(4) == 3);
        assert (bst.floor(2) == 1);
        assert (bst.floor(6) == 5);
        assert (bst.floor(8) == 7);

        assert (bst.size() == 5);

        System.out.println("Test Cases Passed");
    }
}

