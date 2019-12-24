package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.BookMapper;

@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;
	public int addBook(Book book) {
		return bookMapper.addBook(book);
	}
	public int updateBook(Book book) {
		return bookMapper.updateBookById(book);
	}
	public int deleteBookById(Integer id) {
		return bookMapper.deleteBookById(id);
	}
	public Book getBookById(Integer id) {
		return bookMapper.getBookById(id);
	}
	public List<Book> getAllBooks(){
		return bookMapper.getAllBooks();
	}
	@RestController
	public class BookController{
		@Autowired
		BookService bookService;
		@GetMapping("/bookOps")
		public void bookOps() {
			Book b1 = new Book();
			b1.setName("firstname");
			b1.setAuthor("firstauthor");
			int i = bookService.addBook(b1);
			System.out.println("addBook>>>" + i);
			Book b2 = new Book();
			b2.setId(1);
			b2.setName("secondname");
			b2.setAuthor("secondauthor");
			int updateBook = bookService.updateBook(b2);
			System.out.println("updateBook>>>" + updateBook);
			Book b3 = bookService.getBookById(1);
			System.out.println("getBookById>>>"+b3);
			int delete = bookService.deleteBookById(2);
			System.out.println("deleteBook>>>" + delete);
			List<Book> allBooks = bookService.getAllBooks();
			System.out.println("getAllBooks>>>" + allBooks);
		}
	}
	
}
