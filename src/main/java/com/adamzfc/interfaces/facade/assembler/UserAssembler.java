package com.adamzfc.interfaces.facade.assembler;

import com.adamzfc.domain.model.User;
import com.adamzfc.infrastructure.CommonUtils;
import com.adamzfc.interfaces.facade.command.ProfileCommand;
import com.adamzfc.interfaces.facade.command.UserCommond;
import com.adamzfc.interfaces.facade.dto.UserDto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class UserAssembler {

    public static User commondToDomain(UserCommond commond) {
        User user=new User();
        CommonUtils.copeProperties(commond,user);
        return user;
    }

    public static User commondToDomain(String uid, UserCommond commond) {
        User user = new User();
        CommonUtils.copeProperties(commond, user);
        user.setId(uid);
        return user;
    }

    public static User profileToDomain(String uid, ProfileCommand commond) {
        User user = new User();
        CommonUtils.copeProperties(commond, user);
        user.setId(uid);
        return user;
    }


    public static UserDto domainToDto(User user){
        UserDto dto=new UserDto();
        CommonUtils.copeProperties(user,dto);
        return dto;
    }

    public static List<UserDto> domainToDto(List<User> user){
       if(CollectionUtils.isEmpty(user)){
           return null;
       }
        List<UserDto> dtos=new ArrayList<>(user.size());
        user.forEach(user1 -> dtos.add(domainToDto(user1)));
        return dtos;
    }

}
