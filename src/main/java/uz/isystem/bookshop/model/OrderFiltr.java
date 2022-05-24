package uz.isystem.bookshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderFiltr extends FilterDto{

    private Integer id;

    private Integer quantity;

    private Double totalPrice;



}
