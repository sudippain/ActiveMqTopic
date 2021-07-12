package com.example.ActiveMqTopic.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class ManualReceiverWithoutListener {

	  private static final Logger LOGGER =
		      LoggerFactory.getLogger(ManualReceiverWithoutListener.class);
	  
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${destination.topic}")
	private String topic;
	
	@GetMapping("/receive")
	public String reciver() {
		
		String response =  jmsTemplate.receiveAndConvert(topic).toString();
		  LOGGER.info("'subscriber3' received message='{}'", response);
		return response;

	}
}
