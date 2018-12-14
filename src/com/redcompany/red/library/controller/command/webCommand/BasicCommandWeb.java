package com.redcompany.red.library.controller.command.webCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface BasicCommandWeb {

    void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
