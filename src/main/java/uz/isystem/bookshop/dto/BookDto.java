package uz.isystem.bookshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {
    private Integer id;
    @NotBlank(message = ("author da xatolik mavjud"))
    private String author;
    @NotBlank(message = ("title da xatolik"))
    private String title;
    @NotBlank(message = ("price da xatolik"))
    private Double price;
    private String bookImage;
    private Boolean status;
    private LocalDateTime publishedAt;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
