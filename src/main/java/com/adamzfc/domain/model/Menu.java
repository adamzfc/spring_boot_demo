package com.adamzfc.domain.model;

/**
 * Created by adamzfc on 2017/7/7.
 */
public class Menu extends TreeModel {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }

    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
    public String getPath() {
        return super.getPath();
    }

    @Override
    public void setPath(String path) {
        super.setPath(path);
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public int getOrder() {
        return super.getOrder();
    }

    @Override
    public void setOrder(int order) {
        super.setOrder(order);
    }

    @Override
    public boolean isDisabled() {
        return super.isDisabled();
    }

    public boolean getDisable() {
        return super.isDisabled();
    }

    @Override
    public void setDisabled(boolean disabled) {
        super.setDisabled(disabled);
    }

    @Override
    public String getStyle() {
        return super.getStyle();
    }

    @Override
    public void setStyle(String style) {
        super.setStyle(style);
    }

    @Override
    public int getType() {
        return super.getType();
    }

    @Override
    public void setType(int type) {
        super.setType(type);
    }
}
