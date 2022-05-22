package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.BookDto;
import uz.isystem.bookshop.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto create(BookDto book) {
        return null;
    }

    public BookDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, BookDto book) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
