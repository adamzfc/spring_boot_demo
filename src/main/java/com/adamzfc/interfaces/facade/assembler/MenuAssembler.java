package com.adamzfc.interfaces.facade.assembler;

import com.adamzfc.domain.model.Menu;
import com.adamzfc.infrastructure.CommonUtils;
import com.adamzfc.interfaces.facade.command.MenuCreateCommand;
import com.adamzfc.interfaces.facade.command.MenuUpdateCommond;

public class MenuAssembler {

    public static Menu updateCommendToDomain(String id, MenuUpdateCommond updateCommond) {
        Menu menu=new Menu();
        CommonUtils.copeProperties(updateCommond,menu);
        menu.setId(id);
        return menu;
    }

    public static Menu createCommendToDomain(MenuCreateCommand creteCommand){
        Menu menu=new Menu();
        CommonUtils.copeProperties(creteCommand,menu);
        return menu;
    }
}
