package com.adamzfc.domain.model;

/**
 * Created by adamzfc on 4/8/17.
 */
public class Role extends BaseEntity {
    private String name;

    private String description;

    private boolean disabled;

    public boolean isDisabled() {
        return disabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
