package com.restexample.userdata.service;

import com.restexample.userdata.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = mock(UserService.class);
    }
    @Test
    void should_return_response_when_searched_by_valid_request(){
        User load_user = new User(1,"first_user","IT","");
        when(userService.getUser(1)).thenReturn(loadUserData(load_user));
        List<User> userList = userService.getUser(1);
        assertThat(userList.size()).isEqualTo(1);
    }

    @Test
    void should_return_success_response_valid_create_user_request(){
        User create_user = new User(2,"second_user","HealthCare","");
        when(userService.save(create_user)).thenReturn(loadUserData(create_user));
        assertThat( userService.save(create_user).get(0).getUserName()).isEqualTo("second_user");
    }


    public List<User> loadUserData(User user) {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return userList;
    }
}


