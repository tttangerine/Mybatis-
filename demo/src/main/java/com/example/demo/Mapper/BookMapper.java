package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Book;

@Mapper
public interface BookMapper {
	int addBook(Book book);
	int deleteBookById(Integer id);
	int updateBookById(Book book);
	Book getBookById(Integer id);
	List<Book> getAllBooks();
}
