package Exercise;

public class Counter
{
    int count;

    Counter()
    {
        count = 0;
    }


    // Basically This Method Got Override by Multiple Thread
    // So Just to Implement Mutex Lock in it, we can write
    public synchronized void increment()
    {
        count++;
    }
}