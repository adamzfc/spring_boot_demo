package com.adamzfc.security;

import com.adamzfc.domain.model.User;
import com.adamzfc.domain.repository.RoleRepository;
import com.adamzfc.domain.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by adamzfc on 4/8/17.
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(MyUserDetailService.class);

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        LOGGER.debug(username + " " + user.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("no user");
        }
        SecurityUser securityUser = new SecurityUser(user.getId(), username, user.getPassword(),
                !user.isDisabled(), true, true, true, grantedAuthorities(user.getId()), user.getSalt(), user.getEmail());
        return securityUser;
    }

    protected Collection<GrantedAuthority> grantedAuthorities(int userId) {
//        List<Role> roles = roleRepository.getRoles(userId);
//        if (CollectionUtils.isEmpty(roles)) {
//            return new ArrayList<>();
//        }
        Collection<GrantedAuthority> authorities = new HashSet<>();
//        roles.stream().filter(role -> !role.isDisabled()).forEach((role ->
//            authorities.add(new SimpleGrantedAuthority(role.getName()))));
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
    }
}
