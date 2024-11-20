package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V>
{
    class Node
    {
        K key;
        V value;
        Node left, right;

        Node(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /* ===========================  Function of BinarySearchTree.BST ============================= */

    /* ------------------------------------------------------------------------------ */

    /* Search Key in BinarySearchTree.BST */
    public V get(K key)
    {
        return get(root, key).value;
    }

    private Node get(Node node, K key)
    {
        if (node == null) return null;

        int compared = node.key.compareTo(key);

        if (compared > 0) return get(node.left, key);

        if (compared < 0) return get(node.right, key);

        return node;
    }

    /* ------------------------------------------------------------------------------ */

    /* Insert / Update in BinarySearchTree.BST */
    public void insert(K key, V value)
    {
        root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value)
    {
        if (node == null) return new Node(key, value);

        int compared = key.compareTo(node.key);

        if (compared > 0) node.right = insert(node.right, key, value);

        else if (compared < 0) node.left = insert(node.left, key, value);

        else
        {
            node.value = value;
        }

        return node;
    }

    /* ------------------------------------------------------------------------------ */

    /* Get Minimum Key */
    public K getMin()
    {
        return getMin(root).key;
    }

    private Node getMin(Node node)
    {
        if (node == null) return null;

        if (node.left == null) return node;

        return getMin(node.left);
    }

    /* ------------------------------------------------------------------------------ */

    /* Find Common Ancestor */
    public K findCommonAncestor(K p, K q)
    {
        return findCommonAncestor(root, p , q).key;
    }

    private Node findCommonAncestor(Node node, K p, K q)
    {
        if (node == null) return null;

        if (node.key.compareTo(p) >= 0 && node.key.compareTo(q) <= 0 || node.key.compareTo(p) <= 0 && node.key.compareTo(q) >= 0)
        {
            return node;
        }

        if (node.key.compareTo(p) > 0 && node.key.compareTo(q) > 0) return findCommonAncestor(node.left, p, q);

        if (node.key.compareTo(p) < 0 && node.key.compareTo(q) < 0) return findCommonAncestor(node.right, p, q);

        return node;
    }

    /* ------------------------------------------------------------------------------ */

    public void delete(K key)
    {
        root = delete(root, key);
    }

    private Node delete(Node node, K key)
    {

        if (node == null) return null;

        int compared = node.key.compareTo(key);

        if (compared == 0)
        {
            return helper(node);
        }

        Node temp = node;
        while (temp != null)
        {
            assert temp != null;
            if (temp.key.compareTo(key) > 0)
            {
                if (temp.left != null && temp.left.key.compareTo(key) == 0)
                {
                    temp.left = helper(temp.left);
                    break;
                }
                else
                {
                    temp = temp.left;
                }
            }
            else
            {
                if (temp.right != null && temp.right.key.compareTo(key) == 0)
                {
                    temp.right = helper(temp.right);
                    break;
                }
                else
                {
                    temp = temp.right;
                }
            }
        }

        return node;
    }

    private Node helper(Node node)
    {
        if (node.right == null) return node.left;

        if (node.left == null) return node.right;

        Node right = node.right;
        Node rightMost = node.left;

        while (rightMost.right != null)
        {
            rightMost = rightMost.right;
        }

        rightMost.right = right;

        return node.left;
    }

    /* ------------------------------------------------------------------------------ */

    public void deleteMin()
    {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node)
    {
        if (node == null) return null;

        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);

        return node;
    }

    /* ------------------------------------------------------------------------------ */

    /* Display Function */

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
            System.out.println("|------->" + node.key+"->"+node.value);
        }
        else
        {
            System.out.println(node.key+"->"+node.value);
        }
        display(node.left, level + 1);
    }

    /* ------------------------------------------------------------------------------ */

    public void convertToDLL()
    {
        List<Node> list = new ArrayList<>();

        helper(root, list);

        int n = list.size();

        Node head = list.get(0);
        Node tail = list.get(n - 1);

        for (int i = 0; i < n; i++)
        {
            Node curr = list.get(i);
            curr.left = i == 0 ? tail : list.get(i - 1);
            curr.right = i == n - 1 ? head : list.get(i + 1);
        }

        root = list.get(0);
    }

    private void helper(Node node, List<Node> list)
    {
        if (node == null) return;

        helper(node.left, list);

        list.add(node);

        helper(node.right, list);
    }

    /* ------------------------------------------------------------------------------ */

    public void displayList()
    {
        displayList(root);
    }

    private void displayList(Node node)
    {
        Node curr = node.right;
        while (curr != node)
        {
            System.out.println(curr.left.key + "<-" + curr.key + "->" + curr.right.key);
            curr = curr.right;
        }
    }

    /* ------------------------------------------------------------------------------ */

    /* Main Function */

    public static void main(String[] args)
    {
        BST<Integer, Integer> bst = new BST<>();

        bst.insert(5, 1);
        bst.insert(2, 2);
        bst.insert(10, 3);
        bst.insert(12, 4);
        bst.insert(1, 5);
        bst.insert(6, 6);
        bst.insert(9, 7);
        bst.insert(11, 8);
        bst.insert(3, 9);
        bst.insert(4, 10);

        bst.display();

        System.out.println("----------------------------");
        bst.delete(3);

        bst.display();
        System.out.println("----------------------------");
        bst.deleteMin();

        bst.display();
        System.out.println("----------------------------");
        bst.insert(5, 4);

        bst.display();

        System.out.println("----------------------------");
        System.out.println(bst.getMin());
        System.out.println(bst.get(11));

        System.out.println("-----------------------------");
        System.out.println(bst.findCommonAncestor(12, 6));

        System.out.println("-----------------------------");

//        bst.convertToDLL();
//
//        bst.displayList();

        System.out.println("-----------------------------");
    }
}
