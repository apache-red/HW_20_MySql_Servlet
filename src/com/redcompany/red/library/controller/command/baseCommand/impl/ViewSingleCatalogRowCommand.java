package com.redcompany.red.library.controller.command.baseCommand.impl;

import com.redcompany.red.library.controller.command.baseCommand.BasicCommand;
import com.redcompany.red.library.controller.console.view.ResultConsoleView;
import com.redcompany.red.library.data.DataBase;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.service.LibraryService;
import com.redcompany.red.library.service.impl.RegularLibraryServiceImpl;

import java.util.Map;

public class ViewSingleCatalogRowCommand implements BasicCommand {

    private LibraryService libraryService;
    private Book book;

    @Override
    public void performAction(Map<String, Object> userdata, DataBase dataBase) {

        libraryService = new RegularLibraryServiceImpl();

        book = libraryService.getBookFromCatalog(userdata, dataBase.gedLibraryData());
        ResultConsoleView.showResult(book);

    }
}
