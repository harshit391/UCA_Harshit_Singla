import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

// In Java, The List Interface will Looks like this

/*
interface List<K>
{
	public int add(K a);
	public int remove(K idx);
	public boolean isEmpty();
	public int size();
}
*/

// Then ArrayList and Linked List class Implements that Interace like

/*

class ArrayList implements List<K>
{
	public int add(K a)
	{
		// Code
	}
	// Implementation Goes There
}

Similarly for Linked List

*/


public class Intf
{
	public static void main(String[] args)
	{
		List<Integer> arr = new ArrayList<>();

		List<Integer> ll = new LinkedList<>();

		arr.add(1);
		arr.add(2);
		arr.add(3);

		ll.add(1);
		ll.add(2);
		ll.add(3);

		System.out.println("Normal Array List :- " + arr);
		System.out.println("Linked List :- " + ll);	
	}	
}
