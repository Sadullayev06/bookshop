package uz.isystem.bookshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFiltr extends FilterDto{

    private Integer id;

    private String name;

    private String surname;

    private String password;

    private String contact;

    private Boolean city;

    private Integer email;

    private Boolean status;
}
