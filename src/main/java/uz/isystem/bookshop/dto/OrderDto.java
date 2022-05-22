package uz.isystem.bookshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import uz.isystem.bookshop.model.Book;
import uz.isystem.bookshop.model.Customer;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Integer id;
    @NotBlank(message = ("quantity da xatolik"))
    private Integer quantity;
    @NotBlank(message = ("totalprice da xatolik mavjud"))
    private Double totalPrice;
    private Book book;
    private Integer bookId;
    private Customer customer;
    private Integer userId;
    private Boolean status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
