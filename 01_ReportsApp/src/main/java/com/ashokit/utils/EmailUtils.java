package com.ashokit.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    @Autowired
	private JavaMailSender mailSender;

    public boolean sendEmail(String subject,String body,String to,File file) {
    	boolean isSuccess=false;
    	try {
    		MimeMessage mimeMsg=mailSender.createMimeMessage();
    		MimeMessageHelper helper=new MimeMessageHelper(mimeMsg,true);
    		
    		helper.setFrom("riyavermawus2@gmail.com");
    		helper.setSubject(subject);
    		helper.setText(body,true);
    		helper.setTo(to);
    		helper.addAttachment("Plans-Info", file);
    		isSuccess=true;
    		mailSender.send(mimeMsg);
    	}
    	catch(Exception e) {
    		isSuccess=false;
    		e.printStackTrace();
    	}
    	return isSuccess;
    }
}
