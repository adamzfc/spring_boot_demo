package com.adamzfc.domain.repository;

import com.adamzfc.domain.model.Account;
import com.adamzfc.infrastructure.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Mapper
public interface AccountRepository extends MyMapper<Account> {
}
