package uz.isystem.bookshop.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("books"))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String title;

    private Double price;

    private String bookImage;

    private Boolean status;

    @Column(name = ("published_at"))
    private LocalDateTime publishedAt;

    @Column(name = ("created_at"))
    private LocalDateTime createAt;

    @Column(name = ("update_at"))
    private LocalDateTime updateAt;

    @Column(name = ("delete_at"))
    private LocalDateTime deleteAt;
}
