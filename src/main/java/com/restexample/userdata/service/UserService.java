package com.restexample.userdata.service;

import com.restexample.userdata.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class UserService {

    List<User> userList = new ArrayList<User>();

    public List<User> save(User user) {

        if(userList.stream().anyMatch(input -> input.getId() == user.getId())){
            return Collections.EMPTY_LIST;
        }
        userList.add(user);
        return List.of(user);
    }
    public List<User> getUser(long userId) {
        if(isEmpty(userList)){
            return Collections.EMPTY_LIST;
        }
        return userList.stream().filter(user -> user.getId() == userId).collect(Collectors.toList());

    }
}
