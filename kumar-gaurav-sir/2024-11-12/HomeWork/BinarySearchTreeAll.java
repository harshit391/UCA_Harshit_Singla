package HomeWork;

public class BinarySearchTreeAll<Key extends Comparable<Key>, Value>
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
    BinarySearchTreeAll()
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

    /* Floor Method */
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

    /* Ceil Method */
    private Node ceil(Key key, Node x)
    {
        if (x == null) return null;

        int c = key.compareTo(x.key);

        if (c == 0) return x;

        if (c > 0) return ceil(key, x.left);

        Node right = ceil(key, x.right);

        if (right == null) return x;

        return right;
    }

    public Node ceil(Key key)
    {
        Node ans = ceil(key, root);
        if (ans == null) return null;
        return ans;
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

    /* Rank of Tree Method */
    private int rank(Key key, Node x)
    {
        if (x == null) return 0;

        int c = key.compareTo(x.key);

        if (c == 0) return x.count;

        if (c < 0) return rank(key, x.left);

        return 1 + size(x.left) + size(x.right);
    }

    public int rank(Key key)
    {
        return rank(key, root);
    }

    public static void main(String[] args)
    {
        BinarySearchTreeAll<Integer, Integer> bst = new BinarySearchTreeAll<>();

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

