package com.Himanshu.TTN.HibernateJpa3Rd;

import com.Himanshu.TTN.HibernateJpa3Rd.Entity.Address;
import com.Himanshu.TTN.HibernateJpa3Rd.Entity.Author;
import com.Himanshu.TTN.HibernateJpa3Rd.Entity.Book;
import com.Himanshu.TTN.HibernateJpa3Rd.Repository.AuthorRepo;
import com.Himanshu.TTN.HibernateJpa3Rd.Repository.BookRepository;
import com.mysql.cj.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.security.auth.Subject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class HibernateJpa3RdApplicationTests {
	@Autowired
	AuthorRepo authorRepo;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateAuthor() {
		ArrayList<Subject> list = new ArrayList<>();
		list.add(new Subject("DAA+"));
		list.add(new Subject("MPOB"));
		list.add(new Subject("AIML"));
		Author author = new Author();
		Address address = new Address();
		address.setStreetNumber(3911);
		address.setLocation("Saharsa");
		address.setState("Bihar");
		author.setName("Sneha");
		author.setAddress(address);
		author.setSubjects(list);

		authorRepo.save(author);
	}
	//one to one mapping
	@Test
	@Transactional
	public void testOneToOne(){
		Book book1=new Book();
		book1.setBookName("in 28 minutes");
		Author author1=new Author();
		author1.setName("john macrathy");
		author1.setBok(book1);
		bookRepository.save(book1);
	}
	@Test
	//one to many And many to one
	public void testCreateAuthorForOneToMany() {

			Author author = new Author();
			author.setName("john pareyl");
			HashSet<Book>books=new HashSet<>();
			Book b1 = new Book();
			b1.setBookName("Java - A Complete Reference");
			Book b2 = new Book();
			b2.setBookName("Head First - Java");
			books.add(b1);
			books.add(b2);
			author.setBook(books);
			authorRepo.save(author);
		}

		//many to many test
	@Test

		public void testManytoMany(){
		Author author=new Author();
		author.setName("bill dackson");

		HashSet<Book> books = new HashSet<>();

		Book b2=new Book();
		Book b3=new Book();
		b2.setBookName("introduction to spring data jpa");
		b3.setBookName("ethical hacking");
		books.add(b2);
		books.add(b3);
		author.setBook(books);
		authorRepo.save(author);

		}
	@Test
	@Transactional
	public void testCaching() {
		authorRepo.findById(1);
		authorRepo.findById(1);
	}
	//for level 1 caching to work, we need to mark it with @Transactional from spring package,
	// Spring creates level 1 caching for the Spring session associated with the transaction and for it to work we need to mark it with this annotation.
	//Evict method is used on the session object to remove an object from the cache.
	@Test
	@Transactional
	public void testEvict() {
		Session session = entityManager.unwrap(Session.class);
		Author curr = authorRepo.findById(1).get();

		authorRepo.findById(1);

		//If comment this part only 1 select query will show in console.
		session.evict(curr);

		authorRepo.findById(1);
	}

}
