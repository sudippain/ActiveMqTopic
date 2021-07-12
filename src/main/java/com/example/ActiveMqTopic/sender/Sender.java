package com.example.ActiveMqTopic.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	 @Value("${destination.topic}")
	  private String topicDestination;

	  private static final Logger LOGGER =
	      LoggerFactory.getLogger(Sender.class);

	  @Autowired
	  private JmsTemplate jmsTemplate;

	  public void send(String message) {
		  System.out.println(topicDestination);
	    LOGGER.info("sending message='{}' to destination='{}'", message,
	        topicDestination);
	    jmsTemplate.convertAndSend(topicDestination, message);
	    
	    jmsTemplate.convertAndSend("topic2", message); //Topic name giving Manually
	  }
}
