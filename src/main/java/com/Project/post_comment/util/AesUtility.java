package com.Project.post_comment.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class AesUtility {

  private static final String ALGO = "AES";
  private static final String SECRET_KEY = "nflqlflhou27947134yohejeno384now";


  public String performEncryption(String data) throws Exception {
    
//    //TODO: Generate AES key:
//    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//    keyGenerator.init(128);
//    SecretKey secretKey = keyGenerator.generateKey();

    //TODO: this converts key into Secret key object
    SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGO);
    try {
      //TODO: Cipher is an encryption engine provided by java used for encryption and decryption
      Cipher cipher = Cipher.getInstance(ALGO);

      //TODO: Initialize Cipher
      cipher.init(Cipher.ENCRYPT_MODE, keySpec);

      //TODO: converts plain text into encrypted binary data
      byte[] bytes = cipher.doFinal(data.getBytes());

      return Base64.getEncoder().encodeToString(bytes); // encrypted bites cant be stored in db easily so encoding using Base64 just to convert this into string

    } catch (Exception e) {
      throw new Exception("Unable to encrypt the data", e);
    }

  }

  public String performDecryption(String encryptedDate) throws Exception {


    //TODO: this converts key into Secret key object
    SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGO);
    try {
      //TODO: Cipher is an encryption engine provided by java used for encryption and decryption
      Cipher cipher = Cipher.getInstance(ALGO);

      //TODO: Initialize Cipher
      cipher.init(Cipher.DECRYPT_MODE, keySpec);

      //TODO: converting encrypted text into bytes
      byte[] decode = Base64.getDecoder().decode(encryptedDate);

      return new String(cipher.doFinal(decode));

    } catch (Exception e) {
      throw new Exception("Unable to decrypt the data", e);
    }

  }
}
