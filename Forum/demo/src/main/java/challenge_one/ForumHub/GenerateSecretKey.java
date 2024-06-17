package challenge_one.ForumHub;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateSecretKey {
    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[32]; // 32 bytes para uma chave secreta segura
        secureRandom.nextBytes(bytes);
        String secretKey = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Chave secreta gerada: " + secretKey);
    }
}
