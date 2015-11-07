package com.tadtab.restService;

import org.springframework.web.client.RestTemplate;

import com.tadtab.topRest.Members;

public class RestService {
	
	public static void main(String[] args){
		final String url = "http://localhost:8088/yea/members.xml";
		RestTemplate template = new RestTemplate();
		Members result = template.getForObject(url, Members.class);
		System.out.println(result.getClass());
	}

}
