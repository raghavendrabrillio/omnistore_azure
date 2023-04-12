package com.brillio.omnistore.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.brillio.omnistore.notification.Message;

@Service
public class NotificationService {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	public void notify(Message message, String username) {
		messagingTemplate.convertAndSendToUser(username, "/queue/notify", message);
		return;
	}
	
	public void notifyCustomer(Message message, String username) {
		messagingTemplate.convertAndSendToUser(username, "/queue/notify/customer", message);
		return;
	}
}
