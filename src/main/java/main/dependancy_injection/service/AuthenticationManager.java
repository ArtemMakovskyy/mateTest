package main.dependancy_injection.service;

public interface AuthenticationManager {
    boolean hasPermission(String accountNumber);
}
