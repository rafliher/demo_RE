
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Test{
    public static void main(String[] args) {
    String someString = "IIkIg0pvgCYUgoj7Zpxm";
        System.out.println(decodeString(Base64.getEncoder().encodeToString(someString.getBytes()), "5Aafxzun57n0NCc/UFXbFg=="));
        System.out.println(decodeString(Base64.getEncoder().encodeToString(someString.getBytes()), "zJXSNgg0RbwQIe1DeMvLVA=="));
    }

    public static String decodeString(String secret, String encryptedString) {
        byte[] decodedKey = Base64.getDecoder().decode(secret);
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(2, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getMimeDecoder().decode(encryptedString.getBytes()));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException("Error occured while decrypting data", e);
        } 
    }
}