package com.springapp.mvc;

import com.springapp.domain.TrackerCompositeKey;
import com.springapp.form.Tracker;
import com.springapp.service.ItemService;
import com.springapp.service.TrackerService;
import com.springapp.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes
public class ETrackHomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private TrackerService trackerService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {

        model.addAttribute("tracker", new Tracker());

        populateScreen(model);

        return "home";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)

    public String checkout(@ModelAttribute("tracker") Tracker tracker, ModelMap model, BindingResult result) {

        populateScreen(model);
        populateTracker(tracker);

        return "home";
    }

    private void populateScreen(ModelMap model) {
        model.addAttribute("message", "Item Tracker");

        model.addAttribute("itemList", itemService.findAll());

        model.addAttribute("userList", userDetailsService.findAll());
    }

    private void populateTracker(Tracker formTracker) {

        com.springapp.domain.Tracker tracker = new com.springapp.domain.Tracker();

        TrackerCompositeKey key = new TrackerCompositeKey();

        tracker.setTrackerCompositeKey(key);

        tracker.getTrackerCompositeKey().setItemId(formTracker.getItemId());
        tracker.getTrackerCompositeKey().setUsername(formTracker.getUsername());

        tracker.setLoggedInUser(1);

        trackerService.checkout(tracker);
    }
}