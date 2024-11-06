import java.util.function.*;

public class Pallindrome
{
	public static void main(String[] args)
	{
		Predicate<String> predicate = (s) -> {
			
			int n = s.length();

			for (int i = 0; i < n / 2; i++)
			{
				if (s.charAt(i) != s.charAt(n - i - 1))
				{	
					return false;
				}
			}

			return true;
		};

		System.out.println(predicate.test("acca"));
		System.out.println(predicate.test("preeteerp"));
		System.out.println(predicate.test("singla"));
	}
}
