package uz.isystem.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.bookshop.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
