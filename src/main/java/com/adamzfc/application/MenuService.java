package com.adamzfc.application;

import com.adamzfc.domain.model.Menu;
import com.adamzfc.domain.model.TreeModel;
import com.adamzfc.domain.repository.MenuRepository;
import com.adamzfc.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by adamzfc on 2017/7/7.
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu get(String id) {
        return menuRepository.get(id);
    }

    public Menu create(Menu menu) {
        validate(menu);
        menuRepository.insert(menu);
        return menu;
    }

    public List<Menu> list() {
        List<Menu> list = menuRepository.list();
        TreeModel.sortByTree(list);
        return list;
    }

    public List<Menu> getNavMenus(String uid) {
        List<Menu> list = null;
        if (SecurityUtil.isRoot()) {
            list = menuRepository.list();
        } else {
            list = menuRepository.getNavMenus(uid);
        }
        return (List<Menu>) TreeModel.buildTree(list);
    }

    public void delete(String id) {
        menuRepository.remove(id);
    }

    public void switchStatus(String menu, boolean disable) {
        menuRepository.switchStatus(menu, disable?1:0);
    }

    public void modify(Menu menu) {
        validate(menu);
        menuRepository.updateByPrimaryKey(menu);
    }

    private void validate(Menu menu) {
        Assert.hasText(menu.getId(), "menu need a id");
        Assert.hasText(menu.getLabel(), "menu need a label");
    }
}
