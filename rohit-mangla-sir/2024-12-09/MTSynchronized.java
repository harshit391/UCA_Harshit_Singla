import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MTSynchronized
{
    int val;

    Lock lock;

    MTSynchronized()
    {
        val = 0;
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        MTSynchronized mt = new MTSynchronized();

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

    public synchronized void increment()
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
    }
}
