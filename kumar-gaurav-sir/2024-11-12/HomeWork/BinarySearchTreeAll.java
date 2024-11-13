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

        if (c > 0) return ceil(key, x.right);

        Node left = ceil(key, x.left);

        if (left == null) return x;

        return left;
    }

    public Key ceil(Key key)
    {
        Node ans = ceil(key, root);
        if (ans == null) return null;
        return ans.key;
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

        if (c > 0) return  1 + size(x.left) + rank(key, x.right);

        else return rank(key, x.left);
    }

    public int rank(Key key)
    {
        return rank(key, root);
    }

    /* Delete a Node in BST */
    private Node deleteNode(Node x, Key key)
    {
        if (x == null) return null;

        x.count -= 1;

        int c = key.compareTo(x.key);

        if (c < 0)
        {
            x.left = deleteNode(x.left, key);
        }
        else if (c > 0)
        {
            x.right = deleteNode(x.right, key);
        }
        else
        {
            if (x.left == null) return x.right;

            else if (x.right == null) return x.left;

            else
            {
                Node curr = x.right;

                while (curr.left != null)
                {
                    curr = curr.left;
                }

                x.key = curr.key;
                x.value = curr.value;

                x.right = deleteNode(x.right, x.key);
            }
        }

        return x;
    }

    public void deleteNode(Key key)
    {
        root = deleteNode(root, key);
    }

    public static void main(String[] args)
    {
        BinarySearchTreeAll<Integer, Integer> bst = new BinarySearchTreeAll<>();

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

        /* Test Cases Get */
        assert (bst.get(5) == 24);
        assert (bst.get(7) == 7);
        assert (bst.get(12) == null);
        assert (bst.get(3) == 8);
        assert (bst.get(4) == 17);
        assert (bst.get(1) == 9);
        assert (bst.get(6) == 9);

        /* Test Cases Floor */
        assert (bst.floor(4) == 4);
        assert (bst.floor(2) == 1);
        assert (bst.floor(6) == 6);
        assert (bst.floor(8) == 7);

        /* Test Cases Ceil */
        assert (bst.ceil(2) == 3);
        assert (bst.ceil(8) == 9);
        assert (bst.ceil(6) == 6);
        assert (bst.ceil(4) == 4);

        /* Size of Tree Test Case */
        assert (bst.size() == 7);

        /* Rank of Tree Test Case */
        assert (bst.rank(5) == 3);
        assert (bst.rank(3) == 1);
        assert (bst.rank(7) == 5);
        assert (bst.rank(4) == 2);

        /* Delete a Node in BST */
        bst.deleteNode(3);

        assert (bst.size() == 6);
        assert (bst.rank(5) == 2);
        assert (bst.floor(3) == 1);
        assert (bst.ceil(3) == 4);
        assert (bst.get(3) == null);

        System.out.println("Damn, All Test Cases Passed !!");
    }
}

