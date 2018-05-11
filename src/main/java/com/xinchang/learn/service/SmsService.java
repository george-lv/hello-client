package com.xinchang.learn.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.greentown.smscenter.result.CallRemoteResult;




@FeignClient(value = "myapp")
@Service
public interface SmsService {
	
	@PostMapping(value="/rest/sms/sendMsg")
	public CallRemoteResult<Boolean> sendMsg(@RequestBody Map<String, String> paramMap);
	

}
