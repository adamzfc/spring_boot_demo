package com.adamzfc.interfaces.api;

import com.adamzfc.domain.model.User;
import com.adamzfc.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by adamzfc on 4/8/17.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public List<User> getUsers() {
        return userRepository.list();
    }
}
