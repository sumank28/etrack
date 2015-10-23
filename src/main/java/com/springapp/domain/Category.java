package com.springapp.domain;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by skaramched on 10/23/15.
 */

@Entity
@Table(name = "category")
public class Category {
    private Integer categoryId;

    private String categoryName;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(final Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "category_name", unique = true, nullable = false, length = 40)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }
}
