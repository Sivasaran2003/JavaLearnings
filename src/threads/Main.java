package threads;


class Printer {
    public void print(String thread) {
        for(int i = 1; i < 6; i++) {
            System.out.println(thread + " printing " + i);
        }
    }
}

class Thread1 extends Thread {
    Printer printer;
    public Thread1(Printer printer) {
        this.printer = printer;
    }
    public void run() {
        System.out.println("thread - 1 trying to access printer lock");

        synchronized (printer) {
            System.out.println("thread - 1 acquired printer lock");
            printer.print("thread - 1");
        }

        System.out.println("thread - 1 released printer lock");
    }

}

class Thread2 implements Runnable {
    Printer printer;

    public Thread2(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        System.out.println("thread - 2 trying to access printer lock");

        synchronized (printer) {
            System.out.println("thread - 2 acquired printer lock");
            printer.print("thread - 2");
        }

        System.out.println("thread - 2 released printer lock");
    }
}


public class Main {
    public static void main() throws InterruptedException {
        Printer printer = new Printer();
        Thread thread1 = new Thread1(printer);
        Thread thread2 = new Thread(new Thread2(printer));

        thread1.start();
//        thread2.start();

//        System.out.println(thread1.getName());
//        System.out.println(thread1.getState());
//
//        thread1.start();
//        System.out.println(thread1.getState());
//        System.out.println(thread1.getState());
//        System.out.println(thread1.getState());
        thread1.join();
        thread2.start();


    }
}
