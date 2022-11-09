package com.Himanshu.TTN.HibernateJpa3Rd.Repository;

import com.Himanshu.TTN.HibernateJpa3Rd.Entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {
}
