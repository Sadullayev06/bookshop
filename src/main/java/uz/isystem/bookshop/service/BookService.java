package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.BookDto;
import uz.isystem.bookshop.exception.BadRequest;
import uz.isystem.bookshop.model.Book;
import uz.isystem.bookshop.repository.BookRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookDto create(BookDto bookDto) {
        Book book = new Book();
        convertDtoToEntity(bookDto,book);
        book.setStatus(true);
        book.setPublishedAt(LocalDateTime.now());
        book.setCreateAt(LocalDateTime.now());
        bookRepository.save(book);
        bookDto.setId(book.getId());
        return bookDto;
    }

    public BookDto get(Integer id) {
        Book book = check(id);
        BookDto bookDto = new BookDto();
        convertEntityToDto(book,bookDto);
        return bookDto;
    }

    public boolean update(Integer id, BookDto book) {

        Book update = check(id);
        convertDtoToEntity(book,update);
        update.setUpdateAt(LocalDateTime.now());
        bookRepository.save(update);
        return true;
    }

    public boolean delete(Integer id,BookDto bookDto) {
        Book delete = check(id);
        convertDtoToEntity(bookDto,delete);
        delete.setDeleteAt(LocalDateTime.now());
        bookRepository.delete(delete);
        return true;
    }

    public Book check(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Doctor not found");
        }
        return optional.get();
    }


    private void convertEntityToDto(Book entity,BookDto dto){
        dto.setBookImage(entity.getBookImage());
        dto.setAuthor(entity.getAuthor());
        dto.setPrice(entity.getPrice());
        dto.setTitle(entity.getTitle());
    }

    private void convertDtoToEntity(BookDto dto, Book entity){
        entity.setBookImage(dto.getBookImage());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());
        entity.setTitle(dto.getTitle());
    }



}
