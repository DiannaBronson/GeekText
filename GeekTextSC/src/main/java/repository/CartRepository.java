package repository;

import model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUseridOrderByProductId(Integer userId);
}