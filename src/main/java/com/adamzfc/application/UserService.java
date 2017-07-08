package com.adamzfc.application;

import com.adamzfc.domain.model.User;
import com.adamzfc.domain.repository.UserRepository;
import com.adamzfc.security.MyMd5PasswordEncoder;
import com.adamzfc.security.SecurityUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * Created by adamzfc on 2017/7/3.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected MyMd5PasswordEncoder md5PasswordEncoder;

    @SuppressWarnings("deprecation")
    public void create(User user) {
        validate(user);
        Assert.hasText(user.getPassword(), "user need a password");
        user.setDisabled(false);
        user.setCreateTime(new Date());
        user.setSalt(RandomStringUtils.randomAscii(10));
        user.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), user.getSalt()));
        userRepository.insert(user);
    }

    private void validate(User user) {
        Assert.hasText(user.getUsername(), "user need a username");
        if (user.isRoot()) {
            throw new IllegalArgumentException("user loginName cannot is root");
        }
    }

    public void modify(User user) {
        Assert.hasText(user.getId());
        User old = get(user.getId());
        if (StringUtils.isNotBlank(user.getUsername())) {
            old.setUsername(user.getUsername());
        } else {
            user.setUsername(SecurityUtil.getUser().getUsername());
        }
        if (StringUtils.isNotBlank(user.getPassword())) {
            old.setPassword(md5PasswordEncoder.encodePassword(user.getPassword(), old.getSalt()));
        }
        if (StringUtils.isNotBlank(user.getEmail())) {
            old.setEmail(user.getEmail());
        }
        userRepository.updateByPrimaryKey(old);
    }

    public void switchStatus(String id, boolean disable) {
        userRepository.switchStatus(id, disable ? 1 : 0);
    }

    public void delete(String id) {
        userRepository.deleteByPrimaryKey(id);
    }

    public User get(String id) {
        return userRepository.selectByPrimaryKey(id);
    }

    public List<User> list() {
        return userRepository.list();
    }
}
