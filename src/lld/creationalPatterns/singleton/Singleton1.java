package lld.creationalPatterns.singleton;

public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}

/**
 * eager initialization
 * -pros :
 * Object created when class loads
 * Thread-safe (class loading is thread-safe)
 * - cons :
 * Instance created even if not used
 */