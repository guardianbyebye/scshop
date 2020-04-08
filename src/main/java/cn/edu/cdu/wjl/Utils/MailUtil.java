package cn.edu.cdu.wjl.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

@Repository
public class MailUtil {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender jms;

    public void sendCodetoMail(String to,String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setText(message);
        mailMessage.setSubject("二手交易平台验证码");
        jms.send(mailMessage);
    }


}
