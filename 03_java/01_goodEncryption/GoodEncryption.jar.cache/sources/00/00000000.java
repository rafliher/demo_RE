package com.goodencryption;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: GoodEncryption.jar:com/goodencryption/Main.class */
public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            if (args[0].equals(hEdOTXlX8LwVLntenz0P(Base64.getEncoder().encodeToString("IIkIg0pvgCYUgoj7Zpxm".getBytes()), "5Aafxzun57n0NCc/UFXbFg=="))) {
                String ebYnlBDTdSvEhKG6oedk = S4oVNbW1lqV3kohZ9KPC(Base64.getEncoder().encodeToString("IIkIg0pvgCYUgoj7Zpxm".getBytes()), args[1]);
                FileWriter crkaBBPjTgGg9uuZGcL7 = new FileWriter("file.enc");
                crkaBBPjTgGg9uuZGcL7.write(new String(ebYnlBDTdSvEhKG6oedk));
                crkaBBPjTgGg9uuZGcL7.close();
            }
            if (args[0].equals(hEdOTXlX8LwVLntenz0P(Base64.getEncoder().encodeToString("IIkIg0pvgCYUgoj7Zpxm".getBytes()), "zJXSNgg0RbwQIe1DeMvLVA=="))) {
                File myObj = new File("file.enc");
                Scanner Pk1Wk07UPuyd6uvwZGiC = new Scanner(myObj);
                String str = null;
                while (true) {
                    String data = str;
                    if (!Pk1Wk07UPuyd6uvwZGiC.hasNextLine()) {
                        String hjU01y5SGDlezpaxZYi9 = hEdOTXlX8LwVLntenz0P(Base64.getEncoder().encodeToString("IIkIg0pvgCYUgoj7Zpxm".getBytes()), data);
                        System.out.println(hjU01y5SGDlezpaxZYi9);
                        Pk1Wk07UPuyd6uvwZGiC.close();
                        return;
                    }
                    str = Pk1Wk07UPuyd6uvwZGiC.nextLine();
                }
            }
        }
    }

    public static String S4oVNbW1lqV3kohZ9KPC(String secret, String data) {
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

    public static String hEdOTXlX8LwVLntenz0P(String secret, String encryptedString) {
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