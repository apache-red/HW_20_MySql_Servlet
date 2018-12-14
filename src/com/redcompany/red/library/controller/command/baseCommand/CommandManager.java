package com.redcompany.red.library.controller.command.baseCommand;

import com.redcompany.red.library.controller.command.baseCommand.impl.*;


import static com.redcompany.red.library.controller.util.ControllerConstantStorage.*;

public class CommandManager {

    // это С в MVC . принимает команду от V и передает ее

    private static BasicCommand command = new DefaultCommand();

    public static BasicCommand defineCommand(String action) {
        switch (action) {
            case COMMAND_ALL_CATALOGS_ALL_BOOK_LIST:
                command = new ViewAllBooksInAllCatalogs();
                break;
            case COMMAND_CATALOG_ROW:
                command = new ViewSingleCatalogRowCommand();
                break;
            case COMMAND_FIND_BOOK_IN_LIBRARY:
                command = new ViewBookFindByTitleCommand();
                break;
            case COMMAND_ADD_BOOK:
                command = new AddNewBookToCatalogCommand();
                break;
            case COMMAND_FIND_BOOK_BY_AUTHOR:
                command = new FindBookByAuthor();
                break;
            case "test_db":
                command = new DBViewAllBooksInCatalogs();
                break;

        }
        return command;
    }
}
