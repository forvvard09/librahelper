package ru.coding.libraHelper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.coding.libraHelper.model.Book;
import ru.coding.libraHelper.repository.BookRepository;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books);
        return "main";
    }

    @PostMapping("add")
    public String add(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        Book book = new Book(name, description);
        bookRepository.save(book);
        Iterable<Book> books = bookRepository.findAll();
        model.put("books", books);
        return "main";
    }
}
