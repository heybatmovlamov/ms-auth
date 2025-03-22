package com.msauth.client;

import com.msauth.client.model.UserView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-user",
        url = "${application.client.ms-user.url}/v1/users")
public interface UserClient {

    @GetMapping("/{username}")
    UserView findByUsername(@PathVariable  String username);
}
