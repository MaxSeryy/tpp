package ua.cn.stu.lab3.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "firms")
public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Ohm Zone ? idk
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁёЏїІіЄєҐґ'\\-\\s0-9]{2,50}$", message = "Name must be 2-50 characters long and contain only letters, spaces, apostrophes, and hyphens")
    private String name;

    @Pattern(regexp = "^[A-Za-zА-Яа-яЁёЇїІіЄєҐґ'\\-\\s0-9]{2,100}$",
            message = "Address must be 2-100 characters long and contain only letters, spaces, apostrophes, hyphens, and digits (0-9)")
    private String address;

    @OneToMany(mappedBy = "firm", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Supplier> suppliers;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.util.List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(java.util.List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

}
