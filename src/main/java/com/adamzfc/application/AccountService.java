package com.adamzfc.application;

import com.adamzfc.domain.model.Account;
import com.adamzfc.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> list() {
        return accountRepository.selectAll();
    }
}
