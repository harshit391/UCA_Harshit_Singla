import java.util.concurrent.Semaphore;

public class MTSema
{
    int val;

    Semaphore lock;

    MTSema()
    {
        val = 0;
        lock = new Semaphore(1);
    }

    public static void main(String[] args) throws InterruptedException {
        MTSema mt = new MTSema();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(mt::increment);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(mt.val);
    }

    public void increment()
    {
        if (lock.tryAcquire())
        {
            try
            {
                Thread.sleep(100);
                val++;
            }
            catch (Exception e)
            {
                System.out.println("Error in increment");
            }
            lock.release();
        }
        else
        {
            System.out.println("Couldn't able to Update the Value");
        }
    }

}
