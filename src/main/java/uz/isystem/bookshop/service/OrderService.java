package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.OrderDto;
import uz.isystem.bookshop.exception.BadRequest;
import uz.isystem.bookshop.model.Order;
import uz.isystem.bookshop.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerService customerService;


    public OrderDto create(OrderDto orderDto) {
        Order order = new Order();
        convertDtoToEntity(orderDto,order);
        order.setStatus(true);
        order.setCreateAt(LocalDateTime.now());
        orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    public OrderDto get(Integer id) {
        Order order = check(id);
        OrderDto orderDto = new OrderDto();
        convertEntitiyToDto(order,orderDto);
        return orderDto;
    }

    public boolean update(Integer id, OrderDto orderDto) {
//        Order order = new Order();
//        convertDtoToEntity(orderDto,order);
//        order.setUpdateAt(LocalDateTime.now());
        Order update = check(id);
        convertDtoToEntity(orderDto,update);
        update.setUpdateAt(LocalDateTime.now());
        orderRepository.save(update);
        return true;
    }

    public boolean delete(Integer id,OrderDto orderDto) {

        Order delete = check(id);
        convertDtoToEntity(orderDto,delete);
        delete.setDeleteAt(LocalDateTime.now());
        orderRepository.delete(delete);
        return true;
    }


    public Order check(Integer id){
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Order Not Fpund!");
        }
        return optional.get();
    }


    private void convertEntitiyToDto(Order entitiy,OrderDto dto){
        dto.setBook(entitiy.getBook());
        dto.setCustomer(entitiy.getCustomer());
        dto.setQuantity(entitiy.getQuantity());
        dto.setTotalPrice(entitiy.getTotalPrice());
        dto.setUserId(entitiy.getUserId());

    }

    private void convertDtoToEntity(OrderDto dto,Order entity){
        entity.setBook(dto.getBook());
        entity.setCustomer(dto.getCustomer());
        entity.setQuantity(dto.getQuantity());
        entity.setTotalPrice(dto.getTotalPrice());
    }


}
