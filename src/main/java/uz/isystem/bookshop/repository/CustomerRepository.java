package uz.isystem.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.bookshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
