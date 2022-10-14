package com.emeraldhieu.app.user;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Getter
@Jacksonized
public class GetUsersResponse {

    private final List<User> users;
}
