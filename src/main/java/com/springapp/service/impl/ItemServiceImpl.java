package com.springapp.service.impl;

import com.springapp.dao.ItemDAO;
import com.springapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by skaramched on 10/21/15.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    public List<?> findAll() {
        return itemDAO.findAll();
    }
}
