package com.redcompany.red.library.controller.command.webCommand;

import com.redcompany.red.library.controller.command.webCommand.impl.DefaultActionImpl;
import com.redcompany.red.library.controller.command.webCommand.impl.ViewAllBooksInAllCatalogsWeb;
import com.redcompany.red.library.controller.command.webCommand.impl.TwoActionImpl;

public class CommandManagerWeb {

    public static BasicCommandWeb defineAction(String action) {
        switch (action) {
            case "1":
                return new ViewAllBooksInAllCatalogsWeb();
            case "2":
                return new TwoActionImpl();
            default:
                return new DefaultActionImpl();
        }
    }
}
