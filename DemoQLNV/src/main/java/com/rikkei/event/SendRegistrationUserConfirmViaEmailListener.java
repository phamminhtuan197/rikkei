package com.rikkei.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.rikkei.service.IEmailService;

//Việc gửi Email xác nhận sẽ thực hiện bằng việc bắn ra 1 Event, class này sẽ lắng nghe và bắt được event này từ phía AccountService, sau đó Class này sẽ gọi tới emailService để gửi Email tới người dùng.

@Component
public class SendRegistrationUserConfirmViaEmailListener
		implements ApplicationListener<OnSendRegistrationUserConfirmViaEmailEvent> {

	@Autowired
	private IEmailService emailService;

	@Override
	public void onApplicationEvent(OnSendRegistrationUserConfirmViaEmailEvent event) {
		sendConfirmViaEmail(event.getEmail());
	}

	private void sendConfirmViaEmail(String email) {
		emailService.sendRegistrationUserConfirm(email);
	}

}
