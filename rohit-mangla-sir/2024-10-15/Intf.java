import java.util.*;

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
