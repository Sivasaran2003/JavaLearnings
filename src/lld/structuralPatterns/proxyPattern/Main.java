package lld.structuralPatterns.proxyPattern;

public class Main {
    public static void main() {
        InternetProxy proxy = new InternetProxy();

        // if i want to ban few web sites, then i can use proxy to which i can send req
        proxy.connectTo("banned_site1");
        proxy.connectTo("site 1");
    }
}


/**
 * provides a substitute for another obj
 * and controls access to that object, allowing
 * you to perform something before or after the
 * request reaches original obj
 * gfg : https://www.geeksforgeeks.org/system-design/proxy-design-pattern/
 * cache itself is a proxy
 */