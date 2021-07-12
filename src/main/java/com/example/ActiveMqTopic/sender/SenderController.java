package com.example.ActiveMqTopic.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActiveMqTopic.sender.Sender;

@RestController
@RequestMapping("/topic")
public class SenderController {
	
	
	@Autowired
	Sender sender;
	
	@PostMapping("/send/message")
	public String sendMessage() {
		sender.send("Sudip");
		return "Request send to Topic";
	}

}
