package lld.creationalPatterns.singleton;

public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * - Not thread-safe
 * Two threads can create two objects at same time.
 */