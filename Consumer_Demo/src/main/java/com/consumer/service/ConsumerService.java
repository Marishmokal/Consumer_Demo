package com.consumer.service;

import com.consumer.model.ConsumerAccount;

public interface ConsumerService {

	ConsumerAccount getConsumerById(int id);

	String createConsumer(ConsumerAccount consumerAccount);

}
