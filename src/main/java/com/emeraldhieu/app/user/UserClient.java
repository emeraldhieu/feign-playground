package com.emeraldhieu.app.user;

import feign.Headers;
import feign.RequestLine;

/**
 * The second way of using Open Feign without Spring.
 */
@Headers({
    "Accept-Language: en-US",
})
public interface UserClient {

    @RequestLine("GET")
    @Headers({
        "Whatever: whatever",
    })
    GetUsersResponse getUsers();
}
