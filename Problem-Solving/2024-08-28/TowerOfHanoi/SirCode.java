public class SirCode
{
	private static void move(String source, String dest)
	{
		System.out.println("Moving a Disc from " + source + " To " + dest);
	}

	private static void towerOfHanoi(int n, String source, String dest, String help)
	{
		if (n == 1)
		{
			move(source, dest);
			return;
		}

		towerOfHanoi(n - 1, source, help, dest);
		move(source, dest);
		towerOfHanoi(n - 1, help, dest, source);
	}

	public static void main(String[] args)
	{
		String source = "Tower A", helper = "Tower B", destination = "Tower C";

		towerOfHanoi(3, source, destination, helper);
	}	
}
