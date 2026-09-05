package com.Project.post_comment.util;

import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Component
public class RSAUtility {

  private static final String ALGO = "RSA";

  private static PrivateKey privateKey = null;

  public String performEncryption(String data)
    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
    BadPaddingException {

    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGO);

    keyPairGenerator.initialize(2048); // 2048 means the private, public key is 2048 bits long

    KeyPair keyPair = keyPairGenerator.generateKeyPair();

    PublicKey publicKey = keyPair.getPublic();
    privateKey = keyPair.getPrivate();

    Cipher cipher = Cipher.getInstance(ALGO);

    cipher.init(Cipher.ENCRYPT_MODE, publicKey); //TODO: here public key is used for encryption

    return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));


  }

  public String performDecryption(String encryptedRsa)
    throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException,
    BadPaddingException {

    Cipher cipher = Cipher.getInstance(ALGO);

    cipher.init(Cipher.DECRYPT_MODE, privateKey);//TODO: here private key is used for decryption

    byte[] decode = Base64.getDecoder().decode(encryptedRsa);

    return new String(cipher.doFinal(decode));
  }
}
