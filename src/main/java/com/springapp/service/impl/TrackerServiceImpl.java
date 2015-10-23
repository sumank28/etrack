package com.springapp.service.impl;

import com.springapp.dao.TrackerDAO;
import com.springapp.domain.Tracker;
import com.springapp.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skaramched on 10/23/15.
 */

@Service
public class TrackerServiceImpl implements TrackerService {

    @Autowired
    private TrackerDAO trackerDAO;

    public void checkout (Tracker tracker) {
        trackerDAO.checkout(tracker);
    }
}

