package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.CustomerDto;
import uz.isystem.bookshop.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto create(CustomerDto customer) {
        return null;
    }

    public CustomerDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, CustomerDto customer) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
