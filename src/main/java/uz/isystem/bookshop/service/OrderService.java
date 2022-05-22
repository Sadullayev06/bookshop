package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.OrderDto;
import uz.isystem.bookshop.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;

    public OrderDto create(OrderDto order) {
        return null;
    }

    public OrderDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, OrderDto order) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
