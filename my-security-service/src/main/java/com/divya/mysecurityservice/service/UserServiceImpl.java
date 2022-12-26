package com.divya.mysecurityservice.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService {
    static Map<String, String> users = Map.of("divya", "$2y$12$nJyUTARxas3TJl3U3PqhIe/wv/xKFmwehIS7l5ZBunuP/OxZVsnOG",
            "bhanu", "$2y$12$W0.Ury4K3ZrukzNRzTDBO.JT1Yf/qoARh40ZhBXW2FgwtoM2FBnqe");

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if (users.containsKey(userName)) {
            return new User(userName, users.get(userName), new ArrayList<>());
        }

        throw new UsernameNotFoundException("user not found: " + userName);
    }
}
