package com.example.demo.emailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.EmailService.EmailServices;
import com.example.demo.model.emailsender;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class EmailController {

	@Autowired
     private EmailServices esr;
	//get the value from authenticate email and store into fromEmail
		@Value("${spring.mail.username}")
		String fromEmail;

	@RequestMapping("/send")
	public String sendEmail(@RequestBody emailsender e)
	{
	try
	   {
		e.setFromEmail(fromEmail);
		esr.sentEmail(e);
	   }
	catch(Exception e2)
	{
		e2.printStackTrace();
	}
	return "sent";
   }   
	
	 @RequestMapping(value="/emailwithAttachment" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 public String sendmailWithAttachment
     (
		@RequestPart(required = true,value = "attachment")MultipartFile at,
      @RequestPart("email") String e
      )
	         {
	                try {
	                	ObjectMapper om=new ObjectMapper();
	                emailsender	es=om.readValue(e,emailsender.class);
//pura data emailsender k object me sent kiya and then object and attachment sent kiya service me              
	                emailsender em=new emailsender();
	                
	             // es ki value em me sent karenge 	        
	                	em.setFromEmail(fromEmail);
	                	em.setSubject(es.getSubject());
	                	em.setToEmail(es.getToEmail());
	                	em.setTextBody(es.getTextBody());
	                	
	                	esr.sendAttachment(em,at);
	                	
	                }catch(Exception e2)
	               {
	                	
	                }
	          return "Email sent successfully.....";
	  
	
	         }  
}