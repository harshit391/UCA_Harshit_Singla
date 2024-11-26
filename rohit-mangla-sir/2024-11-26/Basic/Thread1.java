package Basic;

public class Thread1 {

    public static void main(String[] args) {

//        Thread t = new Thread(new Basic.myRunnable());

        Thread t = new Thread(() -> System.out.println("Hello World"));
        t.start();


    }
}

class myRunnable implements Runnable {
    public void run() {
        System.out.println("Hello World");
    }
}
