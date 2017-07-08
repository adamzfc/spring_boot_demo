package com.adamzfc.interfaces.web;

import com.adamzfc.application.MenuService;
import com.adamzfc.interfaces.facade.assembler.MenuAssembler;
import com.adamzfc.interfaces.facade.command.MenuCreateCommand;
import com.adamzfc.interfaces.facade.command.MenuUpdateCommond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by adamzfc on 2017/7/7.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("list", menuService.list());
        return "menu/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String create(MenuCreateCommand menu) {
        menuService.create(MenuAssembler.createCommendToDomain(menu));
        return "redirect:/menu";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String toform(@RequestParam(value = "id", required = false) String id, @RequestParam(value = "parent", required = false) boolean parent, Model model) {
        String url = null;
        if (!StringUtils.isEmpty(id) && !parent) {
            model.addAttribute("menu", menuService.get(id));
            url = "/menu/" + id + "/modify";
        } else {
            url = "/menu/add";
            if (!StringUtils.isEmpty(id)) {
                model.addAttribute("parentPath", id);
            }
        }
        model.addAttribute("api", url);
        return "menu/form";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") String id) {
        menuService.delete(id);
    }

    @RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
    @ResponseBody
    public void switchStatus(@PathVariable("id") String id, @RequestParam("disable") boolean disable) {
        menuService.switchStatus(id,disable);
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, MenuUpdateCommond menu) {
        menuService.modify(MenuAssembler.updateCommendToDomain(id, menu));
        return "redirect:/menu";
    }
}
