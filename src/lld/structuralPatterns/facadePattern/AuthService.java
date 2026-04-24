package lld.structuralPatterns.facadePattern;

class AuthService {
    public void authenticate(String user) {
        System.out.println("User authenticated: " + user);
    }
}