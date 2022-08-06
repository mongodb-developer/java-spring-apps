package com.palmer.rachelle.javaspringmongodb.controller;

import com.palmer.rachelle.javaspringmongodb.model.Book;
import com.palmer.rachelle.javaspringmongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Handles listing of all books and searching.
     * @param model
     * @return
     */
    @GetMapping({"/index", "/search"})
    public String showBooks(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("books",
                this.bookRepository.findByTitleStartsWithOrAuthor(keyword, keyword));
            model.addAttribute("keyword", keyword);
        } else {
            List<Book> books = this.bookRepository.findAll();
            model.addAttribute("books", books);
        }
        return "index";
    }

    /**
     * Show form for adding a book document
     * @param book
     * @return
     */
    @GetMapping("/add-book")
    public String showAddBookForm(Book book) {
        return "add-book";
    }

    /**
     * This will CREATE a books. C of CRUD.
     * @param book
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/add-book")
    public String addBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        this.bookRepository.save(book);
        return "redirect:/index";
    }

    /**
     * Show form for editing a book document. The R in CRUD.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit-book/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);

        return "edit-book";
    }

    /**
     * This will update a book document. The U in CRUD
     * @param id
     * @param book
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/edit-book/{id}")
    public String updateBook(@PathVariable("id") String id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setId(id);
            return "edit-book";
        }

        this.bookRepository.save(book);

        return "redirect:/index";
    }

    /**
     * This will delete a book document. The D in CRUD.
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete-book/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        this.bookRepository.delete(book);

        return "redirect:/index";
    }
}
