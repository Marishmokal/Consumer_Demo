package com.consumer.controller;

import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.model.ConsumerAccount;
import com.consumer.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;
	
	@GetMapping("/consumerAccounts/{id}")
	public ConsumerAccount getConsumerById(@PathVariable("id")int id)
	{
		return consumerService.getConsumerById(id);
	}
	
//	public String createConsumer(@RequestBody ConsumerAccount consumerAccount )
	@PostMapping("/consumerAccount")
	public String createConsumer(@RequestBody ConsumerAccount consumerAccount )
	{
		
		return consumerService.createConsumer(consumerAccount);
		 
	}
}
