package com.goodencryption;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
  public static void main(String[] args) throws Exception {
    String secretKey = "IIkIg0pvgCYUgoj7Zpxm";
    if (args.length != 0) {
      if (args[0].equals(decodeString(Base64.getEncoder().encodeToString(secretKey.getBytes()), "5Aafxzun57n0NCc/UFXbFg=="))) {
        String encodedString = encodeString(Base64.getEncoder().encodeToString(secretKey.getBytes()), args[1]);
        FileWriter fileWriter = new FileWriter("file.enc");
        fileWriter.write(new String(encodedString));
        fileWriter.close();
      } 
      if (args[0].equals(decodeString(Base64.getEncoder().encodeToString(secretKey.getBytes()), "zJXSNgg0RbwQIe1DeMvLVA=="))) {
        File myObj = new File("file.enc");
        Scanner scanner = new Scanner(myObj);
        String data = null;
        while (scanner.hasNextLine())
          data = scanner.nextLine(); 
        String decodedString = decodeString(Base64.getEncoder().encodeToString(secretKey.getBytes()), data);
        System.out.println(decodedString);
        scanner.close();
      } 
    } 
  }
  
  public static String encodeString(String secret, String data) {
    byte[] decodedKey = Base64.getDecoder().decode(secret);
    try {
      Cipher cipher = Cipher.getInstance("AES");
      SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
      cipher.init(1, originalKey);
      byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
      return Base64.getEncoder().encodeToString(cipherText);
    } catch (Exception e) {
      throw new RuntimeException("Error occured while encrypting data", e);
    } 
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
