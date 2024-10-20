import java.util.*;

interface B
{
	public int add(int a, int b);
}

interface A
{
	public int add(int a, int b);
}

class Codechef implements A , B
{
	public int add(int a, int b)
	{
		return a * b;
	}

	public static void main(String[] args)
	{
		System.out.println("Hello");
	}
}
