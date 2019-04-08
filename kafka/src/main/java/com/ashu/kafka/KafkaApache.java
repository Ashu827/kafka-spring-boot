package com.ashu.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class KafkaApache {
	
	
	@Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
	
	
	 private static final String TOPIC = "test1";
	 
	 @GetMapping("/publish/{name}/{tech}")
	    public String post(@PathVariable("name") final String name,@PathVariable ("tech") final String tech ){

	        kafkaTemplate.send(TOPIC, new User(name, tech));

	        return "Published successfully";
	    }

	
	 
	/* @GetMapping("/publish/{message}")
	    public String post1(@PathVariable("message") final String message) {

	        kafkaTemplate.send(TOPIC, message);

	        return "Published successfully";
	    }*/
}
