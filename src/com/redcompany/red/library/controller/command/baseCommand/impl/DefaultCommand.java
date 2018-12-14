package com.redcompany.red.library.controller.command.baseCommand.impl;


import com.redcompany.red.library.controller.command.baseCommand.BasicCommand;
import com.redcompany.red.library.data.DataBase;


import java.util.Map;

public class DefaultCommand implements BasicCommand {
    @Override
    public void performAction( Map<String, Object> userdata, DataBase dataBase) {
        System.out.println("Incorrect user input");
    }


}
