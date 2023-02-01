package com.consumer;//by using apache client

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerDemoApplication.class, args);
	}

	//Bean for Apache Http Client
	@Bean
	public CloseableHttpClient client()
	{
		return HttpClients.createDefault();
	}
	@Bean
	public DozerBeanMapper mapper()
	{
		return new DozerBeanMapper();
	}
}
