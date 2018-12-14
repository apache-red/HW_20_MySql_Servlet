package com.redcompany.red.library.data.collection;


import com.redcompany.red.library.entity.Library;

public interface LibraryCommand {

    Library getLibrary();

    void addNewBook(String whichCatalog, String title);
}
