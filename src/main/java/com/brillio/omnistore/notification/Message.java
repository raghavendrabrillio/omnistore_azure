package com.brillio.omnistore.notification;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -2170099457407737131L;
	private String message;

	public Message(String content) {
		this.message = content;
	}

	public String getContent() {
		return message;
	}
}
