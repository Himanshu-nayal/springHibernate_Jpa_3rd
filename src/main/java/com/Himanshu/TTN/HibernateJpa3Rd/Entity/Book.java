package com.Himanshu.TTN.HibernateJpa3Rd.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    //manyToOne mapping
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author1;
    public Author getAuthor1() {
        return author1;
    }
    public void setAuthor1(Author author1) {
        this.author1 = author1;
    }
    //one to one mapping
    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }




    //mamy to many mapping
    @ManyToMany(mappedBy = "books")
     private Set<Author> authors;
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

}
