import java.util.*;

public class towerOfHanoi
{
	public static void main(String[] args)
	{
		tower(4, 'A', 'C', 'B');
	}

	public static void tower(int n, char source, char destination, char helper)
	{
		if (n == 0)
			return;

		tower(n - 1, source, helper , destination);
		
		System.out.println("Moving Disk " + n + " From " + source + " To " + destination);

		tower(n - 1, helper, destination, source);
	}
}


