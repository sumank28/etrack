package com.springapp.domain;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by skaramched on 10/21/15.
 */

@Entity
@Table(name = "item")
public class Item {

    private Integer itemId;

    private String itemName;

    //private Category category;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    /*@OneToOne(cascade = CascadeType.ALL)
    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }*/
}
