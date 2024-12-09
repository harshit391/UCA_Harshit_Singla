import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MTLock
{
    int val;

    Lock lock;

    MTLock()
    {
        val = 0;
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        MTLock mt = new MTLock();

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
        if (lock.tryLock())
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
            lock.unlock();
        }
        else
        {
            System.out.println("Couldn't able to Update the Value");
        }
    }
}
