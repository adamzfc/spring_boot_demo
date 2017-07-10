package com.adamzfc.interfaces.api;

import com.adamzfc.domain.model.User;
import com.adamzfc.domain.repository.UserRepository;
import com.adamzfc.interfaces.mvc.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

//    @RequestMapping(method = RequestMethod.GET)
//    @JSON(type = User.class, include = "username")
//    public ResponseEntity<List<User>> getUsers() {
//        return new ResponseEntity<>(userRepository.list());
//    }

    @RequestMapping(method = RequestMethod.GET)
    @JSON(type = User.class, include = "id,username,email,createTime,lastTime")
    public List<User> getUsers() {
//        throw new RuntimeException("test runtime");
        return userRepository.list();
    }
}
