package com.greentown.learn.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloResource {


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @GetMapping
    public String hello() {
        String url = "http://hello-server/rest/hello/server";
        return restTemplate.getForObject(url, String.class)+ " including client";
    }
    
    
    @RequestMapping(value="/sendAuthCode",method = RequestMethod.POST)
    public boolean sendAuthCode() {
        String url = "http://MYAPP/api/sms/sendAuthCode";
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
