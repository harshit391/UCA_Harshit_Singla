import java.util.concurrent.atomic.AtomicInteger;

public class MTAtomicInteger
{
    int val;

    MTAtomicInteger()
    {
        val = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        MTAtomicInteger mt = new MTAtomicInteger();

        Thread[] threads = new Thread[100];

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < threads.length; i++)
        {

            threads[i] = new Thread(atomicInteger::getAndIncrement);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(atomicInteger.get());
    }
}
