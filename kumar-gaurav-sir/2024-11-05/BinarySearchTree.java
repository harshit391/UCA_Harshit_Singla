public class BinarySearchTree
{
	class Node
	{
        Integer key;
        Integer value;
        Node left;
        Node right;

        Node(Integer key, Integer value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree()
    {
        this.root = null;
    }

    public Integer get(Integer key)
    {
        return get(root, key);
    }
    
    private Integer get(Node x, Integer key)
    {
        if (x == null) return null;
        
        if (key == x.key)
        {
            return x.value;
        }

        else if (key < x.key)
        {
            return get(x.left, key);
        }

        else
        {
            return get(x.right, key);
        }
    }

    public void put(Integer key, Integer value)
    {
        root = put(root, key, value);     
    }

    private Node put(Node x, Integer key, Integer value)
    {
        if (x == null) return new Node(key, value);

        if (key == x.key) x.value = value;

        else if (key < x.key) x.left = put(x.left, key, value);

        else x.right = put(x.right, key, value);

        return x;
    }

    public static void main(String[] args)
    {
				BinarySearchTree bst = new BinarySearchTree();
		
				bst.put(5, 3);
				bst.put(3, 5);
		
				bst.put(1, 6);
		
				bst.put(7, 3);
				bst.put(9, 1);
				
				assert(bst.get(7) ==3);
				assert(bst.get(11) == null);
		
				assert(bst.get(1) == 6);  
		
				System.out.println("Test Cases Passed");      
    }
}
