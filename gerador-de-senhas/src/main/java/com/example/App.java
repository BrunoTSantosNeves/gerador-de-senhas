package com.example;

import com.example.generator.SecurePasswordGenerator;
import com.example.generator.config.PasswordPolicy;

public class App {
    public static void main(String[] args) {
        PasswordPolicy policy = new PasswordPolicy(12, true, true, true, true);
        SecurePasswordGenerator generator = new SecurePasswordGenerator(policy);
        
        String password = generator.generate();
        System.out.println("Senha gerada: " + password);
    }
}
