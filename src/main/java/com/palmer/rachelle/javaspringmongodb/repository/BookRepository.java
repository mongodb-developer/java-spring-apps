package com.palmer.rachelle.javaspringmongodb.repository;

import com.palmer.rachelle.javaspringmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByTitleStartsWithOrAuthor(String title, String author);
}
