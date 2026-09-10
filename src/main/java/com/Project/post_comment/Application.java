package com.Project.post_comment;

import com.Project.post_comment.util.AesUtility;
import com.Project.post_comment.util.RSAUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {
  
  @Autowired
  private AesUtility aesUtility;

  @Autowired
  private RSAUtility rsaUtility;
  @Autowired
  Map<String, Payment> paymentChoice = new HashMap<>(); // TODO: Map injection works as strategy pattern

//  private final Payment payment;
//
//	public Application(@Qualifier("cash") Payment payment) {
//		this.payment = payment;
//	}

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);

  }

  @Override
  public void run(String... args) throws Exception {

    // TODO: Factory design pattern with map injection

	  Payment payment1 = paymentChoice.get("upi"); // spring automatically injects upi -> UpiPayment Class
	  payment1.pay();
//    payment.pay();

    //TODO: Strategy design pattern

    DiscountStrategy discountStrategy = new FestiveDiscount();
    DiscountManager discountManager = new DiscountManager(discountStrategy);

    System.out.println(discountManager.calculate());

    //TODO: Observer pattern
    PaymentService paymentService = new PaymentService();
    paymentService.addObserver(new EmailService());
    paymentService.addObserver(new SmsService());
    paymentService.completePayment();

    //TODO: Factory design pattern
    PaymentFactory paymentFactory = new PaymentFactory();
    Payment payment = paymentFactory.processPayment("cash");
    payment.pay();
    
    //TODO: Performing encryption and decryption(AES) -> same key is used for encryption and decryption, fast, encrypt large amt of data, difficult to share the key
    String encryptedData = aesUtility.performEncryption("Arkadeb123");
    System.out.printf(encryptedData);

    System.out.println();

    String decryptedData = aesUtility.performDecryption(encryptedData);
    System.out.println(decryptedData);

    //TODO: Performing encryption and decryption(RSA)-> public key for encryption, private key for decryption,slow, encrypt small data, public key can be shared


    String encryptedRsa = rsaUtility.performEncryption("Arkadeb123");
    System.out.printf("encrypted using RSA " +encryptedRsa);

    System.out.println();

    String decryptedRsa= rsaUtility.performDecryption(encryptedRsa);
    System.out.println("decrypted using RSA: " +decryptedRsa);

  }
}
