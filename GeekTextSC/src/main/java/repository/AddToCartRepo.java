package repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import dto.AddToCartDto;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToCartRepo extends JpaRepository<AddToCartRepo,Long> {

    @SuppressWarnings("JpaQlInspection")
    @Query("Select sum(add.Cart.price) FROM AddtoCartDto WHERE addCart.userID")
    double getTotalAmountByUserId(@Param(userID)Long userID);
    @Query(Select addCart FROM AddToCartDto addCart WHERE addCart.userID=:userID)
    List<AddToCartDto> getCartByuserId(@Param("userID")Long userID);
    @Query("Select AddtoCartDto from AddtoCart addCart ")
    Optional<AddToCartDto> getCartByuserIDtest();
    @Query("select  addCart FROM AddtoCartDto addCart where addCart.product.id= :Bookname and addCart.userID=:userID")
    Optional<AddToCartDto> getCartByBookNameAnduserID(@Param("userId")Long userID,@Param("BookName")Long BookName);
    @Modifying
    @Transactional
    @Query("DELETE FROM AddtoCartDto addCart WHERE addCart.id =:BookName and addCart.userID=:userID")
    void deleteCartbyIdAndUserId(@Param("userID")Long userID);

    @Modifying
    @Transactional
    @Query("DELETE from AddtoCartDto addCart WHERE addCart.userID=:userID")
    void deleteAllCartUserId(@Param("userID")Long userID);
    @Modifying
    @Transactional
    @Query("update AddtoCartDto addCart set addCart.quantity=:quantity,addCart.price=:price where addCart.id=:BookName")
    void updateQuantityByBookName(@Param("BookName")Long BookName,@Param("price")double price,@Param("quantity")Integer quantity);

}
