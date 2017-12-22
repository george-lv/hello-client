package com.greentown.learn.cloud;

import com.greentown.learn.common.CallRemoteResult;
import com.greentown.learn.service.SmsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {

	@Autowired
	SmsService smsService;
	
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),//指定多久超时，单位毫秒。超时进fallback
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//判断熔断的最少请求数，默认是10；只有在一个统计窗口内处理的请求数量达到这个阈值，才会进行熔断与否的判断
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),//判断熔断的阈值，默认值50，表示在一个统计窗口内有50%的请求处理失败，会触发熔断
                },
                threadPoolProperties = {
                        @HystrixProperty(name = "coreSize", value = "30"),
                        @HystrixProperty(name = "maxQueueSize", value = "101"),
                        @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
                        @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
                        @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
                        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
            }

            )
    @GetMapping
    public String hello() {
        String url = "http://MYAPP/rest/sms/hello";
        return restTemplate.getForObject(url, String.class)+ " including client";
    }
    
    @RequestMapping(value="/sendMsg",method = RequestMethod.POST)
    public void sendMessage(@RequestBody Map<String, String> paramMap){
    	
    	smsService.sendMsg(paramMap);
    	
    }
    
    @RequestMapping(value="/sendAuthCode",method = RequestMethod.POST)
    public boolean sendAuthCode() {
        String url = "http://MYAPP/rest/sms/sendAuthCode";
        SendAuthCodeRO obj=new SendAuthCodeRO();
        obj.setMobile("18768439095");
        obj.setBizNo("cloud");
        
        @SuppressWarnings("unchecked")
		CallRemoteResult<Boolean> remoteResult = this.restTemplate.postForObject(url, obj, CallRemoteResult.class);
        
        return remoteResult.getReturnObject();
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
