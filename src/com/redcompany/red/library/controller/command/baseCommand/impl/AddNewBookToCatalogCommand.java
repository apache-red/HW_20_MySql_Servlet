package com.redcompany.red.library.controller.command.baseCommand.impl;

import com.redcompany.red.library.controller.command.baseCommand.BasicCommand;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.service.LibraryService;
import com.redcompany.red.library.service.impl.RegularLibraryServiceImpl;

import java.util.Map;

public class AddNewBookToCatalogCommand implements BasicCommand {

    private LibraryService libraryService;

    @Override
    public void performAction(Map<String, Object> userdata, DataBase dataBase) {


        libraryService = new RegularLibraryServiceImpl();
        libraryService.addNewBookToCatalog(userdata, dataBase.gedLibraryData());
    }
}
