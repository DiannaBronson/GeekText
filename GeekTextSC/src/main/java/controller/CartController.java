package controller;

import dto.AddToCartDto;
import exceptions.AuthenticationFailException;
import model.CartCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.lang.String;
import service.AddtoCartController;
import service.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private AddtoCartController addtoCartController;


    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException {
        AuthenticationService.authenticate(token);

        int userId = AuthenticationService.getUser(token).getId();

        addtoCartController.addToCart(addToCartDto, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<CartCost> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        AuthenticationService.authenticate(token);
        int userId = AuthenticationService.getUser(token);
        CartCost cartCost = addtoCartController.listCartItems(userId);
        return new ResponseEntity<CartCost>(cartCost, HttpStatus.OK);
    }

    @PutMapping("/update/{BookName}")
    public ResponseEntity<ApiResponse> updateBookName(@RequestBody @Valid AddToCartDto cartDto,
                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
        authenticationService.authenticate(token);
        int userId = AuthenticationService.getUser(token).getId();

        Product product = productService.getProductById(cartDto.getProductId());

        addtoCartController.updateCartItem(cartDto, userId, product);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
        AuthenticationService.authenticate(token);

        int userId = AuthenticationService.getUser(token).getId();

        addtoCartController.deleteCartItem(itemID, userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
}
