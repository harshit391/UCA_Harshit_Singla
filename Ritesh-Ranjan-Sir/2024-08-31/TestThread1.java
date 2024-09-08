import java.util.ArrayList;
import java.util.List;

public class TestThread1
{
    public static void main(String[] args) throws InterruptedException
    {
        long startTime = System.currentTimeMillis();

        List<Integer> l = new ArrayList<>();

        Thread t1 = new Thread(new ListAdder(l, 1), "First");
        Thread t2 = new Thread(new ListAdder(l, 2), "Second");
        Thread t3 = new Thread(new ListAdder(l, 3), "Third");
        Thread t4 = new Thread(new ListAdder(l, 4), "Fourth");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println(Thread.currentThread().getName() + " is adding number 5");

        l.add(5);

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println(l);
        System.out.println("Total Time Taken :- " + (System.currentTimeMillis() - startTime));
    }

    private static class ListAdder extends Thread
    {
        private List<Integer> l;

        private int i;

        public ListAdder(List<Integer> l, int i)
        {
            this.l = l;
            this.i = i;
        }

        public void run()
        {
            System.out.println(Thread.currentThread().getName() + " is adding number 5");

            this.l.add(i);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

