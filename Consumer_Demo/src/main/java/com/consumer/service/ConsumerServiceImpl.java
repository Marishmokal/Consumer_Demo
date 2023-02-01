package com.consumer.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.consumer.model.ConsumerAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	// Autowiring Apache Http Client
	@Autowired
	CloseableHttpClient client;

	

	@Value("${base.url}")
	String url;
	ObjectMapper objMapper = new ObjectMapper();
	@Override
	public ConsumerAccount getConsumerById(int id) {

		String uri = url + id;
		
		HttpGet get = new HttpGet(uri);
		
		CloseableHttpResponse response;
		ConsumerAccount acc =null;
		
		
		
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			
//			String json = EntityUtils.toString(response.getEntity());
	
			String json = EntityUtils.toString(entity);

			
			//		System.out.println(EntityUtils.toString(entity));
			
			acc = objMapper.readValue(json, ConsumerAccount.class);
			
			System.out.println(acc);			
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;

	}
	

	@Override
	public String createConsumer(ConsumerAccount consumerAccount) {
		
		String json=null;
		String result=null;
		
		HttpPost post=new HttpPost(url);
		
		
		try {
			
			json=objMapper.writeValueAsString(consumerAccount);
			
			StringEntity entity = new StringEntity(json);
			
			post.setHeader("Content-type", "application/json");
			post.setEntity(entity);
			
			HttpResponse res=client.execute(post);
			
			result=EntityUtils.toString(res.getEntity());
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
		
		
	}

}
