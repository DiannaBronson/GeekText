package service;

import dto.AddToCartDto;
import dto.CartDto;
import exceptions.AuthenticationFailException;
import model.Cart;
import model.CartCost;
import org.jvnet.hk2.annotations.Service;
import repository.CartRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AddtoCartController {
    private final CartRepository cartRepository;

    public AddtoCartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public Cart addToCart(AddToCartDto addToCartDto, int userId) {
        Cart cart =new Cart(AddToCartDto, userId);
        return cart;
    }

    public CartCost listCartItems(int userID) {
        List<Cart> cartList = cartRepository.findAllbyUserIdOrderByuserID(userID);
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList) {
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }

        double totalCost = 0;
        for (CartDto cartDto:cartItems) {
            totalCost += (cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }

    public static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }

    public void updateCartItem(AddToCartDto cartDto, int userId) {
        Cart cart = getAddToCartDto(cartDto, userId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setUserid(userId);
        cart.setId(cartDto.getId());
        cartRepository.save(cart);
    }

    private Cart getAddToCartDto(AddToCartDto cartDto, int userId) {
    }

    public void deleteCartItem(int id, int userId) {
        if (!cartRepository.existsById(id))
            throw new AuthenticationFailException("Book id is invalid : " + id);
        cartRepository.deleteById(id);
    }
}
