package Bank;

public class Main
{
    public static void main(String[] args)
    {
        MyBank myBank = new MyBank();

        for (int i = 0; i < 10; i++)
        {
            Depositor dep = new Depositor(myBank);
            Withdrawer wd = new Withdrawer(myBank);

            dep.start();
            wd.start();
        }
    }
}
