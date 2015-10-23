package com.springapp.dao.impl;

import com.springapp.dao.UserDAO;
import com.springapp.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skaramched on 10/21/15.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly=true)
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession()
            .createQuery("from User where username=?")
            .setParameter(0, username)
            .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    @Transactional(readOnly=true)
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
            .createQuery("from User")
            .list();
    }

}