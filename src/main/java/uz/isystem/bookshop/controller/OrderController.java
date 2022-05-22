package uz.isystem.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.bookshop.dto.CustomerDto;
import uz.isystem.bookshop.dto.OrderDto;
import uz.isystem.bookshop.service.BookService;
import uz.isystem.bookshop.service.CustomerService;
import uz.isystem.bookshop.service.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid OrderDto order){
        OrderDto result = orderService.create(order);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        OrderDto result = orderService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid OrderDto order){
        boolean result = orderService.update(id,order);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = orderService.delete(id);
        return ResponseEntity.ok(result);
    }
}
