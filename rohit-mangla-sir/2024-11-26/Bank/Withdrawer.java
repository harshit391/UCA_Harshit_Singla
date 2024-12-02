package Bank;

public class Withdrawer extends Thread
{
    MyBank bank;

    Withdrawer(MyBank bank)
    {
        this.bank = bank;
    }

    public void run()
    {
        int money = (int) (Math.random() * 1000);

        if (bank.currBalance < money)
        {
            System.out.println("Insufficient Balance");

            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
        else
        {
            bank.currBalance -= money;
            System.out.println("Money Withdrawn :- " + money);
        }
    }
}
