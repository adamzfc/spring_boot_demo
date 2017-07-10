package com.adamzfc.interfaces.api;

import com.adamzfc.application.AccountService;
import com.adamzfc.domain.model.Account;
import com.adamzfc.interfaces.mvc.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adamzfc on 2017/7/10.
 */
@RestController
@RequestMapping(value = "/api/account")
public class AccountRestController {
    @Autowired
    private AccountService accountService;

    @JSON(type = Account.class, include = "id,name")
    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.list();
    }
}
