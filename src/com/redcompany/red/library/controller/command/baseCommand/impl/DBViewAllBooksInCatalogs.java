package com.redcompany.red.library.controller.command.baseCommand.impl;

import com.redcompany.red.library.controller.command.baseCommand.BasicCommand;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.service.DBService;
import com.redcompany.red.library.service.impl.RegularDBServiceImpl;

import java.util.Map;

public class DBViewAllBooksInCatalogs implements BasicCommand {

    private DBService dbService;
    private DataBase dataBase;


    @Override
    public void performAction(Map<String, Object> userdata, DataBase dataBase) {

        dbService = new RegularDBServiceImpl();

      //  System.out.println(dbService.getBookList(dataBase.gedDataBase()));
    }
}
