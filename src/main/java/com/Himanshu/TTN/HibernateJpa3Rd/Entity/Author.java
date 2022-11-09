package com.Himanshu.TTN.HibernateJpa3Rd.Entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Embedded
   private Address address;

    @Column(name = "subjectlist")
    @ElementCollection(targetClass = Subject.class)
    private List<Subject> subjects;





    //one to one mapping
    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL)
    private Book bok;
    public Book getBok() {
        return bok;
    }
    public void setBok(Book bok) {
        this.bok = bok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<javax.security.auth.Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(HashSet<Book> book) {
        this.book = book;
    }

    public Set<Book> getBookSet() {
        return book;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.book = bookSet;
    }

    //one to many
    //Uncoomment to Use @OneToMany mapping
    //gets unidirectional if we don't use @ManytoOne in other relevant Entity class

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book>book;


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //many to many mappings
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Author_book",joinColumns = @JoinColumn(name = "author_id",referencedColumnName ="id")
            ,inverseJoinColumns =@JoinColumn(name = "book_id",referencedColumnName = "id") )
    private Set<Book> books;

    public void addBook(Book book) {
        if (book != null) {
            if (books == null) {
                books = new HashSet<>();
            }
            book.setAuthor(this);
            books.add(book);
        }
    }
}
