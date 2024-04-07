package com.example.demo.EmailService;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.emailsender;

@Service
public class EmailServices {

	@Autowired
	private JavaMailSender jms;
	
	public void sentEmail(emailsender e) 
{
	try{
		 SimpleMailMessage smm=new SimpleMailMessage();
		    smm.setFrom(e.getFromEmail());
		    smm.setTo(e.getToEmail());
		    smm.setText(e.getTextBody());;
		    smm.setSubject(e.getSubject());
		    
		    jms.send(smm);
	   System.out.println("Mail Sent Successfully");
	}
	catch(Exception e2)
	{
	System.out.println("mail not sent");
	e2.printStackTrace();
	}
  
  }

	public void sendAttachment(emailsender em, MultipartFile at) {
		try {
			
			MimeMessage mm=jms.createMimeMessage();
			
//simple mimemessage through attachment send nahi kar skte hence we used child of mimemessage 
			MimeMessageHelper mmh=new MimeMessageHelper(mm,true);
			mmh.setTo(em.getToEmail());
			mmh.setText(em.getTextBody());
			mmh.setSubject(em.getSubject());
			mmh.setFrom(em.getFromEmail());
			
			mmh.addAttachment(at.getOriginalFilename(), at);
			
			//mimemessagehelper provide addattchment method 
			 jms.send(mm);
			 
			 System.out.println("Email sent");
			
		} catch (Exception e) {
			System.out.println("Not sent");
			e.printStackTrace();
		}
	}
}
