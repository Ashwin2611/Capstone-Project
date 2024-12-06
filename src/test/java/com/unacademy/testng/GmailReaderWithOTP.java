package com.unacademy.testng;

import javax.mail.*;
import javax.mail.search.FlagTerm;

import org.jsoup.Jsoup;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GmailReaderWithOTP {
	public String fetchOTPFromEmail() throws Exception {
	    // Email configuration
	    String host = "imap.gmail.com";
	    String username = "ashwin261100@gmail.com";
	    String appPassword = "dvki huuk megu tlvt"; // Use your generated app password

	    Properties properties = new Properties();
	    properties.put("mail.store.protocol", "imaps");
	    properties.put("mail.imap.host", host);
	    properties.put("mail.imap.port", "993");
	    properties.put("mail.imap.ssl.enable", "true");

	    Session session = Session.getInstance(properties, null);
	    Store store = session.getStore();
	    store.connect(host, username, appPassword);

	    Folder inbox = store.getFolder("INBOX");
	    inbox.open(Folder.READ_WRITE);

	    // Fetch unread messages
	    Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
	    for (Message message : messages) {
	        String subject = message.getSubject();
	        System.out.println("Subject: " + subject);

	        if (message.isMimeType("text/plain")) {
	            String body = (String) message.getContent();
	            System.out.println("Email Body: " + body);
	            String otp = extractOTP(body);
	            if (otp != null) {
	          	  message.setFlag(Flags.Flag.SEEN, true);
	                return otp;
	            }
	        } else if (message.isMimeType("multipart/*")) {
	            Multipart multipart = (Multipart) message.getContent();
	            for (int i = 0; i < multipart.getCount(); i++) {
	                BodyPart bodyPart = multipart.getBodyPart(i);
	                if (bodyPart.isMimeType("text/plain")) {
	                    String body = (String) bodyPart.getContent();
	                    System.out.println("Email Body Part: " + body);
	                    String otp = extractOTP(body);
	                    if (otp != null) {
	                    	message.setFlag(Flags.Flag.SEEN, true);
	                        return otp;
	                    }
	                } else if (bodyPart.isMimeType("text/html")) {
	                    String body = (String) bodyPart.getContent();
	                    // Parse HTML to get plain text using Jsoup
	                    String plainText = Jsoup.parse(body).text();
	                    System.out.println("Email Body (HTML to Text): " + plainText);
	                    String otp = extractOTP(plainText);
	                    if (otp != null) {
	                    	message.setFlag(Flags.Flag.SEEN, true);
	                        return otp;
	                    }
	                }
	            }
	        }
	        Thread.sleep(5000); 
	    }

	    inbox.close(false);
	    store.close();
	    throw new Exception("OTP not found in email.");
	}

	private String extractOTP(String body) {
	    // Regex to find 4-6 digit OTP
	    Pattern otpPattern = Pattern.compile("\\b\\d{4,6}\\b");
	    Matcher matcher = otpPattern.matcher(body);
	    if (matcher.find()) {
	        return matcher.group();
	    }
	    return null;
	}
}
