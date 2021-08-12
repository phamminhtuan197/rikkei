package com.rikkei.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.rikkei.entity.MailInfo;

public interface ISendMailService {

	void run();

	void queue(String to, String subject, String body);

	void queue(MailInfo mail);

	void send(MailInfo mail) throws MessagingException, IOException;

}
