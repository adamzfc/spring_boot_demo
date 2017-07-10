package com.adamzfc.interfaces.api;

import com.adamzfc.application.AuthService;
import com.adamzfc.domain.model.Result;
import com.adamzfc.interfaces.facade.command.TokenCreateCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adamzfc on 2017/7/10.
 */
@RestController
@RequestMapping(value = "/api/auth")
public class AuthRestController {

    @Autowired
    private AuthService authService;

    @RequestMapping(method = RequestMethod.POST)
    public Result createAuthenticationToken(@RequestBody TokenCreateCommand tokenCreateCommand) {
        final String token = authService.login(tokenCreateCommand.getUsername(), tokenCreateCommand.getPassword());
        Result result = new Result();
        result.setSuccess(true);
        result.setData(token);
        return result;
    }
}
