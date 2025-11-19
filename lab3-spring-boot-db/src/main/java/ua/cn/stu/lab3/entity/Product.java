package ua.cn.stu.lab3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Product name is required")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁёЇїІіЄєҐґ'\\-\\s0-9]{2,100}$", message = "Product name must be 2-100 characters long and contain only letters...")
    private String name;

    @NotNull(message="Product sku is required")
    @Positive(message="Product sku must be a positive number")
    // @Pattern(regexp = "^[0-9]{5,20}$", message = "Product sku must be 5-20 characters long and contain only numbers")
    private Integer sku;

    @NotNull(message="Product price is required")
    @Positive(message="Product price must be a positive number")
    // @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,4})?$", message = "Product price must be a valid number with up to four decimal places")
    private Integer price;

    @ManyToOne
    @JoinColumn(name="supplier_id", nullable=false)
    private Supplier supplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    
}
