package com.springapp.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by skaramched on 10/21/15.
 */

@Entity
@Table(name = "tracker")
public class Tracker {

    private TrackerCompositeKey trackerCompositeKey;

    private Integer loggedInUser;

    @EmbeddedId
    public TrackerCompositeKey getTrackerCompositeKey() {
        return trackerCompositeKey;
    }

    public void setTrackerCompositeKey(final TrackerCompositeKey trackerCompositeKey) {
        this.trackerCompositeKey = trackerCompositeKey;
    }

    @Column(name="created_by")
    public Integer getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(final Integer loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}