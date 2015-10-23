package com.springapp.dao;

import com.springapp.domain.User;

import java.util.List;

/**
 * Created by skaramched on 10/21/15.
 */
public interface UserDAO {

    User findByUserName(String username);

    List<User> findAll();

}