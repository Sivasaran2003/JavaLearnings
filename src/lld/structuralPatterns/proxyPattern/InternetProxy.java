package lld.structuralPatterns.proxyPattern;

import java.util.ArrayList;
import java.util.List;

public class InternetProxy implements Internet{

    List<String> bannedSites;
    private Internet realInternet;
    public InternetProxy() {
        realInternet = new RealInternet();
        bannedSites = new ArrayList<>(List.of("banned_site1"));
    }

    @Override
    public void connectTo(String site) {
        if(bannedSites.contains(site)) {
            System.out.println(site + " is banned");
        } else {
            realInternet.connectTo(site);
        }
    }
}
