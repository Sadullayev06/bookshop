package uz.isystem.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.bookshop.dto.CustomerDto;
import uz.isystem.bookshop.dto.OrderDto;
import uz.isystem.bookshop.exception.BadRequest;
import uz.isystem.bookshop.model.Customer;
import uz.isystem.bookshop.model.Order;
import uz.isystem.bookshop.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto create(CustomerDto customerDto) {
        Customer customer = new Customer();
        convertDtoToEntity(customerDto,customer);
        customer.setStatus(true);
        customer.setCreateAt(LocalDateTime.now());
        customerRepository.save(customer);
        customerDto.setId(customer.getId());
        return customerDto;
    }

    public CustomerDto get(Integer id) {
        Customer customer = check(id);
        CustomerDto customerDto = new CustomerDto();
        convertEntityToDto(customer,customerDto);
        return customerDto;
    }

    public boolean update(Integer id, CustomerDto customer) {

        Customer update = check(id);
        convertDtoToEntity(customer,update);
        update.setUpdateAt(LocalDateTime.now());
        customerRepository.save(update);
        return true;
    }

    public boolean delete(Integer id,CustomerDto customerDto) {
        Customer delete = check(id);
        convertDtoToEntity(customerDto,delete);
        delete.setDeleteAt(LocalDateTime.now());
        customerRepository.delete(delete);
        return true;
    }




    public Customer check(Integer id) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Doctor not found");//throw new BadRequest("Doctor not found");
        }
        return optional.get();
    }


private void convertEntityToDto(Customer entity,CustomerDto dto){
        dto.setCity(entity.getCity());
        dto.setContact(entity.getContact());
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        dto.setSurname(entity.getSurname());
}

private void convertDtoToEntity(CustomerDto dto,Customer entity){
        entity.setCity(dto.getCity());
        entity.setContact(dto.getContact());
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPassword(dto.getPassword());
}







}
