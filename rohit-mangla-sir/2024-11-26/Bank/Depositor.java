package Bank;

public class Depositor extends Thread
{
    MyBank bank;

    public Depositor(MyBank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        synchronized (bank)
        {
            int dep = (int) (Math.random() * 1000);

            bank.currBalance += dep;
            System.out.println("Deposited :- " + dep);
        }
    }
}
