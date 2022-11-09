package com.Himanshu.TTN.HibernateJpa3Rd.Repository;

import com.Himanshu.TTN.HibernateJpa3Rd.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
