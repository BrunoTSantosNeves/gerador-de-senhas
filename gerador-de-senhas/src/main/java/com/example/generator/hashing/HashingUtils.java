package com.example.generator.hashing;

import java.security.NoSuchAlgorithmException; // NoSuchAlgorithmException server para indicar que o algoritmo de hash não foi encontrado
import java.security.spec.InvalidKeySpecException; // InvalidKeySpecException é lançada quando uma chave inválida é fornecida
import java.security.MessageDigest; // MessageDigest é uma classe abstrata que fornece funcionalidades de hash
import java.security.SecureRandom; // SecureRandom é uma classe que fornece geradores de números aleatórios criptograficamente fortes
import java.util.Base64; // Base64 é uma classe que fornece codificação e decodificação de Base64
import javax.crypto.SecretKeyFactory; // SecretKeyFactory é uma classe que representa uma fábrica de chaves secretas
import javax.crypto.spec.PBEKeySpec; // PBEKeySpec é uma classe que representa uma chave de entrada para a derivação de chaves baseada em senha
import org.mindrot.jbcrypt.BCrypt; // BCrypt é uma biblioteca que fornece funções de hash bcrypt

public class HashingUtils {
    
}
