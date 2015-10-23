package com.springapp.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by skaramched on 10/23/15.
 */
@Embeddable
public class TrackerCompositeKey implements Serializable {

    private String itemId;

    private String username;

    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }
}