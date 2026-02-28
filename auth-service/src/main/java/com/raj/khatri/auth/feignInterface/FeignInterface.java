package com.raj.khatri.auth.feignInterface;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient(name = "user-details-service")

public interface FeignInterface {

    @GetMapping("/VerifyUser")
    Map<String, String> verifyUserCredentials(@RequestParam String userName);
}
