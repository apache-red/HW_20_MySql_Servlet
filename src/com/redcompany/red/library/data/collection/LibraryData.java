package com.redcompany.red.library.data.collection;

import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LibraryData implements LibraryCommand {

    private Library library;
    private Catalog catalog;

    private List<Catalog> catalogList;


    private int idBook;


    public LibraryData() {
        initLibrary();
    }


    @Override
    public Library getLibrary() {
        return library;
    }

    @Override
    public void addNewBook(String whichCatalog , String title) {
        for (int i = 0; i < catalogList.size() ; i++) {
            catalog = catalogList.get(i);
            if (catalog.getResponsiblePerson().equals(whichCatalog)){
                catalog.addBookToCatalog(new Book(++idBook , title));
                break;
            }
        }
    }


    private Library initLibrary() {
        //создаю библиотеку
        this.library = new Library();
        catalog = initCatalog("Ivan Ivanov");
        //создаю новый каталог c каталогами авторов
        catalogList = library.createNewCatalogList();
        // передаю каталог в каталог лист
         catalogList.add(catalog);

         // создаю еще один каталог
         catalog = initCatalog("Petya Petrov");
        catalogList.add(catalog);

        catalog = initCatalog("Vasya Vasiliev");
        catalogList.add(catalog);


        return library;
    }

    private Catalog initCatalog(String catalogName) {
        // создаю каталог и настраиваю его. HARDCODE!
        catalog = library.createNewCatalogInLibrary();
        catalog.setCreationData(new Date());
        catalog.setResponsiblePerson(catalogName);
        catalog.setBooks(ininBookList());

               return catalog;
    }

    private List<Book> ininBookList() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(++idBook, "Book"+ (1 + (int) (Math.random() * 1000))));
        bookList.add(new Book(++idBook, "Book"+ (1 + (int) (Math.random() * 1000))));
        bookList.add(new Book(++idBook, "Book"+ (1 + (int) (Math.random() * 1000))));
        bookList.add(new Book(++idBook, "Book"+ (1 + (int) (Math.random() * 1000))));
        bookList.add(new Book(++idBook, "Book"+ (1 + (int) (Math.random() * 1000))));
        return bookList;
    }




}
