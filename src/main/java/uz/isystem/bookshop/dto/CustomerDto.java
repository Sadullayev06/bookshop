package uz.isystem.bookshop.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
    private Integer id;
    @NotBlank(message = ("Ismda xatolik bor"))
    private String name;
    @NotBlank(message = ("Familiyasida xatolik bor"))
    private String surname;
    @NotNull(message = ("password da xatolik bor"))
    @NotEmpty(message = ("password bosh bolishi mumkin emas"))
    private String password;
    @Size(min = 12 , max = 13 , message = ("contactni togri kirit"))
    private String contact;
    private Boolean city;
    private Integer email;
    private Boolean status;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
