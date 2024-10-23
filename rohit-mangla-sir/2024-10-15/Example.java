interface B
{
	public int add(int a, int b);
}

interface A
{
	public int add(int a, int b);
}

class Example implements A , B
{
	public int add(int a, int b)
	{
		return a * b;
	}

	public static void main(String[] args)
	{
		A ex = new Example();

		int ans = ex.add(2, 4);

		System.out.println(ans);
	}
}
