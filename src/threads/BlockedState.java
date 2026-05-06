package threads;

public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("thread1 got lock");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("thread2 got lock");
            }
        });

        thread1.start();

        Thread.sleep(500);

        thread2.start();

        Thread.sleep(500);

        System.out.println("thread2 state: " + thread2.getState()); // BLOCKED

        thread1.join();
        thread2.join();
    }
}
