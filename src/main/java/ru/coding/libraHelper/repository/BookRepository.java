package ru.coding.libraHelper.repository;

import org.springframework.data.repository.CrudRepository;
import ru.coding.libraHelper.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
