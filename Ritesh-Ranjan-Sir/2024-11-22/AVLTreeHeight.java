public class AVLTreeHeight<K extends Comparable<K>, V>
{
    /* Class Node */
    private class Node
    {
        private final K k;
        private V v;

        private Node left, right;

        private int h;

        public Node(K k, V v)
        {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.h = 1;
        }
    }

    /* Main Root of The Tree */
    private Node root;

    /* ============== METHODS ============== */

    /* Get Height (Private Method) */
    public int height()
    {
        return height(root);
    }

    private int height(Node node)
    {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private int getHeight(Node node)
    {
        return node == null ? 0 : node.h;
    }

    /* Rotation Functions */
    private Node leftRotate(Node node)
    {
        Node temp = node.right;
        node.right = temp.left;
        node.h = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        temp.left = node;
        return temp;
    }

    private Node rightRotate(Node node)
    {
        Node temp = node.left;
        node.left = temp.right;
        node.h = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        temp.right = node;
        return temp;
    }

    /* 1. Insert Node */
    public void insert(K k, V v)
    {
        root = insert(root, k, v);
    }

    private Node insert(Node node, K k, V v)
    {
        if (node == null)
            return new Node(k, v);

        int cmp = k.compareTo(node.k);

        if (cmp > 0)
            node.right = insert(node.right, k, v);

        else if (cmp < 0)
            node.left = insert(node.left, k, v);

        else
            node.v = v;

        int diff = getHeight(node.left) - getHeight(node.right);

        if (diff > 1)
        {
            if (getHeight(node.left.left) - getHeight(node.left.right) == -1)
            {
                node.left = leftRotate(node.left);
            }
            node = rightRotate(node);
        }
        else if (diff < -1)
        {
            if (getHeight(node.right.left) - getHeight(node.right.right) == 1)
            {
                node.right = rightRotate(node.right);
            }
            node = leftRotate(node);
        }
        node.h = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        return node;
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
            System.out.println("|------->" + node.k+"->"+node.v);
        }
        else
        {
            System.out.println(node.k+"->"+node.v);
        }
        display(node.left, level + 1);
    }
}
