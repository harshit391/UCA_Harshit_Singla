import java.util.Scanner;

public class EvenDigits {

    private static int even(int n)
    {
        int res = 0;

        int rem = n % 10;

        if (n == 0) return 0;

        if (rem % 2 == 0)
        {
            res = rem + 10 * even(n / 10);
        }
        else
        {
            res = even(n / 10);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int res = even(n);

        System.out.println(res);
    }
}
