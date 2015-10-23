package com.springapp.dao.impl;

import com.springapp.dao.ItemDAO;
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
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<?> findAll() {
        List<String> itemList = null;


        itemList = sessionFactory.getCurrentSession()
            .createQuery("from Item")
            .list();

        return itemList;
    }
}
