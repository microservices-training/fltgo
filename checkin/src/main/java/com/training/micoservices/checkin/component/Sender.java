package com.training.micoservices.checkin.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	RabbitMessagingTemplate template;

	@Autowired
	 Sender(RabbitMessagingTemplate template) {
		this.template = template;
	}
	
	Queue queue() {
		
		return new Queue("CheckINQ",false);
		}
	
	public void send(Object message) {
		template.convertAndSend("CheckINQ",message);
	}

}
