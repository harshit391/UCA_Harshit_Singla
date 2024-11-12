import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearchTreeWordCount<Key extends Comparable<Key>, Value>
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

    Node root;

    BinarySearchTreeWordCount()
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

    public void put(Key key, Value value)
    {
        root = put(root, key, value);     
    }

    private Node put(Node x, Key key, Value value)
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
		BinarySearchTreeWordCount<String, Integer> binarySearchTreeWordCount = new BinarySearchTreeWordCount<>();

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

				Integer curr_count = binarySearchTreeWordCount.get(word);

				if (curr_count != null)
				{
					binarySearchTreeWordCount.put(word, curr_count + 1);

					if (curr_count + 1 > count)
					{
						count = curr_count + 1;
						ans = word;
					}
				}
				else
				{
					binarySearchTreeWordCount.put(word, 1);
				}
			}
		}	
	
			System.out.println(count); // 24763
			System.out.println(ans); // government
    }
}
