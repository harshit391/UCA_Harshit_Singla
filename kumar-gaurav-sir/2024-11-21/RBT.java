public class RBT<K extends Comparable<K>, V> {

    class Node
    {
        K key;
        V value;
        Node left;
        Node right;
        boolean color;

        Node(K key, V value, boolean color)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private Node root;

    public void put(K key, V value)
    {
        root = put(root, key, value);
    }

    private Node put(Node h, K key, V value)
    {
        if (h == null) return new Node(key, value, true);

        int cmp = key.compareTo(h.key);

        if (cmp == 0) h.value = value;

        else if (cmp < 0) h.left = put(h.left, key, value);

        else h.right = put(h.right, key, value);

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);

        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);

        if (isRed(h.left) && isRed(h.right)) h = flipColors(h);

        return h;
    }

    private boolean isRed(Node h)
    {
        return h != null && h.color;
    }

    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = true;
        return x;
    }

    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;
        h.color = true;
        return x;
    }

    private Node flipColors(Node h)
    {
        h.color = true;
        h.left.color  = false;
        h.right.color = false;

        return h;
    }

    public V get(K key)
    {
        Node ans =  get(root, key);

        return ans == null ? null : ans.value;
    }

    private Node get(Node node, K key)
    {
        if (node == null)
        {
            return null;
        }

        int cmp = node.key.compareTo(key);

        if (cmp == 0) return node;

        else if (cmp < 0) return get(node.left, key);

        return get(node.right, key);
    }

    public void display()
    {
        display(root, 0);
    }

    private void display(Node node, int level)
    {
        if (node == null)
        {
            return;
        }

        display(node.right, level + 1);

        if (level != 0)
        {
            for (int i = 0; i < level - 1; i++)
            {
                System.out.print("|\t\t");
            }
            if (node.color) {
                System.out.println("|------->" + node.key + "->" + node.value);
            }
            else
            {
                System.out.println("|- - - ->" + node.key + "->" + node.value);
            }

        }
        else
        {
            System.out.println(node.key+"->"+node.value);
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args)
    {
        RBT<Integer, Integer> tree = new RBT<>();

        tree.put(12, 1);
        tree.put(11, 1);
        tree.put(10, 1);
        tree.put(9, 1);
        tree.put(8, 1);
        tree.put(7, 1);
        tree.put(6, 1);
        tree.put(5, 1);
        tree.put(4, 1);
        tree.put(3, 1);
        tree.put(2, 1);
        tree.put(1, 1);

        tree.display();
    }

}
