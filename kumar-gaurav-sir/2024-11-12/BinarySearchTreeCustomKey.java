class A implements Comparable<A>
{
    int x;

    A(int x)
    {
        this.x = x;
    }

    @Override
    public int compareTo(A y)
    {
        return Integer.compare(this.x, y.x);
    }
}

public class BinarySearchTreeCustomKey<Key extends Comparable<Key>, Value>
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

    BinarySearchTreeCustomKey()
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
        BinarySearchTreeCustomKey<A, Integer> bst = new BinarySearchTreeCustomKey<>();

        bst.put(new A(5), 3);
        bst.put(new A(3), 5);

        bst.put(new A(1), 6);

        bst.put(new A(7), 3);
        bst.put(new A(9), 1);

        assert (bst.get(new A(7)) == 3);
        assert (bst.get(new A(11)) == null);

        assert (bst.get(new A(1)) == 6);

        System.out.println("Test Cases Passed");
    }
}

