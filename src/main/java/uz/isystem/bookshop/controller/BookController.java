package uz.isystem.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.bookshop.dto.BookDto;
import uz.isystem.bookshop.service.BookService;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid BookDto book){
        BookDto result = bookService.create(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        BookDto result = bookService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid BookDto book){
        boolean result = bookService.update(id,book);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id,@RequestBody @Valid BookDto bookDto){
        boolean result = bookService.delete(id,bookDto);
        return ResponseEntity.ok(result);
    }
}
