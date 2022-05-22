package uz.isystem.bookshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("orders"))
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = ("book_id"),insertable = false,updatable = false)
    private Book book;

    @Column(name = ("book_id"))
    private Integer bookId;

    @ManyToOne
    @JoinColumn(name = ("user_id"),insertable = false,updatable = false)
    private Customer customer;

    @Column(name = ("user_id"))
    private Integer userId;

    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createAt;

    @Column(name = ("update_at"))
    private LocalDateTime updateAt;

    @Column(name = ("delete_at"))
    private LocalDateTime deleteAt;
}
