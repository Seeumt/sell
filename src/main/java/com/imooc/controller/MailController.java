package com.imooc.controller;

import com.imooc.config.MailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailConfig mailConfig;
    @GetMapping("/sendTextMail")
    public String sendMail(String receiver) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailConfig.getSender());
        message.setTo(receiver);
        message.setSubject(mailConfig.getSubject());
        message.setText(mailConfig.getText());
        try {
            javaMailSender.send(message);
            log.info("文本邮件发送成功！");
            return "success";
        } catch (Exception e) {
            log.error("文本邮件发送异常！", e);
            return "failure";
        }
    }
}
