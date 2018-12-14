package com.redcompany.red.library.service.impl;

import com.redcompany.red.library.data.collection.LibraryCommand;
import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;
import com.redcompany.red.library.service.LibraryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegularLibraryServiceImpl implements LibraryService {

    private LibraryCommand libraryCommand;
    private Library library;
    private Catalog catalog;
    private List<Catalog> catalogList;
    private List<Book> bookList;


    @Override
    public List<Catalog> getCatalogListFromLibrary(LibraryCommand libraryCommand) {
        library = libraryCommand.getLibrary();
        return library.getCatalogList();
    }

    @Override
    public Book getBookFromCatalog(Map<String, Object> userdata, LibraryCommand libraryCommand) {
        int catalogNumber = 1;
        int rowNumber = 1;
        catalogNumber = (int) userdata.get("catalog_number");
        rowNumber = (int) userdata.get("row_number");
        catalogList = getCatalogListFromLibrary(libraryCommand);
        catalog = catalogList.get(catalogNumber);
        bookList = catalog.getBooks();
        return bookList.get(rowNumber);
    }

    @Override
    public List<Book> findBookByNameInCatalog(Map<String, Object> userdata, LibraryCommand libraryCommand) {
        List<Book> foundBooksList = new ArrayList<>();
        String findBookTitle = (String)userdata.get("book_title");
        catalogList = getCatalogListFromLibrary(libraryCommand);
        for (int i = 0; i <catalogList.size() ; i++) {
            catalog = catalogList.get(i);
            for (int j = 0; j < catalog.getBooks().size(); j++) {
                if (catalog.getBooks().get(j).getTitle().equals(findBookTitle)) {
                    foundBooksList.add(catalog.getBooks().get(j));
                }
            }
        }
        return foundBooksList;
    }

    @Override
    public void addNewBookToCatalog(Map<String, Object> userdata, LibraryCommand libraryCommand) {
        String whichCatalog = (String) userdata.get("which_catalog");
        String titleNewBook = (String) userdata.get("book_title");
        catalogList = getCatalogListFromLibrary(libraryCommand);
        libraryCommand.addNewBook(whichCatalog, titleNewBook);
    }

    @Override
    public List<Book> findBookByAuthorInCatalog(Map<String, Object> userdata, LibraryCommand libraryCommand) {
        String findauthorName = (String) userdata.get("find_author");
        catalogList = getCatalogListFromLibrary(libraryCommand);
        for (int i = 0; i <catalogList.size() ; i++) {
            catalog = catalogList.get(i);
            if (catalog.getResponsiblePerson().equals(findauthorName)){
                return bookList = catalog.getBooks();
            }
        }
        return null;
    }


//    private LibraryData libraryData;
//    private CatalogService catalogService;


//    @Override
//    public LibraryData getLibrary() {
//
//
//        return libraryData;
//    }
}
