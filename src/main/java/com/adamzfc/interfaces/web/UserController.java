package com.adamzfc.interfaces.web;

import com.adamzfc.application.UserService;
import com.adamzfc.interfaces.facade.assembler.UserAssembler;
import com.adamzfc.interfaces.facade.command.ProfileCommand;
import com.adamzfc.interfaces.facade.command.UserCommond;
import com.adamzfc.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by adamzfc on 4/8/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public String create( UserCommond user){
        userService.create(UserAssembler.commondToDomain(user));
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable("id") String id, UserCommond user) {
        userService.modify(UserAssembler.commondToDomain(id, user));
        return "redirect:/user";
    }

    @RequestMapping(value = "/{id}/status",method = RequestMethod.PUT)
    @ResponseBody
    public void switchStatus(@PathVariable("id") String id,@RequestParam("disable") boolean disable){
        userService.switchStatus(id,disable);
    }
    @RequestMapping(value = "/{id}/delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id")String id){
        userService.delete(id);
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(@RequestParam(value = "id",required = false)String id, Model model){
        String api="/user/add";
        if(!StringUtils.isEmpty(id)){
            model.addAttribute("account",UserAssembler.domainToDto(userService.get(id)));
            api="/user/"+id+"/modify";
        }
        model.addAttribute("api",api);
        return  "user/form";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("list",UserAssembler.domainToDto(userService.list()));
        return "user/list";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "user/profile";
    }

    @RequestMapping(value = "/modify-profile", method = RequestMethod.POST)
    public String modifyProfile(ProfileCommand profile) {
        this.userService.modify(UserAssembler.profileToDomain(SecurityUtil.getUid(), profile));
        SecurityUtil.getUser().setEmail(profile.getEmail());
        return "user/profile";
    }
}
