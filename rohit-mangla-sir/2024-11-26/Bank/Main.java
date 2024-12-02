package Bank;

public class Main
{
    public static void main(String[] args)
    {
        MyBank myBank = new MyBank();

        for (int i = 0; i < 10; i++)
        {
            new Depositor(myBank).start();
            new Withdrawer(myBank).start();
        }
    }
}
