package Exercise;

public class ThreadExercise {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        ThreadCounter[] threads = new ThreadCounter[10];

        for (int i = 0; i < 10; i++)
        {
            threads[i] = new ThreadCounter(counter);
            threads[i].start();
        }

        for (int i = 0; i < 10; i++)
        {
            threads[i].join();
        }

        // It will Not give 10 Crore because Some Threads Are Interrupted, and It Can't able to Increment Properly
        // This is Because One Thread Incrementing is Overriding another Thread Incrementing
        // So The Counter count do not get updated
        // To Avoid this We implement Mutex Semaphore Locks
        System.out.println(counter.count);


    }
}
