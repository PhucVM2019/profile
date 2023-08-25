package com.infor.vmp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.infor.vmp.model.request.CardRequest;
import com.infor.vmp.model.response.CardResponse;

public class Service {
	@Autowired
	private RestTemplate restTemplate;
	
	//Call JSON
	public CardResponse getInfor(String url, String user, String password, CardRequest cardRequest) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("content-type", "application/json");
			headers.add("cache-control", "no-cache");
			headers.add("User", user);
			headers.add("Passwd", password);
			headers.add("Channel", cardRequest.getChanel());
			headers.add("RequestId", cardRequest.getRequestId());
			HttpEntity<CardRequest> request = new HttpEntity<CardRequest>(cardRequest, headers);
			ResponseEntity<CardResponse> response = restTemplate.postForEntity(url, request, CardResponse.class);
			CardResponse cardResponse = response.getBody();
			System.out.printf("getCardInfo", "");
			return cardResponse;
		} catch (Exception e) {
			System.out.printf(e.getMessage());
			return null;
		}
	}
}
