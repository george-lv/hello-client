package com.greentown.learn.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.greentown.learn.common.CallRemoteResult;


@FeignClient(value = "myapp")
@Service
public interface SmsService {
	
	@RequestMapping(value="/rest/sms/sendMsg",method = RequestMethod.POST)
	public CallRemoteResult<Boolean> sendMsg(@RequestBody Map<String, String> paramMap);
	

}
