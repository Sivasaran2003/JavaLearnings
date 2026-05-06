package lld.structuralPatterns.proxyPattern;

public class RealInternet implements Internet{
    @Override
    public void connectTo(String site) {
        System.out.println("Connected to " + site);
    }
}
