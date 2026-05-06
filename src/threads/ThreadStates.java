package threads;

class StateDemoThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("child inside run(): " + Thread.currentThread().getState());

            Thread.sleep(2000);

            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("child interrupted");
        }
    }
}

public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        StateDemoThread child = new StateDemoThread();

        System.out.println("1. After creating child: " + child.getState()); // NEW

        child.start();
        System.out.println("2. After child.start(): " + child.getState()); // RUNNABLE or TIMED_WAITING

        Thread.sleep(200);
        System.out.println("3. While child is sleeping: " + child.getState()); // TIMED_WAITING
        Thread.sleep(1800);
        System.out.println("4. After child calls wait(): " + child.getState()); // WAITING

        synchronized (child) {
            child.notify();
        }

        child.join();
        System.out.println("5. After child finished: " + child.getState()); // TERMINATED

        System.out.println("main thread state: " + Thread.currentThread().getState());
    }
}
