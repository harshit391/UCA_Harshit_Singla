public class BinarySearchTreeGeneric<Key extends Comparable<Key>, Value>
{
    class Node
    {
        Key key;
        Value value;
        Node left;
        Node right;

        Node(Key key, Value value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    BinarySearchTreeGeneric()
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

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value);

        if (key.compareTo(x.key) == 0) x.value = value;

        else if (key.compareTo(x.key) < 0) x.left = put(x.left, key, value);

        else x.right = put(x.right, key, value);

        return x;
    }

    public static void main(String[] args)
    {
        BinarySearchTreeGeneric<Integer, Integer> bst = new BinarySearchTreeGeneric<>();

        bst.put(5, 3);
        bst.put(3, 5);

        bst.put(1, 6);

        bst.put(7, 3);
        bst.put(9, 1);

        assert (bst.get(7) == 3);
        assert (bst.get(11) == null);

        assert (bst.get(1) == 6);

        System.out.println("Test Cases Passed");
    }
}

