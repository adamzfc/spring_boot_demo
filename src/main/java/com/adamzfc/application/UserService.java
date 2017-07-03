package com.adamzfc.application;

import com.adamzfc.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by adamzfc on 2017/7/3.
 */
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
