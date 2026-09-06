//package com.Project.post_comment.Service;
//
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//
//    private JavaMailSender javaMailSender;
//
//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public String sendOtp(){
//
//    return String.format("%04d", new java.util.Random().nextInt(10000));
//    }
//    public void sendEmail(String to){
//
//        String otp = sendOtp();
//        sendMail(to, "Verification mail", "Check your otp for verification "+otp);
//
//    }
//
//    public void sendMail(String to, String subject, String text){
//
//        SimpleMailMessage sm = new SimpleMailMessage();
//        sm.setTo(to);
//        sm.setSubject(subject);
//        sm.setText(text);
//
//        javaMailSender.send(sm);
//
//    }
//
//}
