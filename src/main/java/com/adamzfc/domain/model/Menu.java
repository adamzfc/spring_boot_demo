package com.adamzfc.domain.model;

import javax.persistence.Column;

/**
 * Created by adamzfc on 2017/7/7.
 */
public class Menu extends TreeModel {
    @Column
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
