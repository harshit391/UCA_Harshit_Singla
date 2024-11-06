import java.util.function.*;

public class Expression
{
	public static void main(String[] args)
	{
		Predicate<String> predicate = (s) -> {
			
			int n = s.length();

			char[] stack = new char[n];

			int top = -1;

			for (int i = 0; i < n; i++)
			{
                if (top != -1 && s.charAt(i) == ')' && stack[top] == '(') top--;
                
                else if (top != -1 && s.charAt(i) == ']' && stack[top] == '[') top--;
                
                else if (top != -1 && s.charAt(i) == '}' && stack[top] == '{') top--;

                else stack[++top] = s.charAt(i);
			}

			return top == -1;
		};

		System.out.println(predicate.test("(,),],[,{,}"));
		System.out.println(predicate.test("(,),[,],{,(,),}"));
	}
}
