import java.util.Stack;

public class StackSortable 
{   
   public static boolean stackSort(int[] arr) 
   {
      Stack<Integer> st = new Stack<>();
      int n = arr.length, idx = 0;

      for(int i = 0; i < n; i++) 
      {
         while(!st.isEmpty() && st.peek() == idx + 1) 
	 {
            st.pop();
            idx++;
         }

         if (!st.isEmpty() && arr[i] >= st.peek()) 
	 {
            return false;
         }

         st.push(arr[i]);
      }

      while(!st.isEmpty() && st.peek() == idx + 1) 
      {
         st.pop();
         idx++;
      }

      return st.isEmpty();
   }

   public static void main(String[] var0) 
   {
      assert stackSort(new int[]{3, 2, 1});

      assert stackSort(new int[]{4, 1, 3, 2});

      assert stackSort(new int[]{4, 1, 2, 3});

      assert !stackSort(new int[]{2, 3, 1});

      System.out.println("All Test Cases Passed");
   }
}

