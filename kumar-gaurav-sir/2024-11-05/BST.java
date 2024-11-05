import java.util.*;
import java.io.*;

public class BST
{
	class Node
	{
        String key;
        Integer value;
        Node left;
        Node right;

        Node(String key, Integer value)
        {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BST()
    {
        this.root = null;
    }

    public Integer get(String key)
    {
        return get(root, key);
    }
    
    private Integer get(Node x, String key)
    {
        if (x == null) return null;
        
        if (key.compareTo(x.key) == 0)
        {
            return x.value;
        }

        else if (key.compareTo(x.key) < 0)
        {
            return get(x.left, key);
        }

        else
        {
            return get(x.right, key);
        }
    }

    public void put(String key, Integer value)
    {
        root = put(root, key, value);     
    }

    private Node put(Node x, String key, Integer value)
    {
        if (x == null) return new Node(key, value);

        if (key.compareTo(x.key) == 0) 
		{
			x.value = value;
		}

        else if (key.compareTo(x.key) < 0) x.left = put(x.left, key, value);

        else x.right = put(x.right, key, value);

        return x;
    }

    public static void main(String[] args) throws IOException
    {
		BST bst = new BST();

		int count = 0;
		String ans = "";		

		FileReader fileReader = new FileReader("input.txt");
		
		BufferedReader br = new BufferedReader(fileReader);

		while (br.ready())
		{
			String line = br.readLine();

			String[] words = line.split(" ");

			for (String word : words)
			{
				if (word.length() < 10) continue;

				Integer curr_count = bst.get(word);

				if (curr_count != null)
				{
					bst.put(word, curr_count + 1);

					if (curr_count + 1 > count)
					{
						count = curr_count + 1;
						ans = word;
					}
				}
				else
				{
					bst.put(word, 1);
				}
			}
		}	
	
			System.out.println(count); // 24763
			System.out.println(ans); // government
    }
}
