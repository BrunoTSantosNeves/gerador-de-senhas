package com.example;

import com.example.generator.SecurePasswordGenerator;
import com.example.generator.config.PasswordPolicy;
import com.example.generator.hashing.HashingUtils;
import com.example.generator.hashing.HashAlgorithm;

public class App {
    public static void main(String[] args) {
        PasswordPolicy policy = new PasswordPolicy(12, true, true, true, true);
        SecurePasswordGenerator generator = new SecurePasswordGenerator(policy);
        
        String password = generator.generate();
        System.out.println("Senha gerada: " + password);

        String senha = "MinhaSenhaSegura123";

        // Testando PBKDF2
        String pbkdf2Hash = HashingUtils.hashPassword(senha, HashAlgorithm.PBKDF2);
        System.out.println("PBKDF2 Hash: " + pbkdf2Hash);
        System.out.println("Verificação PBKDF2: " + HashingUtils.verifyPassword(senha, pbkdf2Hash, HashAlgorithm.PBKDF2));

        // Testando Bcrypt
        String bcryptHash = HashingUtils.hashPassword(senha, HashAlgorithm.BCRYPT);
        System.out.println("Bcrypt Hash: " + bcryptHash);
        System.out.println("Verificação Bcrypt: " + HashingUtils.verifyPassword(senha, bcryptHash, HashAlgorithm.BCRYPT));

        // Testando SHA-256
        String sha256Hash = HashingUtils.hashPassword(senha, HashAlgorithm.SHA256);
        System.out.println("SHA-256 Hash: " + sha256Hash);
        System.out.println("Verificação SHA-256: " + HashingUtils.verifyPassword(senha, sha256Hash, HashAlgorithm.SHA256));
    }
}


