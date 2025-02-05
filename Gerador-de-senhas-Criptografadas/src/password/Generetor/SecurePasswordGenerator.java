package password.Generetor;

//import config.PasswordPolicy;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

import password.config.PasswordPolicy;


/*
 * Implementação segura do gerador de senhas que gera senhas aleatórias de acordo com a política de senha fornecida.
 * 
 * Essa classe utiliza a politica de senha definida em{@link PasswordPolicy} para construir o conjunto de senhas.
 * de caracteres disponiveis e gera a senha usando {@link SecureRandom} para garantir a aleatoriedade.
 */



public class SecurePasswordGenerator implements PasswordGenerator {

    private final PasswordPolicy policy;
    private final SecureRandom secureRandom;
    private final String availableCharacters;
    
    /**
     * Construtor que recebe uma {@link PasswordPolicy} para configurar os parâmetros da senha.
     * @param policy a política de senha a ser usada para gerar senhas.
     */

     public SecurePasswordGenerator(PasswordPolicy policy)
     {
        this.policy = policy;
        this.secureRandom = new SecureRandom();
        this.availableCharacters = buildAvailableCharacters();
     }
}
