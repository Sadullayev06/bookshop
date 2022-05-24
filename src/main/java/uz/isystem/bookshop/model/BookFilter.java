package uz.isystem.bookshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookFilter extends FilterDto {

    private Integer id;

    private String author;

    private String title;

    private Double price;

    private String bookImage;

    private Boolean status;




}
