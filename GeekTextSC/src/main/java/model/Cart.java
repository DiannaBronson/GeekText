package model;

import dto.CartDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Users")
@SecondaryTable(name = "BookInfo")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "userID")
    private @NotBlank Integer userid;

    @Column(name = "Bookname")
    private @NotBlank long productId;

    @ManyToOne
    @JoinColumn(name = "BookInfo", referencedColumnName = "Bookname", insertable = false, updatable = false)
    private  productId;

    private int quantity;

    public Cart() {

    }

    public Cart(CartDto cartDto, Bookname product, int userid) {
        this.userid = userid;
        this.productId = cartDto.getproductId();
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, productId) {
        this.productId = cartDto.getProductId();
        this.quantity = cartDto.getQuantity();
        this.productId = productId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return productId;
    }

    public void setProduct(Product product) {
        this.productId = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}