package com.springapp.dao.impl;

import com.springapp.dao.TrackerDAO;
import com.springapp.domain.Tracker;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by skaramched on 10/23/15.
 */

@Repository
public class TrackerDAOImpl implements TrackerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void checkout(Tracker tracker) {
        sessionFactory.getCurrentSession().save(tracker);
    }
}
