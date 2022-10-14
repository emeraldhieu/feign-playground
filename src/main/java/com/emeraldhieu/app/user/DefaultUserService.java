package com.emeraldhieu.app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final UserClient userClient;

    @Override
    public List<User> getUsers() {
        return userClient.getUsers().getUsers();
    }
}
