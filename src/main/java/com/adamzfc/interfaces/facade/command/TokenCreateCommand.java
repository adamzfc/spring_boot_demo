package com.adamzfc.interfaces.facade.command;

import lombok.Data;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Data
public class TokenCreateCommand {
    private String username;

    private String password;
}
