package com.adamzfc.infrastructure;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by adamzfc on 4/8/17.
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
