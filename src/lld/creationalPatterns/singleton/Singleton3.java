package lld.creationalPatterns.singleton;

public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

/**
 * - Thread-safe
 * - Slower (method-level locking every call)
 *
 * Real world use cases of singleton :
 * - logger system (log4j)
 * - db connections (if multiple - costly and memory consuming)
 * - configuration manager - reading app configs once, sharing across services
 */