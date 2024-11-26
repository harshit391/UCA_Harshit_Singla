package Basic;

public class Thread2 {

    // When we have to send variables through Lambda Function to update We have to declare them globally
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        // The Scope of this Variable is only Limited on Main Function Thread now to t Thread we are creating
        // That's Why We have to declare its Variable in count
//        static int count = 0;

        Thread t = new Thread(() ->
        {
            for (int i = 0; i < 1000; i++)
            {
                count++;
            }
        });

        t.start();

        // Gives 0 because The Thread we started Got Executed in Parallel and Our Count Don't Get Updated
        System.out.println("Count Before Joining Thread with Main :- " + count);

        // Now We Joined our Created Thread with Main
        t.join();

        // So We Get Value of Updated Count i.e. 1000
        System.out.println("Count After Joining Thread with Main :- " + count);
    }
}
