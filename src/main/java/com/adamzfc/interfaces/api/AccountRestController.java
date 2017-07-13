package com.adamzfc.interfaces.api;

import com.adamzfc.application.AccountService;
import com.adamzfc.domain.model.Account;
import com.adamzfc.domain.model.Result;
import com.adamzfc.interfaces.mvc.json.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Result addAccount(@RequestBody Account account) {
        if (validate(account)) {
            if (accountService.insert(account) > 0) {
                return new Result(true, "success", 0);
            }
        }
        return new Result(false, "fail", 0);
    }

    private boolean validate(Account account) {
        if (account == null) {
            return false;
        }
        if (StringUtils.isEmpty(account.getName())) {
            return false;
        }
        return true;
    }
}
