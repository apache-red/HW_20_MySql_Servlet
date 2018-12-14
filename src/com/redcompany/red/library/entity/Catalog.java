package com.redcompany.red.library.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Catalog {


    private String responsiblePerson;
    private Date creationData;
    private List<Book> books;

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Date getCreationData() {
        return creationData;
    }

    public void setCreationData(Date creationData) {
        this.creationData = creationData;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBookToCatalog(Book book) {
        books.add(book);
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(responsiblePerson, catalog.responsiblePerson) &&
                Objects.equals(creationData, catalog.creationData) &&
                Objects.equals(books, catalog.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responsiblePerson, creationData, books);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "responsiblePerson='" + responsiblePerson + '\'' +
                ", creationData=" + creationData +
                ", books=" + books +
                '}';
    }
}
