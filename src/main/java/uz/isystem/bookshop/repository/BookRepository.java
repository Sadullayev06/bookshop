package uz.isystem.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.bookshop.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
