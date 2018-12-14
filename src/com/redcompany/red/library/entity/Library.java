package com.redcompany.red.library.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private final String libraryName = "MyLibrary";
    private List<Catalog> catalogList;

    private Catalog catalog;




    public void addCatalogToLibrary(Catalog catalog){
        catalogList.add(catalog);
    }

    public  Catalog getCatalogFromCatalogList(Library library, int catalogNumber){
       return library.catalogList.get(catalogNumber);
    }

    public Catalog createNewCatalogInLibrary(){
        return this.catalog = new Catalog();
    }
    public  List<Catalog> createNewCatalogList(){
        return catalogList = new ArrayList<>();
    }


    public List<Catalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.catalogList = catalogList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(libraryName, library.libraryName) &&
                Objects.equals(catalogList, library.catalogList) &&
                Objects.equals(catalog, library.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryName, catalogList, catalog);
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", catalogList=" + catalogList +
                ", catalog=" + catalog +
                '}';
    }
}
