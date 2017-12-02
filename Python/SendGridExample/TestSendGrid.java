package com.program.test.where.sendgrid;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpStatus;

import com.sendgrid.*;
public class TestSendGrid {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("abc@xyz.com");
		set.add("computerScience@gmail.com");
		String subject = "Subject";
		String body = "body";
		sendMessage(set, subject, body);
		System.out.print("DONE");
	}
    protected static String apiKey = "API Key";
    protected static String fromStr = "donotreply@xyz.com";
    public static void sendMessage(Set<String> toSet, String subject, String body) {
        
        Mail mail = new Mail();
        Email fromEmail = new Email();
        fromEmail.setEmail(fromStr);
        mail.setFrom(fromEmail);
        
        Personalization personalization = getPersonalization(toSet);
        personalization.setSubject(subject);
        mail.addPersonalization(personalization);
        
        Content content = new Content("text/plain", body);
        mail.addContent(content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.toString());
            System.out.println(response.getStatusCode());
            /*if (response.getStatusCode() != HttpStatus.OK.value()) {
                logger.warn("Failure sending email(SengGrid) : " + response.getBody());
            }*/
        } catch (IOException ex) {
            //logger.warn("IOException sending email(SengGrid) : " + ex, ex);
        	System.out.println(ex);
        }
    }

    private static Personalization getPersonalization(Set<String> toSet) {
        Personalization personalization = new Personalization();
        for(String email : toSet) {
            Email to = new Email();
            to.setEmail(email);
            personalization.addTo(to);
        }
        return personalization;
    }

}
