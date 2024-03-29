package de.aittr.g_27_shop_project.domain.jpa;

import de.aittr.g_27_shop_project.domain.interfaces.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Entity
@Table(name = "product")
public class JpaProduct implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Было минимум 4 буквы, одна большая, остальные маленькие
    // Test - ok
    // TEST - X
    // Tes - x
    // TEst - x
    // test - x
    // Test@ - x
    // Test7 - x
    @Column(name = "name")
    //@NotNull
    //@NotBlank
    @Pattern(regexp = "[A-Z][a-z]{3,}")
    private String name;
    @Column(name = "price")
    @Max(90000)
    @Min(10)
    private double price;
    @Column(name = "is_active")
    private boolean isActive;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public JpaProduct(int id, String name, double price, boolean isActive) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isActive = isActive;
    }

    public JpaProduct() {
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaProduct that = (JpaProduct) o;
        return id == that.id && Double.compare(that.price, price) == 0 && isActive == that.isActive && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, isActive);
    }

    @Override
    public String toString() {
        return "JpaProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}